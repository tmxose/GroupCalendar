package com.example.groupcalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomCalendarView extends LinearLayout {
    private CompactCalendarView compactCalendarView;
    private TextView monthTitleTextView;
    private List<Event> personalEventsList = new ArrayList<>();
    private List<Event> groupEventsList = new ArrayList<>();

    public CustomCalendarView(Context context) {
        super(context);
        init(context);
    }

    public CustomCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_calendar_view, this);

        compactCalendarView = findViewById(R.id.compactCalendarView);
        monthTitleTextView = findViewById(R.id.monthTextView);

        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                // 날짜를 클릭했을 때 처리하는 코드 추가
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                updateMonthTitle(firstDayOfNewMonth);
            }
        });

        updateMonthTitle(compactCalendarView.getFirstDayOfCurrentMonth());
    }

    private void updateMonthTitle(Date date) {
        // 월의 타이틀을 업데이트하는 코드 추가
    }

    public void addPersonalEvent(Event event) {
        personalEventsList.add(event);
        compactCalendarView.addEvent(event);
    }

    public void addGroupEvent(Event event) {
        groupEventsList.add(event);
        compactCalendarView.addEvent(event);
    }

    public void removePersonalEvent(Event event) {
        personalEventsList.remove(event);
        compactCalendarView.removeEvent(event);
    }

    public void removeGroupEvent(Event event) {
        groupEventsList.remove(event);
        compactCalendarView.removeEvent(event);
    }

    public void addPersonalEvents(List<Event> events) {
        personalEventsList.addAll(events);
        compactCalendarView.addEvents(events);
    }

    public void addGroupEvents(List<Event> events) {
        groupEventsList.addAll(events);
        compactCalendarView.addEvents(events);
    }

    public void removePersonalEvents(List<Event> events) {
        personalEventsList.removeAll(events);
        compactCalendarView.removeEvents(events);
    }

    public void removeGroupEvents(List<Event> events) {
        groupEventsList.removeAll(events);
        compactCalendarView.removeEvents(events);
    }

    public void setListener(CompactCalendarView.CompactCalendarViewListener listener) {
        compactCalendarView.setListener(listener);
    }
}
