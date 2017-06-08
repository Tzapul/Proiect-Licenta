package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.dto.topic.StudentTopicDto;
import ro.ucv.ace.service.ITopicService;

import java.util.List;

/**
 * Created by Geo on 11.12.2016.
 */
@RestController
@RequestMapping(value = "/students")
public class StudentTopicController {

    @Autowired
    private ITopicService topicService;

    @RequestMapping(value = "/{studentId}/topics", method = RequestMethod.GET)
    public ResponseEntity<List<StudentTopicDto>> getStudentTopics(@PathVariable("studentId") int studentId) {
        List<StudentTopicDto> studentTopicDtos = topicService.getStudentTopics(studentId);

        return new ResponseEntity<List<StudentTopicDto>>(studentTopicDtos, HttpStatus.OK);
    }
}
