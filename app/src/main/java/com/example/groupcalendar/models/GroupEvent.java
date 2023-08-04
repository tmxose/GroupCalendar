package com.example.groupcalendar.models;

public class GroupEvent {
    private String eventId;
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private boolean isRepeated;

    public GroupEvent() {
        // Default constructor required for Firebase
    }

    public GroupEvent(String eventId, String title, String date, String time, String location, String description, boolean isRepeated) {
        this.eventId = eventId;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.isRepeated = isRepeated;
    }

    // Getters and setters

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRepeated() {
        return isRepeated;
    }

    public void setRepeated(boolean repeated) {
        isRepeated = repeated;
    }
}
