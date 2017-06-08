package ro.ucv.ace.model;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import ro.ucv.ace.dto.other.ResponseMessageDto;
import ro.ucv.ace.model.enums.Language;
import ro.ucv.ace.socket.IJob;
import ro.ucv.ace.socket.IJobResult;
import ro.ucv.ace.socket.impl.CompilationJob;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "MANUALLY_TESTED_TASK")
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public class ManuallyTestedTask extends Task {

    public ManuallyTestedTask() {
    }

    public ManuallyTestedTask(Topic topic, List<Subgroup> subgroups, String name, LocalDate deadline, String description, Language language, PlagiarismAnalyser plagiarismAnalyser) {
        setTopic(topic);
        setSubgroups(subgroups);
        setName(name);
        setDeadline(deadline);
        setDescription(description);
        setLanguage(language);
        setPlagiarismAnalyser(plagiarismAnalyser);
    }

    @Override
    public boolean hasTestsEnabled() {
        return false;
    }

    @Override
    public boolean hasPlagiarismAnalyserEnabled() {
        return getPlagiarismAnalyser().isEnabled();
    }

    @Override
    public ResponseMessageDto addSolution(Solution solution) {
        getSolutions().add(solution);

        IJob compilationJob = new CompilationJob(solution.getDirectoryPath(), getLanguage());
        IJobResult result;
        try {
            result = socketManager.sendJob(compilationJob).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Code verifier server error");
        }

        if (result.getError()) {
            solution.getStudent().addNotification(
                    notificationBuilder.buildCompilerErrorNotification(getName(), result.getResult()));
            return new ResponseMessageDto(true, result.getResult());
        }
        if (result.getInternalError()) {
            getTopic().getProfessor().addNotification(notificationBuilder.buildCompilerErrorNotification(getName(), result.getResult()));
            return new ResponseMessageDto(true, "Internal server error. Please try again later");
        }

        solution.setAccepted(true);
        solution.getStudent().addNotification(notificationBuilder.buildCompileSuccessNotification(getName()));
        return new ResponseMessageDto(false, "Successfully finished compilation for task with name " + getName());
    }


}
