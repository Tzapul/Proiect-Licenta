package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.IProfessorBuilder;
import ro.ucv.ace.dto.professor.ESProfessorDto;
import ro.ucv.ace.model.Professor;

/**
 * Created by tzapt on 11/19/2016.
 */
@Component
public class ProfessorBuilder implements IProfessorBuilder {

    @Override
    public Professor build(ESProfessorDto professorDto, String username, String password) {
        return new Professor(professorDto.getFirstName(), professorDto.getGender(), professorDto.getLastName(),
                professorDto.getPosition(), professorDto.getSsn(), professorDto.getEmail(), username, password);
    }
}
