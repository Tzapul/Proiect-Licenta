package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Student;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.IStudentRepository;

import java.util.List;

/**
 * Created by tzapt on 11/20/2016.
 */
@Repository("studentRepository")
public class StudentRepository implements IStudentRepository {

    @Autowired
    private IJpaRepository<Student, Integer> innerStudentRepository;

    @Override
    public Student save(Student student) {
        return innerStudentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return innerStudentRepository.findAll();
    }

    @Override
    public Student delete(int id) {
        return innerStudentRepository.delete(id);
    }

    @Override
    public Student findOne(int id) {
        return innerStudentRepository.findOne(id);
    }

}
