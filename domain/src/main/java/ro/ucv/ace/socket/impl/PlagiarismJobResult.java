package ro.ucv.ace.socket.impl;

import ro.ucv.ace.socket.IJobResult;

import java.util.Arrays;

/**
 * Created by Geo on 30.11.2016.
 */
public class PlagiarismJobResult extends JobResult implements IJobResult {

    private PlagiarismMatch[] matches;

    public PlagiarismMatch[] getMatches() {
        return matches;
    }

    public void setMatches(PlagiarismMatch[] matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return "PlagiarismJobResult{" +
                "matches=" + Arrays.toString(matches) +
                "} " + super.toString();
    }
}
