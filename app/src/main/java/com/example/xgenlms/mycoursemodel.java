package com.example.xgenlms;

public class mycoursemodel {
    private String name;
    private String schedule;
    private String venue;

    public mycoursemodel(String name, String schedule, String venue) {
        this.name = name;
        this.schedule = schedule;
        this.venue = venue;
    }

    public String getName() {
        return name;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getVenue() {
        return venue;
    }
}
