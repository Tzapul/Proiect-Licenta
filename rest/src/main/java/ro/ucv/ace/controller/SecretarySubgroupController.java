package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.subgroup.ESSubgroupDto;
import ro.ucv.ace.dto.subgroup.SubgroupDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.ISubgroupService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Geo on 19.11.2016.
 */
@RestController
@RequestMapping(value = "/secretaries")
public class SecretarySubgroupController {

    @Autowired
    private ISubgroupService subgroupService;

    @RequestMapping(value = "/subgroups", method = RequestMethod.GET)
    public ResponseEntity<List<SubgroupDto>> getAllSubgroups() {
        List<SubgroupDto> subgroupDtos = subgroupService.getAll();

        return new ResponseEntity<>(subgroupDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/subgroups", method = RequestMethod.POST)
    public ResponseEntity<SubgroupDto> saveSubgroup(@Valid @RequestBody ESSubgroupDto subgroupDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        SubgroupDto saved = subgroupService.save(subgroupDto);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/subgroups/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubgroupDto> updateSubgroup(@Valid @RequestBody ESSubgroupDto subgroupDto, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        SubgroupDto edited = subgroupService.edit(id, subgroupDto);

        return new ResponseEntity<>(edited, HttpStatus.OK);
    }

    @RequestMapping(value = "/subgroups/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SubgroupDto> deleteSubgroup(@PathVariable("id") int id) {
        SubgroupDto deleted = subgroupService.delete(id);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
