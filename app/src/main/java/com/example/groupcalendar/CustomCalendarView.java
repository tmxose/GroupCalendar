package com.example.groupcalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CustomCalendarView extends LinearLayout {
    private TextView monthTextView;
    private CompactCalendarView compactCalendarView;

    public CustomCalendarView(Context context) {
        super(context);
        init(context);
    }

    public CustomCalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_calendar_view, this);

        monthTextView = findViewById(R.id.monthTextView);
        compactCalendarView = findViewById(R.id.compactCalendarView);

        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                // 날짜를 클릭했을 때의 동작 처리
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
                monthTextView.setText(sdf.format(firstDayOfNewMonth));
            }
        });
    }

    public void addPersonalEvents(List<Event> events) {
        for (Event event : events) {
            compactCalendarView.addEvent(new com.github.sundeepk.compactcalendarview.domain.Event(event.getColor(), event.getTimeInMillis()));
        }
    }

    public void addGroupEvents(List<Event> events) {
        for (Event event : events) {
            compactCalendarView.addEvent(new com.github.sundeepk.compactcalendarview.domain.Event(event.getColor(), event.getTimeInMillis()));
        }
    }
}
