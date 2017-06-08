package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.other.ResponseMessageDto;
import ro.ucv.ace.dto.solution.ESSolutionDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.ISolutionService;

import javax.validation.Valid;

/**
 * Created by tzapt on 12/4/2016.
 */
@RestController
@RequestMapping(value = "/students")
public class StudentSolutionController {

    @Autowired
    private ISolutionService solutionService;

    @RequestMapping(value = "/{studentId}/tasks/{taskId}/solutions", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessageDto> saveSolution(@Valid @RequestBody ESSolutionDto solutionDto, BindingResult bindingResult,
                                                           @PathVariable("studentId") int studentId,
                                                           @PathVariable("taskId") int taskId) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        ResponseMessageDto messageDto = solutionService.save(studentId, taskId, solutionDto);

        return new ResponseEntity<>(messageDto, HttpStatus.OK);
    }

}
