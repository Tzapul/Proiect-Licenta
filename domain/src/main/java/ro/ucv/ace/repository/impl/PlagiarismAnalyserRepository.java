package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.DefaultPlagiarismAnalyser;
import ro.ucv.ace.model.NullPlagiarismAnalyser;
import ro.ucv.ace.model.PlagiarismAnalyser;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.IPlagiarismAnalyserRepository;

/**
 * Created by Geo on 30.11.2016.
 */
@Repository("plagiarismAnalyserRepository")
public class PlagiarismAnalyserRepository implements IPlagiarismAnalyserRepository {

    @Autowired
    private IJpaRepository<NullPlagiarismAnalyser, Integer> nullPlagiarismRepository;

    @Autowired
    private IJpaRepository<DefaultPlagiarismAnalyser, Integer> defaultPlagiarismRepository;

    @Override
    public PlagiarismAnalyser getNullPlagiarismAnalyser() {
        return nullPlagiarismRepository.findAll().get(0);
    }

    @Override
    public PlagiarismAnalyser getDefaultPlagiarismAnalyser() {
        return defaultPlagiarismRepository.findAll().get(0);
    }
}
