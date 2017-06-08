package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.plagiarismResult.PlagiarismResultDto;
import ro.ucv.ace.dto.studentGrade.ESStudentGradeDto;
import ro.ucv.ace.dto.studentGrade.StudentGradeDto;
import ro.ucv.ace.dto.task.ETaskDto;
import ro.ucv.ace.dto.task.STaskDto;
import ro.ucv.ace.dto.task.TaskDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.IStudentService;
import ro.ucv.ace.service.ITaskService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tzapt on 11/26/2016.
 */
@RestController
@RequestMapping(value = "/professors")
public class ProfessorTaskController {

    @Autowired
    private ITaskService taskService;

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/{professorId}/topics/{topicId}/tasks", method = RequestMethod.POST)
    public ResponseEntity<TaskDto> saveTask(@Valid @RequestBody STaskDto taskDto, BindingResult bindingResult,
                                            @PathVariable("professorId") int professorId, @PathVariable("topicId") int topicId) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        TaskDto saved = taskService.save(professorId, topicId, taskDto);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity<TaskDto> deleteTask(@PathVariable("taskId") int taskId) {
        TaskDto deleted = taskService.delete(taskId);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity<TaskDto> editTask(@Valid @RequestBody ETaskDto taskDto, BindingResult bindingResult,
                                            @PathVariable("taskId") int taskId) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        TaskDto edited = taskService.edit(taskId, taskDto);

        return new ResponseEntity<>(edited, HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{taskId}/students", method = RequestMethod.GET)
    public ResponseEntity<List<StudentGradeDto>> getStudentsForTask(@PathVariable("taskId") int taskId) {

        List<StudentGradeDto> students = studentService.getAllStudentsWithTask(taskId);

        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @RequestMapping(value = "/tasks/{taskId}/students/{studentId}/mark", method = RequestMethod.POST)
    public ResponseEntity<StudentGradeDto> saveMarkForStudent(@Valid @RequestBody ESStudentGradeDto esStudentGradeDto,
                                                              BindingResult bindingResult, @PathVariable("taskId") int taskId,
                                                              @PathVariable("studentId") int studentId) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        StudentGradeDto student = studentService.saveGradeForStudent(esStudentGradeDto, taskId, studentId);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{taskId}/students/{studentId}/plagiarismResult", method = RequestMethod.GET)
    public ResponseEntity<List<PlagiarismResultDto>> getStudentsForTask(@PathVariable("taskId") int taskId,
                                                                        @PathVariable("studentId") int studentId) {

        List<PlagiarismResultDto> plagiarismResultForTask = studentService.getPlagiarismResultForTask(taskId, studentId);

        return new ResponseEntity<>(plagiarismResultForTask, HttpStatus.OK);
    }

}
