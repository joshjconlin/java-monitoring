package com.joshjconlin.monitoring;

public interface MonitoringMBean {
    public int getCalls();
    public void addCall();
    public String getMessage();
}
