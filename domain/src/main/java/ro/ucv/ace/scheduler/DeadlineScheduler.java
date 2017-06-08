package ro.ucv.ace.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.ucv.ace.model.PlagiarismResult;
import ro.ucv.ace.model.Student;
import ro.ucv.ace.model.Task;
import ro.ucv.ace.repository.IStudentRepository;
import ro.ucv.ace.repository.ITaskRepository;
import ro.ucv.ace.socket.IJob;
import ro.ucv.ace.socket.IJobResult;
import ro.ucv.ace.socket.ISocketManager;
import ro.ucv.ace.socket.impl.PlagiarismJob;
import ro.ucv.ace.socket.impl.PlagiarismJobResult;
import ro.ucv.ace.socket.impl.PlagiarismMatch;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Geo on 07.12.2016.
 */
@Component
public class DeadlineScheduler {

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private ISocketManager socketManager;

    @Autowired
    private IStudentRepository studentRepository;


    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void checkDeadline() {
        System.out.println("Starting deadline task...");

        LocalDate currentDate = LocalDate.now();
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getDeadline().isBefore(currentDate) && task.getPlagiarismAnalyser().isEnabled() && !task.isAnalyzed()) {
                IJob plagiarismJob = new PlagiarismJob(task.getPath(), task.getLanguage());
                try {
                    IJobResult result = socketManager.sendJob(plagiarismJob).get();
                    PlagiarismJobResult plagiarismJobResult = (PlagiarismJobResult) result;

                    if (plagiarismJobResult.getInternalError()) {
                        return;
                    }

                    for (PlagiarismMatch plagiarismMatch : plagiarismJobResult.getMatches()) {
                        Student student1 = studentRepository.findOne(plagiarismMatch.getSolution1());
                        Student student2 = studentRepository.findOne(plagiarismMatch.getSolution2());
                        PlagiarismResult plagiarismResult1 = new PlagiarismResult(task, student1, student2, plagiarismMatch.getUrl(),
                                plagiarismMatch.getValue());
                        PlagiarismResult plagiarismResult2 = new PlagiarismResult(task, student2, student1, plagiarismMatch.getUrl(),
                                plagiarismMatch.getValue());

                        task.getPlagiarismResults().add(plagiarismResult1);
                        task.getPlagiarismResults().add(plagiarismResult2);

                    }

                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Exception while sending plagiarism job");
                }

                task.setAnalyzed(true);
            }
        }

        System.out.println("Deadline task ended");
    }
}
