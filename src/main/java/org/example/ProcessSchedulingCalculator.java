package org.example;

import java.util.*;

public class ProcessSchedulingCalculator {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 2, 2));
        processes.add(new Process(2, 1, 1));
        processes.add(new Process(3, 8, 4));
        processes.add(new Process(4, 4, 2));
        processes.add(new Process(5, 5, 3));

        // FCFS
        List<Process> fcfsProcesses = new ArrayList<>(processes);
        calculateFCFS(fcfsProcesses);
        displayResults(fcfsProcesses, "FCFS");

        // SJF
        List<Process> sjfProcesses = new ArrayList<>(processes);
        calculateSJF(sjfProcesses);
        displayResults(sjfProcesses, "SJF");
    }

    private static void calculateFCFS(List<Process> processes) {
        int currentTime = 0;
        for (Process p : processes) {
            p.waitTime = currentTime;
            p.turnAroundTime = currentTime + p.burstTime;
            currentTime += p.burstTime;
        }
    }

    private static void calculateSJF(List<Process> processes) {
        Collections.sort(processes, Comparator.comparingInt(p -> p.burstTime));
        int currentTime = 0;
        for (Process p : processes) {
            p.waitTime = currentTime;
            p.turnAroundTime = currentTime + p.burstTime;
            currentTime += p.burstTime;
        }
    }

    private static void displayResults(List<Process> processes, String algorithm) {
        System.out.println("----------------- " + algorithm + " -----------------");
        System.out.println("Process ID | Waiting Time | Turnaround Time");

        double totalWait = 0, totalTurnaround = 0;
        for (Process p : processes) {
            System.out.printf("     %d     |      %d       |        %d    \n",
                    p.id, p.waitTime, p.turnAroundTime);
            totalWait += p.waitTime;
            totalTurnaround += p.turnAroundTime;
        }

        System.out.println("Average Waiting Time: " + (totalWait / processes.size()));
        System.out.println("Average Turnaround Time: " + (totalTurnaround / processes.size()));
        System.out.println();
    }
}