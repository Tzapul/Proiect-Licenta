package ro.ucv.ace.socket.impl;

import ro.ucv.ace.model.enums.JobType;
import ro.ucv.ace.model.enums.Language;
import ro.ucv.ace.socket.IJob;

/**
 * Created by Geo on 30.11.2016.
 */
public class TestJob extends Job implements IJob {

    private String path;

    private Language language;

    public TestJob(String path, Language language) {
        super(JobType.TEST);
        this.path = path;
        this.language = language;
    }
}
