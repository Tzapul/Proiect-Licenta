package ro.ucv.ace.builder;

import ro.ucv.ace.model.Solution;
import ro.ucv.ace.model.Student;
import ro.ucv.ace.model.Task;

/**
 * Created by tzapt on 12/4/2016.
 */
public interface ISolutionBuilder {

    Solution build(Student student, Task task, String stringPath);
}
