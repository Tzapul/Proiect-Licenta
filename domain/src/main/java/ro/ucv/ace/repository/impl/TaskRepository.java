package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Task;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.ITaskRepository;

import java.util.List;

/**
 * Created by tzapt on 11/26/2016.
 */
@Repository("taskRepository")
public class TaskRepository implements ITaskRepository {

    @Autowired
    private IJpaRepository<Task, Integer> innerTaskRepository;

    @Override
    public Task save(Task task) {
        return innerTaskRepository.save(task);
    }

    @Override
    public Task delete(int taskId) {
        return innerTaskRepository.delete(taskId);
    }

    @Override
    public Task findOne(int taskId) {
        return innerTaskRepository.findOne(taskId);
    }

    @Override
    public Task findTaskByNameInTopic(Integer id, String name) {
        return innerTaskRepository.findOneWhere(task -> task.getName().equals(name) && task.getTopic().getId().equals(id));
    }

    @Override
    public List<Task> findAll() {
        return innerTaskRepository.findAll();
    }
}
