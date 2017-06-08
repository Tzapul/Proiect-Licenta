package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.ucv.ace.dto.topic.ESTopicDto;
import ro.ucv.ace.dto.topic.TopicDto;
import ro.ucv.ace.exception.EntityBindingException;
import ro.ucv.ace.service.ITopicService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tzapt on 11/26/2016.
 */
@RestController
@RequestMapping(value = "/professors")
public class ProfessorTopicController {

    @Autowired
    private ITopicService topicService;

    @RequestMapping(value = "/{professorId}/topics", method = RequestMethod.GET)
    public ResponseEntity<List<TopicDto>> getAllTopics(@PathVariable("professorId") int professorId) {
        List<TopicDto> topicDtos = topicService.getAll(professorId);

        return new ResponseEntity<>(topicDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/{professorId}/topics", method = RequestMethod.POST)
    public ResponseEntity<TopicDto> saveTopic(@Valid @RequestBody ESTopicDto topicDto, BindingResult bindingResult,
                                              @PathVariable("professorId") int professorId) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        TopicDto saved = topicService.save(professorId,topicDto);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TopicDto> updateTopic(@Valid @RequestBody ESTopicDto topicDto, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            throw new EntityBindingException(bindingResult.getFieldErrors());
        }

        TopicDto edited = topicService.edit(id, topicDto);

        return new ResponseEntity<>(edited, HttpStatus.OK);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TopicDto> deleteTopic(@PathVariable("id") int id) {
        TopicDto deleted = topicService.delete(id);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
