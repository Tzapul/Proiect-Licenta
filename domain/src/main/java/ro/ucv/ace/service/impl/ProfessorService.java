package ro.ucv.ace.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.IPathBuilder;
import ro.ucv.ace.builder.IProfessorBuilder;
import ro.ucv.ace.dto.professor.ESProfessorDto;
import ro.ucv.ace.dto.professor.ProfessorDto;
import ro.ucv.ace.model.Professor;
import ro.ucv.ace.repository.IProfessorRepository;
import ro.ucv.ace.repository.IUserRepository;
import ro.ucv.ace.service.IMailService;
import ro.ucv.ace.service.IProfessorService;
import ro.ucv.ace.visitor.ProfessorVisitor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 11/19/2016.
 */
@Service("professorService")
@Transactional(rollbackFor = Exception.class)
public class ProfessorService implements IProfessorService {

    @Autowired
    private IProfessorRepository professorRepository;

    @Autowired
    private IProfessorBuilder professorBuilder;

    @Autowired
    private ProfessorVisitor professorVisitor;

    @Autowired
    private IMailService mailService;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPathBuilder pathBuilder;

    @Override
    public ProfessorDto save(ESProfessorDto professorDto) {
        Integer index = 1;
        String username = (professorDto.getFirstName().substring(0, index) + professorDto.getLastName()).toLowerCase();
        Integer ssnLength = professorDto.getSsn().length();
        String password = professorDto.getSsn().substring(ssnLength - 4, ssnLength);

        while (userRepository.usernameExists(username)) {
            username = (professorDto.getFirstName().substring(0, ++index) + professorDto.getLastName()).toLowerCase();
        }

        Professor professor = professorRepository.save(professorBuilder.build(professorDto, username, password));

        mailService.sendAccountCreationMail(professorDto.getEmail(), username, password);

        professor.accept(professorVisitor);

        return professorVisitor.getProfessorDto();
    }

    @Override
    public List<ProfessorDto> getAll() {
        List<Professor> professors = professorRepository.findAll();
        List<ProfessorDto> professorDtos = new ArrayList<>();
        professors.forEach(p -> {
            p.accept(professorVisitor);
            professorDtos.add(professorVisitor.getProfessorDto());
        });

        return professorDtos;
    }

    @Override
    public ProfessorDto delete(int id) {
        Professor professor = professorRepository.delete(id);
        professor.accept(professorVisitor);

        // delete professor folder
        String path = pathBuilder.buildAbsoluteProfessorFolderPath(professor.getId());
        try {
            FileUtils.deleteDirectory(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return professorVisitor.getProfessorDto();
    }

    @Override
    public ProfessorDto edit(int id, ESProfessorDto professorDto) {
        Professor professor = professorRepository.findOne(id);
        professor.update(professorDto.getFirstName(), professorDto.getLastName(), professorDto.getSsn(),
                professorDto.getEmail(), professorDto.getGender(), professorDto.getPosition());
        professor = professorRepository.save(professor);

        professor.accept(professorVisitor);

        return professorVisitor.getProfessorDto();
    }
}
