package com.example.xgenlms;

public class Course_Model_Class_d {
    private String title;
    private String description;

    public Course_Model_Class_d(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title;
    }
}
