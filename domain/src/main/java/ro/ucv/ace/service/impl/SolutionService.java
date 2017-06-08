package ro.ucv.ace.service.impl;

import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IPathBuilder;
import ro.ucv.ace.builder.ISolutionBuilder;
import ro.ucv.ace.dto.other.ResponseMessageDto;
import ro.ucv.ace.dto.solution.ESSolutionDto;
import ro.ucv.ace.exception.DeadlinePassedException;
import ro.ucv.ace.exception.EntityNotFoundException;
import ro.ucv.ace.model.*;
import ro.ucv.ace.repository.ISolutionRepository;
import ro.ucv.ace.repository.IStudentRepository;
import ro.ucv.ace.repository.ITaskRepository;
import ro.ucv.ace.service.ISolutionService;
import ro.ucv.ace.utility.IUnzipper;
import ro.ucv.ace.utility.impl.Content;
import ro.ucv.ace.utility.impl.Node;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tzapt on 12/4/2016.
 */
@Service("solutionService")
@Transactional(rollbackFor = Exception.class)
public class SolutionService implements ISolutionService {

    @Autowired
    private ISolutionRepository solutionRepository;

    @Autowired
    private ISolutionBuilder solutionBuilder;

    @Autowired
    private IPathBuilder pathBuilder;

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private IUnzipper unzipper;

    @Value("#{'${folder.permittedExtensions}'.split(',')}")
    public List<String> permittedExtensions;

    @Override
    public ResponseMessageDto save(int studentId, int taskId, ESSolutionDto solutionDto) {
        Student student = studentRepository.findOne(studentId);
        Task task = taskRepository.findOne(taskId);
        Professor professor = task.getTopic().getProfessor();
        Topic topic = task.getTopic();

        ResponseMessageDto messageDto;

        LocalDate currentDate = LocalDate.now();
        if (task.getDeadline().isBefore(currentDate)) {
            throw new DeadlinePassedException("You can no longer submit solution for this task.Deadline has passed.");
        }

        String stringPath = pathBuilder.buildAbsoluteStudentSolutionFolderPath(professor.getId(), topic.getId(), taskId, studentId);

        Path path = Paths.get(stringPath);
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);

            } else {
                FileUtils.deleteDirectory(new File(stringPath));
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] zipFile = Base64.decodeBase64(solutionDto.getInputFile());
        String zipPath = stringPath + File.separator + "test.zip";

        //Saves zip, extracts it and then deletes it
        try {
            try (OutputStream stream = new FileOutputStream(zipPath)) {
                stream.write(zipFile);
            }
            unzipper.unzip(zipPath, stringPath);
            Path zip = Paths.get(zipPath);
            Files.delete(zip);
        } catch (IOException | ZipException e) {
            e.printStackTrace();
        }


        try {
            Solution solution = task.getSolutionByStudent(studentId);
            solutionRepository.delete(solution.getId());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        Solution solution = solutionBuilder.build(student, task,
                pathBuilder.buildRelativeStudentSolutionFolderPath(professor.getId(), topic.getId(), taskId, studentId));

        messageDto = task.addSolution(solution);
        taskRepository.save(task);
        solutionRepository.save(solution);

        return messageDto;
    }

    @Override
    public Node getSolutionFolderStructure(int solutionId) {
        Solution solution = solutionRepository.findOne(solutionId);
        String absolutePath = pathBuilder.buildAbsoluteStudentSolutionFolderPath(solution.getDirectoryPath());
        Node node = new Node(solution.getTask().getName(), absolutePath, false, "");
        listFiles(new File(absolutePath), node);

        return node;
    }

    @Override
    public Content getFileContent(String filePath) {
        try {
            return new Content(new Scanner(new File(filePath)).useDelimiter("\\Z").next());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
    }

    private void listFiles(File root, Node parent) {
        File[] files = root.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            String extension = FilenameUtils.getExtension(file.getAbsolutePath());
            if (!file.isDirectory() && !permittedExtensions.contains(extension)) {
                continue;
            }

            if (file.isDirectory()) {
                Node node = new Node(file.getName(), file.getPath(), false, extension);
                parent.addChild(node);
                listFiles(file, node);
            } else {
                parent.addChild(new Node(file.getName(), file.getPath(), true, extension));
            }
        }
    }
}
