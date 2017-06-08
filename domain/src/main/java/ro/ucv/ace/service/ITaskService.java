package ro.ucv.ace.service;

import ro.ucv.ace.dto.task.ETaskDto;
import ro.ucv.ace.dto.task.STaskDto;
import ro.ucv.ace.dto.task.TaskDto;

/**
 * Created by tzapt on 11/26/2016.
 */
public interface ITaskService {

    TaskDto save(int professorId, int topicId, STaskDto taskDto);

    TaskDto delete(int taskId);

    TaskDto edit(int taskId, ETaskDto taskDto);
}
