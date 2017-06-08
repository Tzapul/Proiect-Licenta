package ro.ucv.ace.dto.topic;

import ro.ucv.ace.dto.task.StudentTaskDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 11.12.2016.
 */
public class StudentTopicDto {

    private Integer id;

    private String name;

    private List<StudentTaskDto> tasks = new ArrayList<>();

    public StudentTopicDto(Integer id, String name, List<StudentTaskDto> tasks) {
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

    public List<StudentTaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<StudentTaskDto> tasks) {
        this.tasks = tasks;
    }
}
