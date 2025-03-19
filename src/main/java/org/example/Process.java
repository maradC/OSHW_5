package org.example;

 public class Process {
    int id, burstTime, waitTime, turnAroundTime, priority;

    public Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

