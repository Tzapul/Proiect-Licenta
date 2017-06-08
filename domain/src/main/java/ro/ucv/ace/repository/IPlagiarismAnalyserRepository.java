package ro.ucv.ace.repository;

import ro.ucv.ace.model.PlagiarismAnalyser;

/**
 * Created by Geo on 30.11.2016.
 */
public interface IPlagiarismAnalyserRepository {

    PlagiarismAnalyser getNullPlagiarismAnalyser();

    PlagiarismAnalyser getDefaultPlagiarismAnalyser();
}
