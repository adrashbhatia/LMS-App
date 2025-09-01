package com.example.xgenlms;

public class Grade {
    private String assignmentName;
    private int obtainedMarks;
    private int totalMarks;

    public Grade(String assignmentName, int obtainedMarks, int totalMarks) {
        this.assignmentName = assignmentName;
        this.obtainedMarks = obtainedMarks;
        this.totalMarks = totalMarks;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public int getObtainedMarks() {
        return obtainedMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public String getFormattedMarks() {
        return obtainedMarks + " out of " + totalMarks;
    }
}
