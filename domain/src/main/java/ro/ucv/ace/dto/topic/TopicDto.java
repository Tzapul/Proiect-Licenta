package ro.ucv.ace.dto.topic;

import ro.ucv.ace.dto.task.TaskDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 11/26/2016.
 */
public class TopicDto {

    private Integer id;

    private String name;

    private List<TaskDto> tasks = new ArrayList<>();

    public TopicDto(Integer id, String name, List<TaskDto> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }
}
