package ro.ucv.ace.repository;

import ro.ucv.ace.model.Student;

import java.util.List;

/**
 * Created by tzapt on 11/20/2016.
 */
public interface IStudentRepository {

    Student save(Student student);

    List<Student> findAll();

    Student delete(int id);

    Student findOne(int id);

}
