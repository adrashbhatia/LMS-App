package com.example.xgenlms;



public class AttendanceReport {
    private final String studentName;
    private final boolean isPresent;

    public AttendanceReport(String studentName, boolean isPresent) {
        this.studentName = studentName;
        this.isPresent = isPresent;
    }

    public String getStudentName() {
        return studentName;
    }

    public boolean isPresent() {
        return isPresent;
    }
}
