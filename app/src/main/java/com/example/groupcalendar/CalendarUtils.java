package com.example.groupcalendar;

import com.example.groupcalendar.Event;
import com.github.sundeepk.compactcalendarview.domain.EventData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CalendarUtils {

    public static List<Event> getSampleEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(generateRandomEventId(), new EventData("Event 1", "Description 1"), getTime(2023, Calendar.JUNE, 15)));
        events.add(new Event(generateRandomEventId(), new EventData("Event 2", "Description 2"), getTime(2023, Calendar.JUNE, 20)));
        events.add(new Event(generateRandomEventId(), new EventData("Event 3", "Description 3"), getTime(2023, Calendar.JUNE, 25)));
        return events;
    }

    public static long getTime(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    public static String generateRandomEventId() {
        return UUID.randomUUID().toString();
    }
}
