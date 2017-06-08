package ro.ucv.ace.repository;

import ro.ucv.ace.model.PlagiarismResult;

import java.util.List;

/**
 * Created by tzapt on 12/10/2016.
 */
public interface IPlagiarismResultRepository {

    PlagiarismResult save(PlagiarismResult plagiarismResult);

    List<PlagiarismResult> findAll();

    PlagiarismResult delete(int id);

    PlagiarismResult findOne(int id);

    List<PlagiarismResult> findResultsByStudentAndTask(Integer studentId, Integer taskId);
}
