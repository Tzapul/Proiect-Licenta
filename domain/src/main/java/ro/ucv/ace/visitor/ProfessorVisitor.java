package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.professor.ProfessorDto;
import ro.ucv.ace.model.Professor;

/**
 * Created by tzapt on 11/19/2016.
 */
@Component
public class ProfessorVisitor {

    private ProfessorDto professorDto;

    public void visit(Professor professor) {
        professorDto = new ProfessorDto(professor.getId(), professor.getAccount().getUsername(), professor.getPersonDetails().getFirstName(),
                professor.getPersonDetails().getLastName(), professor.getPersonDetails().getGender().toString(), professor.getPersonDetails().getSsn(),
                professor.getAccount().getEmail(), professor.getPosition());
    }

    public ProfessorDto getProfessorDto() {
        return professorDto;
    }
}
