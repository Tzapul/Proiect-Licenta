package ro.ucv.ace.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.task.TaskDto;
import ro.ucv.ace.dto.topic.TopicDto;
import ro.ucv.ace.model.Task;
import ro.ucv.ace.model.Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 11/26/2016.
 */
@Component
public class TopicVisitor {

    private TopicDto topicDto;

    @Autowired
    private TaskVisitor taskVisitor;

    public void visit(Topic topic) {
        List<Task> tasks = topic.getTasks();
        List<TaskDto> taskDtos = new ArrayList<>();
        tasks.forEach(t -> {
            t.accept(taskVisitor);
            taskDtos.add(taskVisitor.getTaskDto());
        });

        topicDto = new TopicDto(topic.getId(), topic.getName(), taskDtos);
    }

    public TopicDto getTopicDto() {
        return topicDto;
    }
}
