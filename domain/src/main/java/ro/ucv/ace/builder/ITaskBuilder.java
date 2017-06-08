package ro.ucv.ace.builder;

import ro.ucv.ace.dto.task.STaskDto;
import ro.ucv.ace.model.Subgroup;
import ro.ucv.ace.model.Task;
import ro.ucv.ace.model.Topic;

import java.util.List;

/**
 * Created by Geo on 30.11.2016.
 */
public interface ITaskBuilder {
    Task buildAutomaticTask(STaskDto taskDto, List<Subgroup> subgroups, Topic topic);

    Task buildManualTask(STaskDto taskDto, List<Subgroup> subgroups, Topic topic);
}
