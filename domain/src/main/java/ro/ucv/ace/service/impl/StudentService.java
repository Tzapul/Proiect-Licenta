package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IStudentBuilder;
import ro.ucv.ace.dto.plagiarismResult.PlagiarismResultDto;
import ro.ucv.ace.dto.student.ESStudentDto;
import ro.ucv.ace.dto.student.StudentDto;
import ro.ucv.ace.dto.studentGrade.ESStudentGradeDto;
import ro.ucv.ace.dto.studentGrade.StudentGradeDto;
import ro.ucv.ace.exception.DeadlinePassedException;
import ro.ucv.ace.exception.EntityNotFoundException;
import ro.ucv.ace.exception.NoSolutionSentException;
import ro.ucv.ace.model.*;
import ro.ucv.ace.repository.*;
import ro.ucv.ace.service.IStudentService;
import ro.ucv.ace.visitor.PlagiarismResultVisitor;
import ro.ucv.ace.visitor.StudentGradeVisitor;
import ro.ucv.ace.visitor.StudentVisitor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 11/20/2016.
 */
@Service("studentService")
@Transactional(rollbackFor = Exception.class)
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IStudentBuilder studentBuilder;

    @Autowired
    private StudentVisitor studentVisitor;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private ISubgroupRepository subgroupRepository;

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private ISolutionRepository solutionRepository;

    @Autowired
    private IPlagiarismResultRepository plagiarismResultRepository;

    @Autowired
    private StudentGradeVisitor studentGradeVisitor;

    @Autowired
    private PlagiarismResultVisitor plagiarismResultVisitor;

    @Override
    public StudentDto save(ESStudentDto studentDto) {

        Integer index = 1;
        String username = (studentDto.getFirstName().substring(0, index) + studentDto.getLastName()).toLowerCase();
        Integer ssnLength = studentDto.getSsn().length();
        String password = studentDto.getSsn().substring(ssnLength - 4, ssnLength);

        while (userRepository.usernameExists(username)) {
            username = (studentDto.getFirstName().substring(0, ++index) + studentDto.getLastName()).toLowerCase();
        }

        Subgroup subgroup = subgroupRepository.findByName(studentDto.getSubgroup());

        Student student = studentRepository.save(studentBuilder.build(studentDto, username, password, subgroup));

        mailService.sendAccountCreationMail(studentDto.getEmail(), username, password);

        student.accept(studentVisitor);

        return studentVisitor.getStudentDto();
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        students.forEach(s -> {
            s.accept(studentVisitor);
            studentDtos.add(studentVisitor.getStudentDto());
        });

        return studentDtos;
    }

    @Override
    public StudentDto delete(int id) {
        Student student = studentRepository.delete(id);
        student.accept(studentVisitor);

        return studentVisitor.getStudentDto();
    }

    @Override
    public StudentDto edit(int id, ESStudentDto studentDto) {
        Student student = studentRepository.findOne(id);

        Subgroup subgroup = subgroupRepository.findByName(studentDto.getSubgroup());

        student.update(studentDto.getFirstName(), studentDto.getLastName(), studentDto.getSsn(),
                studentDto.getEmail(), studentDto.getGender(), subgroup);
        student = studentRepository.save(student);

        student.accept(studentVisitor);

        return studentVisitor.getStudentDto();
    }

    @Override
    public List<StudentGradeDto> getAllStudentsWithTask(int taskId) {
        Task task = taskRepository.findOne(taskId);
        List<Student> students = new ArrayList<>();

        for (Subgroup subgroup : task.getSubgroups()) {
            students.addAll(subgroup.getStudents());
        }

        List<StudentGradeDto> studentGradeDtos = new ArrayList<>();
        students.forEach(s -> {
            s.accept(studentGradeVisitor);
            StudentGradeDto studentGradeDto = studentGradeVisitor.getStudentGradeDto();

            Solution solution = null;
            try {
                solution = solutionRepository.getSolutionForStudentByTask(s.getId(), taskId);
                Double mark = solution.getMark();
                if (mark != null) {
                    studentGradeDto.setMark(mark.toString());
                }
                studentGradeDto.setSolutionId(solution.getId());
            } catch (EntityNotFoundException e) {
            }

            studentGradeDtos.add(studentGradeDto);
        });

        return studentGradeDtos;
    }

    @Override
    public StudentGradeDto saveGradeForStudent(ESStudentGradeDto esStudentGradeDto, int taskId, int studentId) {
        Task task = taskRepository.findOne(taskId);
        Student student = studentRepository.findOne(studentId);

        LocalDate currentDate = LocalDate.now();
        if (task.getDeadline().isAfter(currentDate)) {
            throw new DeadlinePassedException("You can't edit a solution until the deadline has passed.");
        }

        Solution solution = null;
        try {
            solution = solutionRepository.getSolutionForStudentByTask(student.getId(), taskId);
        } catch (EntityNotFoundException e) {
            throw new NoSolutionSentException("The student didn't send any solution.");
        }

        solution.setMark(esStudentGradeDto.getMark());
        solutionRepository.save(solution);

        student.accept(studentGradeVisitor);

        StudentGradeDto studentGradeDto = studentGradeVisitor.getStudentGradeDto();
        studentGradeDto.setMark(solution.getMark().toString());

        return studentGradeDto;
    }

    @Override
    public List<PlagiarismResultDto> getPlagiarismResultForTask(int taskId, int studentId) {
        Student student = studentRepository.findOne(studentId);

        Solution solution = null;
        try {
            solution = solutionRepository.getSolutionForStudentByTask(student.getId(), taskId);
        } catch (EntityNotFoundException e) {
            throw new NoSolutionSentException("The student didn't send any solution.");
        }

        List<PlagiarismResult> plagiarismResults = plagiarismResultRepository.findResultsByStudentAndTask(studentId, taskId);
        List<PlagiarismResultDto> plagiarismResultDtos = new ArrayList<>();

        plagiarismResults.forEach(plagiarismResult -> {
            plagiarismResult.accept(plagiarismResultVisitor);
            plagiarismResultDtos.add(plagiarismResultVisitor.getPlagiarismResultDto());
        });

        return plagiarismResultDtos;
    }
}
