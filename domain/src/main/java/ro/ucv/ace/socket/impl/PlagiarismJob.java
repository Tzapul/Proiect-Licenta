package ro.ucv.ace.socket.impl;

import ro.ucv.ace.model.enums.JobType;
import ro.ucv.ace.model.enums.Language;
import ro.ucv.ace.socket.IJob;

/**
 * Created by Geo on 30.11.2016.
 */
public class PlagiarismJob extends Job implements IJob {

    private String path;

    private Language language;

    public PlagiarismJob(String path, Language language) {
        super(JobType.PLAGIARISM);
        this.path = path;
        this.language = language;
    }
}
