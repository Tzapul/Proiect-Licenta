package ro.ucv.ace.builder;

import ro.ucv.ace.dto.topic.ESTopicDto;
import ro.ucv.ace.model.Topic;

/**
 * Created by tzapt on 11/26/2016.
 */
public interface ITopicBuilder {
    Topic build(ESTopicDto topicDto, int professorId);
}
