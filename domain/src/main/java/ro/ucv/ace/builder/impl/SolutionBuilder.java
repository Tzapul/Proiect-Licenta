package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.ISolutionBuilder;
import ro.ucv.ace.model.Solution;
import ro.ucv.ace.model.Student;
import ro.ucv.ace.model.Task;

/**
 * Created by tzapt on 12/4/2016.
 */
@Component
public class SolutionBuilder implements ISolutionBuilder {

    @Override
    public Solution build(Student student, Task task, String stringPath) {
        return new Solution(student, task, stringPath);
    }
}
