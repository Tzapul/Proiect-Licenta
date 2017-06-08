package ro.ucv.ace.service;

import ro.ucv.ace.dto.plagiarismResult.PlagiarismResultDto;
import ro.ucv.ace.dto.student.ESStudentDto;
import ro.ucv.ace.dto.student.StudentDto;
import ro.ucv.ace.dto.studentGrade.ESStudentGradeDto;
import ro.ucv.ace.dto.studentGrade.StudentGradeDto;

import java.util.List;

/**
 * Created by tzapt on 11/20/2016.
 */
public interface IStudentService {

    StudentDto save(ESStudentDto studentDto);

    List<StudentDto> getAll();

    StudentDto delete(int id);

    StudentDto edit(int id, ESStudentDto studentDto);

    List<StudentGradeDto> getAllStudentsWithTask(int taskId);

    StudentGradeDto saveGradeForStudent(ESStudentGradeDto esStudentGradeDto, int taskId, int studentId);

    List<PlagiarismResultDto> getPlagiarismResultForTask(int taskId, int studentId);
}
