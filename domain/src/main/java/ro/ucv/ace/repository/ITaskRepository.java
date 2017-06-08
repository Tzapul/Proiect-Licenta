package ro.ucv.ace.repository;

import ro.ucv.ace.model.Task;

import java.util.List;

/**
 * Created by tzapt on 11/26/2016.
 */
public interface ITaskRepository {

    Task save(Task task);

    Task delete(int taskId);

    Task findOne(int taskId);

    Task findTaskByNameInTopic(Integer id, String name);

    List<Task> findAll();
}
