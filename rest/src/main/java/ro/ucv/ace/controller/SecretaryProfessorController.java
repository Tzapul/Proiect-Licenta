package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.professor.ESProfessorDto;
import ro.ucv.ace.dto.professor.ProfessorDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.IProfessorService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tzapt on 11/19/2016.
 */
@RestController
@RequestMapping(value = "/secretaries")
public class SecretaryProfessorController {

    @Autowired
    private IProfessorService professorService;


    @RequestMapping(value = "/professors", method = RequestMethod.GET)
    public ResponseEntity<List<ProfessorDto>> getAll() {
        return new ResponseEntity<>(professorService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/professors", method = RequestMethod.POST)
    public ResponseEntity<ProfessorDto> saveProfessor(@Valid @RequestBody ESProfessorDto professorDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        ProfessorDto saved = professorService.save(professorDto);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/professors/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProfessorDto> updateProfessor(@Valid @RequestBody ESProfessorDto professorDto, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        ProfessorDto edited = professorService.edit(id, professorDto);

        return new ResponseEntity<>(edited, HttpStatus.OK);
    }

    @RequestMapping(value = "/professors/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProfessorDto> deleteProfessor(@PathVariable("id") int id) {
        ProfessorDto deleted = professorService.delete(id);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
