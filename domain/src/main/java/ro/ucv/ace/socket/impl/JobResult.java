package ro.ucv.ace.socket.impl;

import ro.ucv.ace.socket.IJobResult;

/**
 * Created by Geo on 30.11.2016.
 */
public abstract class JobResult implements IJobResult {

    private boolean error;

    private boolean internalError;

    private String result;

    @Override
    public boolean getError() {
        return error;
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public boolean getInternalError() {
        return internalError;
    }

    @Override
    public String toString() {
        return "JobResult{" +
                "error=" + error +
                ", internalError=" + internalError +
                ", result='" + result + '\'' +
                '}';
    }
}
