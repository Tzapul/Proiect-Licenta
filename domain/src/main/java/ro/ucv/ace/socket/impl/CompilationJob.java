package ro.ucv.ace.socket.impl;

import ro.ucv.ace.model.enums.JobType;
import ro.ucv.ace.model.enums.Language;
import ro.ucv.ace.socket.IJob;

/**
 * Created by ctotolin on 19-Nov-16.
 */
public class CompilationJob extends Job implements IJob {

    private String path;

    private Language language;

    public CompilationJob(String path, Language language) {
        super(JobType.COMPILE);
        this.path = path;
        this.language = language;
    }
}
