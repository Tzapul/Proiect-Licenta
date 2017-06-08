package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.student.StudentDto;
import ro.ucv.ace.model.Student;

/**
 * Created by tzapt on 11/20/2016.
 */
@Component
public class StudentVisitor {

    private StudentDto studentDto;

    public void visit(Student student) {
        studentDto = new StudentDto(student.getId(), student.getAccount().getUsername(), student.getPersonDetails().getFirstName(),
                student.getPersonDetails().getLastName(), student.getPersonDetails().getGender().toString(), student.getPersonDetails().getSsn(),
                student.getAccount().getEmail(), student.getSubgroup().getName());
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }
}
