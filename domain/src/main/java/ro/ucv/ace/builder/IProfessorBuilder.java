package ro.ucv.ace.builder;

import ro.ucv.ace.dto.professor.ESProfessorDto;
import ro.ucv.ace.model.Professor;

/**
 * Created by tzapt on 11/19/2016.
 */
public interface IProfessorBuilder {

    Professor build(ESProfessorDto professorDto, String username, String password);
}
