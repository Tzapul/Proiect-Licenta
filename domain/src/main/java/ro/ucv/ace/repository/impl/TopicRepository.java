package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Topic;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.ITopicRepository;

import java.util.List;

/**
 * Created by tzapt on 11/26/2016.
 */
@Repository("topicRepository")
public class TopicRepository implements ITopicRepository {

    @Autowired
    private IJpaRepository<Topic, Integer> innerTopicRepository;


    @Override
    public Topic save(Topic topic) {
        return innerTopicRepository.save(topic);
    }

    @Override
    public List<Topic> findAll() {
        return innerTopicRepository.findAll();
    }

    @Override
    public Topic delete(int id) {
        return innerTopicRepository.delete(id);
    }

    @Override
    public Topic findOne(int id) {
        return innerTopicRepository.findOne(id);
    }

    @Override
    public List<Topic> findByProfessor(int professorId) {
        return innerTopicRepository.findAllWhere(topic -> topic.getProfessor().getId().equals(professorId));
    }

    @Override
    public Topic findByProfessorAndName(int professorId, String name) {
        return innerTopicRepository.findOneWhere(topic -> topic.getProfessor().getId().equals(professorId) && topic.getName().equals(name));
    }

}
