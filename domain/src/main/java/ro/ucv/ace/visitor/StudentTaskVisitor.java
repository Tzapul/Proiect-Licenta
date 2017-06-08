package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.task.StudentTaskDto;
import ro.ucv.ace.model.Task;

/**
 * Created by Geo on 11.12.2016.
 */
@Component
public class StudentTaskVisitor {

    private StudentTaskDto studentTaskDto;

    public void visit(Task task, String mark, boolean solutionSent) {
        studentTaskDto = new StudentTaskDto(task.getId(), task.getName(), task.getDescription(),
                task.getDeadline().toString(), task.getLanguage().toString(), task.hasTestsEnabled(), mark, solutionSent);
    }

    public StudentTaskDto getStudentTaskDto() {
        return studentTaskDto;
    }
}
