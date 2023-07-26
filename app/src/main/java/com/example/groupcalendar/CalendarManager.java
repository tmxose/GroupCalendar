package com.example.groupcalendar;

import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    private static CalendarManager instance;
    private List<CalendarEvent> events;

    private CalendarManager() {
        events = new ArrayList<>();
    }

    public static CalendarManager getInstance() {
        if (instance == null) {
            instance = new CalendarManager();
        }
        return instance;
    }

    public void addEvent(CalendarEvent event) {
        events.add(event);
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void clearEvents() {
        events.clear();
    }
}
