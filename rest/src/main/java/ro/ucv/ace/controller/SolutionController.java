package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.other.FilePath;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.ISolutionService;
import ro.ucv.ace.utility.impl.Content;
import ro.ucv.ace.utility.impl.Node;

import javax.validation.Valid;

/**
 * Created by Geo on 08.12.2016.
 */
@RestController
@RequestMapping(value = "/solutions")
public class SolutionController {

    @Autowired
    private ISolutionService solutionService;

    @RequestMapping(value = "/{solutionId}/folderStructure", method = RequestMethod.GET)
    public ResponseEntity<Node> getSolutionFolderStructure(@PathVariable("solutionId") int solutionId) {
        Node node = solutionService.getSolutionFolderStructure(solutionId);

        return new ResponseEntity<Node>(node, HttpStatus.OK);
    }

    @RequestMapping(value = "/content", method = RequestMethod.POST)
    public ResponseEntity<Content> getFileContent(@Valid @RequestBody FilePath filePath, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        Content content = solutionService.getFileContent(filePath.getFilePath());

        return new ResponseEntity<Content>(content, HttpStatus.OK);
    }
}
