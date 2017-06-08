package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.PlagiarismResult;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.IPlagiarismResultRepository;

import java.util.List;

/**
 * Created by tzapt on 12/10/2016.
 */
@Repository("plagiarismResultRepository")
public class PlagiarismResultRepository implements IPlagiarismResultRepository {

    @Autowired
    private IJpaRepository<PlagiarismResult, Integer> innerPlagiarismResultRespository;

    @Override
    public PlagiarismResult save(PlagiarismResult plagiarismResult) {
        return innerPlagiarismResultRespository.save(plagiarismResult);
    }

    @Override
    public List<PlagiarismResult> findAll() {
        return innerPlagiarismResultRespository.findAll();
    }

    @Override
    public PlagiarismResult delete(int id) {
        return innerPlagiarismResultRespository.delete(id);
    }

    @Override
    public PlagiarismResult findOne(int id) {
        return innerPlagiarismResultRespository.findOne(id);
    }

    @Override
    public List<PlagiarismResult> findResultsByStudentAndTask(Integer studentId, Integer taskId) {
        return innerPlagiarismResultRespository.findAllWhere(result -> result.getStudent1().getId().equals(studentId) &&
                result.getTask().getId().equals(taskId));
    }
}
