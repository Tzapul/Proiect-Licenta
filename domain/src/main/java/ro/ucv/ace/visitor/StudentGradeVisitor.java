package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.studentGrade.StudentGradeDto;
import ro.ucv.ace.model.Student;

/**
 * Created by tzapt on 12/10/2016.
 */
@Component
public class StudentGradeVisitor {

    private StudentGradeDto studentGradeDto;

    public void visit(Student student) {
        studentGradeDto = new StudentGradeDto(student.getId(), student.getAccount().getUsername(), student.getPersonDetails().getFirstName(),
                student.getPersonDetails().getLastName(), student.getPersonDetails().getGender().toString(), student.getPersonDetails().getSsn(),
                student.getAccount().getEmail(), student.getSubgroup().getName(), "N/A");
    }

    public StudentGradeDto getStudentGradeDto() {
        return studentGradeDto;
    }
}
