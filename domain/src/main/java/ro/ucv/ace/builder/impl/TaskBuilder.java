package ro.ucv.ace.builder.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.ITaskBuilder;
import ro.ucv.ace.dto.task.STaskDto;
import ro.ucv.ace.model.*;
import ro.ucv.ace.model.enums.Language;
import ro.ucv.ace.repository.IPlagiarismAnalyserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Geo on 30.11.2016.
 */
@Component
public class TaskBuilder implements ITaskBuilder {

    @Autowired
    private IPlagiarismAnalyserRepository plagiarismAnalyserRepository;

    @Override
    public Task buildAutomaticTask(STaskDto taskDto, List<Subgroup> subgroups, Topic topic) {
        PlagiarismAnalyser plagiarismAnalyser = getPlagiarismAnalyser(taskDto.isPlagiarismEnabled());

        return new AutomaticTestedTask(topic, subgroups, taskDto.getName(), localDateFrom(taskDto.getDeadline()),
                taskDto.getDescription(), Language.valueOf(taskDto.getLanguage()), plagiarismAnalyser);

    }

    @Override
    public Task buildManualTask(STaskDto taskDto, List<Subgroup> subgroups, Topic topic) {
        PlagiarismAnalyser plagiarismAnalyser = getPlagiarismAnalyser(taskDto.isPlagiarismEnabled());

        return new ManuallyTestedTask(topic, subgroups, taskDto.getName(), localDateFrom(taskDto.getDeadline()),
                taskDto.getDescription(), Language.valueOf(taskDto.getLanguage()), plagiarismAnalyser);
    }

    private PlagiarismAnalyser getPlagiarismAnalyser(boolean isPlagiarismEnabled) {
        PlagiarismAnalyser plagiarismAnalyser = null;

        if (isPlagiarismEnabled) {
            plagiarismAnalyser = plagiarismAnalyserRepository.getDefaultPlagiarismAnalyser();
        } else {
            plagiarismAnalyser = plagiarismAnalyserRepository.getNullPlagiarismAnalyser();
        }

        return plagiarismAnalyser;
    }

    private LocalDate localDateFrom(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}
