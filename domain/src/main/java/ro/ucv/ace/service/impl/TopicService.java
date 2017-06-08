package ro.ucv.ace.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IPathBuilder;
import ro.ucv.ace.builder.ITopicBuilder;
import ro.ucv.ace.dto.task.StudentTaskDto;
import ro.ucv.ace.dto.topic.ESTopicDto;
import ro.ucv.ace.dto.topic.StudentTopicDto;
import ro.ucv.ace.dto.topic.TopicDto;
import ro.ucv.ace.exception.DuplicateEntryException;
import ro.ucv.ace.exception.EntityNotFoundException;
import ro.ucv.ace.model.*;
import ro.ucv.ace.repository.ISolutionRepository;
import ro.ucv.ace.repository.ITopicRepository;
import ro.ucv.ace.repository.impl.ProfessorRepository;
import ro.ucv.ace.service.ITopicService;
import ro.ucv.ace.visitor.StudentTaskVisitor;
import ro.ucv.ace.visitor.StudentTopicVisitor;
import ro.ucv.ace.visitor.TopicVisitor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by tzapt on 11/26/2016.
 */
@Service("topicService")
@Transactional(rollbackFor = Exception.class)
public class TopicService implements ITopicService {

    @Autowired
    private ITopicRepository topicRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private TopicVisitor visitor;

    @Autowired
    private ITopicBuilder topicBuilder;

    @Autowired
    private IPathBuilder pathBuilder;

    @Autowired
    private StudentTaskVisitor studentTaskVisitor;

    @Autowired
    private StudentTopicVisitor studentTopicVisitor;

    @Autowired
    private ISolutionRepository solutionRepository;

    @Override
    public TopicDto save(int professorId, ESTopicDto topicDto) {
        Professor professor = professorRepository.findOne(professorId);

        if (professor.hasTopicWithName(topicDto.getName())) {
            throw new DuplicateEntryException("Topic: Duplicate entry '" + topicDto.getName() + "' for Professor with id " + professorId);
        }

        Topic topic = topicRepository.save(topicBuilder.build(topicDto, professorId));
        topic.accept(visitor);

        return visitor.getTopicDto();

    }

    @Override
    public List<TopicDto> getAll(int professorId) {
        List<Topic> topics = topicRepository.findByProfessor(professorId);
        List<TopicDto> topicDtos = new ArrayList<>();

        topics.forEach(s -> {
            s.accept(visitor);
            topicDtos.add(visitor.getTopicDto());
        });

        return topicDtos;
    }

    @Override
    public TopicDto delete(int id) {
        Topic topic = topicRepository.delete(id);
        topic.accept(visitor);

        //delete topic folder
        String path = pathBuilder.buildAbsoluteTopicFolderPath(topic.getProfessor().getId(), topic.getId());
        try {
            FileUtils.deleteDirectory(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return visitor.getTopicDto();
    }

    @Override
    public TopicDto edit(int id, ESTopicDto topicDto) {
        Topic topic = topicRepository.findOne(id);
        topic.update(topicDto.getName());
        topic = topicRepository.save(topic);
        topic.accept(visitor);

        return visitor.getTopicDto();
    }

    @Override
    public List<StudentTopicDto> getStudentTopics(int studentId) {
        List<Topic> topics = topicRepository.findAll();
        List<StudentTopicDto> studentTopicDtos = new ArrayList<>();
        AtomicBoolean solutionSent = new AtomicBoolean(false);

        topics.forEach(topic -> {
            List<Task> tasks = topic.getTasks();
            List<StudentTaskDto> studentTaskDtos = new ArrayList<>();
            tasks.forEach(task -> {
                List<Subgroup> subgroups = task.getSubgroups();
                subgroups.forEach(subgroup -> {
                    List<Student> students = subgroup.getStudents();
                    students.forEach(student -> {
                        if (student.getId().equals(studentId)) {
                            String mark = "N/A";
                            Solution solution = null;
                            try {
                                solution = solutionRepository.getSolutionForStudentByTask(studentId, task.getId());
                                if (solution.getMark() != null) {
                                    mark = solution.getMark().toString();
                                }
                                solutionSent.set(true);
                            } catch (EntityNotFoundException ignored) {
                            }


                            task.accept(studentTaskVisitor, mark, solutionSent.get());
                            studentTaskDtos.add(studentTaskVisitor.getStudentTaskDto());
                        }
                    });
                });
            });
            if (!studentTaskDtos.isEmpty()) {
                topic.accept(studentTopicVisitor, studentTaskDtos);

                studentTopicDtos.add(studentTopicVisitor.getStudentTopicDto());
            }
        });

        return studentTopicDtos;
    }

}
