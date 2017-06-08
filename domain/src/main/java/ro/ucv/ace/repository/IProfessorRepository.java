package ro.ucv.ace.repository;

import ro.ucv.ace.model.Professor;

import java.util.List;

/**
 * Created by tzapt on 11/19/2016.
 */
public interface IProfessorRepository {
    Professor save(Professor professor);

    List<Professor> findAll();

    Professor delete(int id);

    Professor findOne(int id);

}
