package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.ITopicBuilder;
import ro.ucv.ace.dto.topic.ESTopicDto;
import ro.ucv.ace.model.Topic;

/**
 * Created by tzapt on 11/26/2016.
 */
@Component
public class TopicBuilder implements ITopicBuilder {

    @Override
    public Topic build(ESTopicDto topicDto, int professorId) {
        return new Topic(topicDto.getName(), professorId);
    }
}
