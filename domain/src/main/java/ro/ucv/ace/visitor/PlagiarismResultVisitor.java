package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.plagiarismResult.PlagiarismResultDto;
import ro.ucv.ace.model.PlagiarismResult;
import ro.ucv.ace.model.Student;

/**
 * Created by tzapt on 12/10/2016.
 */
@Component
public class PlagiarismResultVisitor {

    private PlagiarismResultDto plagiarismResultDto;

    public void visit(PlagiarismResult plagiarismResult) {
        Student student = plagiarismResult.getStudent2();
        plagiarismResultDto = new PlagiarismResultDto(student.getId(), student.getAccount().getUsername(), student.getPersonDetails().getFirstName(),
                student.getPersonDetails().getLastName(), student.getPersonDetails().getGender().toString(), student.getPersonDetails().getSsn(),
                student.getAccount().getEmail(), student.getSubgroup().getName(), String.valueOf(plagiarismResult.getSimilarityPercent()), plagiarismResult.getUrl());
    }

    public PlagiarismResultDto getPlagiarismResultDto() {
        return plagiarismResultDto;
    }
}
