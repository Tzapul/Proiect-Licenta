package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.student.ESStudentDto;
import ro.ucv.ace.dto.student.StudentDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.IStudentService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tzapt on 11/20/2016.
 */
@RestController
@RequestMapping(value = "/secretaries")
public class SecretaryStudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<StudentDto>> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody ESStudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        StudentDto saved = studentService.save(studentDto);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody ESStudentDto studentDto, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        StudentDto edited = studentService.edit(id, studentDto);

        return new ResponseEntity<>(edited, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable("id") int id) {
        StudentDto deleted = studentService.delete(id);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
