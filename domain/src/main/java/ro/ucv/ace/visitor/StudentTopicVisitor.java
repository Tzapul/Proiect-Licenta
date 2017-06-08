package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.task.StudentTaskDto;
import ro.ucv.ace.dto.topic.StudentTopicDto;
import ro.ucv.ace.model.Topic;

import java.util.List;

/**
 * Created by Geo on 11.12.2016.
 */
@Component
public class StudentTopicVisitor {

    private StudentTopicDto studentTopicDto;

    public void visit(Topic topic, List<StudentTaskDto> studentTaskDtos) {
        studentTopicDto = new StudentTopicDto(topic.getId(), topic.getName(), studentTaskDtos);
    }

    public StudentTopicDto getStudentTopicDto() {
        return studentTopicDto;
    }
}
