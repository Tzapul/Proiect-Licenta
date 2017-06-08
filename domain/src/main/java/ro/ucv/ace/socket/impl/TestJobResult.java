package ro.ucv.ace.socket.impl;

import ro.ucv.ace.socket.IJobResult;

/**
 * Created by Geo on 30.11.2016.
 */
public class TestJobResult extends JobResult implements IJobResult {

    private int totalTests;

    private int passedTests;

    public int getTotalTests() {
        return totalTests;
    }

    public int getPassedTests() {
        return passedTests;
    }
}
