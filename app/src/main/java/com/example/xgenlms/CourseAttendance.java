package com.example.xgenlms;
//CourseAttendanceC class to hold data
class CourseAttendanceC {
    private String courseName;
    private int presentCount;
    private int absentCount;

    public CourseAttendanceC(String courseName, int presentCount, int absentCount) {
        this.courseName = courseName;
        this.presentCount = presentCount;
        this.absentCount = absentCount;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public int getAbsentCount() {
        return absentCount;
    }
}
