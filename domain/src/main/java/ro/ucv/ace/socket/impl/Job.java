package ro.ucv.ace.socket.impl;

import ro.ucv.ace.model.enums.JobType;
import ro.ucv.ace.socket.IJob;

/**
 * Created by Geo on 30.11.2016.
 */
public abstract class Job implements IJob {

    private JobType type;

    public Job(JobType type) {
        this.type = type;
    }

    @Override
    public JobType getType() {
        return type;
    }
}
