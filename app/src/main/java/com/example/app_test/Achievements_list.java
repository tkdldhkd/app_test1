package com.example.app_test;

public class Achievements_list {
    private long triggerTimeMillis;
    private String title;
    private String message;

    private String ID;
    public Achievements_list(long triggerTimeMillis, String title, String message, String ID) {
        this.triggerTimeMillis = triggerTimeMillis;
        this.title = title;
        this.message = message;
        this.ID = ID;
    }

    public long getTriggerTimeMillis() {
        return triggerTimeMillis;
    }

    public String getTitle() {
        return title;
    }

    public String getID() {
        return ID;
    }

    public String getMessage() {
        return message;
    }
}
