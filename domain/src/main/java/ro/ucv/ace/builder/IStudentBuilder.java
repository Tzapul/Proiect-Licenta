package ro.ucv.ace.builder;

import ro.ucv.ace.dto.student.ESStudentDto;
import ro.ucv.ace.model.Student;
import ro.ucv.ace.model.Subgroup;

/**
 * Created by tzapt on 11/20/2016.
 */
public interface IStudentBuilder {

    Student build(ESStudentDto studentDto, String username, String password, Subgroup subgroup);
}
