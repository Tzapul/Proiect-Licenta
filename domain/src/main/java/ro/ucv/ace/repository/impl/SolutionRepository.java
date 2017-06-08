package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Solution;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.ISolutionRepository;

/**
 * Created by tzapt on 12/4/2016.
 */
@Repository("solutionRepository")
public class SolutionRepository implements ISolutionRepository {

    @Autowired
    private IJpaRepository<Solution, Integer> innerSolutionRepository;

    @Override
    public Solution save(Solution solution) {
        return innerSolutionRepository.save(solution);
    }

    @Override
    public Solution findOne(int solutionId) {
        return innerSolutionRepository.findOne(solutionId);
    }

    @Override
    public Solution delete(Integer id) {
        return innerSolutionRepository.delete(id);
    }

    @Override
    public Solution getSolutionForStudentByTask(Integer studentId, Integer taskId) {
        return innerSolutionRepository.findOneWhere(solution -> solution.getStudent().getId().equals(studentId) &&
                solution.getTask().getId().equals(taskId));
    }

}
