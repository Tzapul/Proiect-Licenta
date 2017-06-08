package ro.ucv.ace.model;

import ro.ucv.ace.dto.other.ResponseMessageDto;
import ro.ucv.ace.model.enums.Language;
import ro.ucv.ace.socket.IJob;
import ro.ucv.ace.socket.IJobResult;
import ro.ucv.ace.socket.impl.CompilationJob;
import ro.ucv.ace.socket.impl.TestJob;
import ro.ucv.ace.socket.impl.TestJobResult;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Geo on 15.11.2016.
 */
@Entity
@Table(name = "AUTOMATIC_TESTED_TASK")

public class AutomaticTestedTask extends Task {

    public AutomaticTestedTask() {
    }

    public AutomaticTestedTask(Topic topic, List<Subgroup> subgroups, String name, LocalDate deadline,
                               String description, Language language, PlagiarismAnalyser plagiarismAnalyser) {
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
        return true;
    }

    @Override
    public boolean hasPlagiarismAnalyserEnabled() {
        return getPlagiarismAnalyser().isEnabled();
    }


    @Override
    public ResponseMessageDto addSolution(Solution solution) {
        getSolutions().add(solution);

        IJob compilationJob = new CompilationJob(solution.getDirectoryPath(), getLanguage());
        IJobResult compilationResult;
        try {
            compilationResult = socketManager.sendJob(compilationJob).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Code verifier server error");
        }

        if (compilationResult.getError()) {
            solution.getStudent().addNotification(
                    notificationBuilder.buildCompilerErrorNotification(getName(), compilationResult.getResult()));
            return new ResponseMessageDto(true, compilationResult.getResult());
        }
        if (compilationResult.getInternalError()) {
            getTopic().getProfessor().addNotification(notificationBuilder.buildCompilerErrorNotification(getName(),
                    compilationResult.getResult()));
            return new ResponseMessageDto(true, "Internal server error. Please try again later");
        }

        IJob testJob = new TestJob(solution.getDirectoryPath(), getLanguage());
        IJobResult testJobResult;

        try {
            testJobResult = socketManager.sendJob(testJob).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Code verified server error");
        }

        if (testJobResult.getError()) {
            solution.getStudent().addNotification(notificationBuilder.buildTestErrorNotification(getName(), testJobResult.getResult()));
            return new ResponseMessageDto(true, testJobResult.getResult());
        }

        if (testJobResult.getInternalError()) {
            getTopic().getProfessor().addNotification(notificationBuilder.buildTestErrorNotification(getName(),
                    compilationResult.getResult()));
            return new ResponseMessageDto(true, "Internal server error. Please try again later");
        }
        solution.getStudent().addNotification(notificationBuilder.buildCompileSuccessNotification(getName()));


        TestJobResult tjResult = (TestJobResult) testJobResult;
        double mark = tjResult.getPassedTests() * 100 / tjResult.getTotalTests();
        solution.setMark(mark);

        solution.setAccepted(true);
        solution.getStudent().addNotification(notificationBuilder.buildTestSuccessNotification(getName(), mark));
        return new ResponseMessageDto(false, "Finished compile and test jobs. You have a score of " + mark);
    }


}
