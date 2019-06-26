package com.joshjconlin.monitoring;

public class Monitoring implements MonitoringMBean {
    private int calls = 0;
    private String message = "Hello World!";

    public int getCalls() {
        return this.calls;
    }

    public void addCall() {
        this.calls += 1;
    }

    public String getMessage() {
        return this.message;
    }
}
