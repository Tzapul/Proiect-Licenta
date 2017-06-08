package ro.ucv.ace.service;

import ro.ucv.ace.dto.professor.ESProfessorDto;
import ro.ucv.ace.dto.professor.ProfessorDto;

import java.util.List;

/**
 * Created by tzapt on 11/19/2016.
 */
public interface IProfessorService {

    ProfessorDto save(ESProfessorDto professorDto);

    List<ProfessorDto> getAll();

    ProfessorDto delete(int id);

    ProfessorDto edit(int id, ESProfessorDto professorDto);
}
