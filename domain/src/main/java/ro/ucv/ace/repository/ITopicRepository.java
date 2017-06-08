package ro.ucv.ace.repository;

import ro.ucv.ace.model.Topic;

import java.util.List;

/**
 * Created by tzapt on 11/26/2016.
 */
public interface ITopicRepository {

    Topic save(Topic topic);

    List<Topic> findAll();

    Topic delete(int id);

    Topic findOne(int id);

    List<Topic> findByProfessor(int professorId);

    Topic findByProfessorAndName(int professorId, String name);
}
