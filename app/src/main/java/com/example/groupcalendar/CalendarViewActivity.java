package com.example.groupcalendar;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
// 필요한 import 문은 제외하였습니다.

public class CalendarViewActivity extends AppCompatActivity {

    private CompactCalendarView compactCalendarView;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM - yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        compactCalendarView = findViewById(R.id.compactcalendar_view);
        compactCalendarView.setUseThreeLetterAbbreviation(true);
        getSupportActionBar().setTitle(dateFormatMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));

        setupCompactCalendarView();
        setupAddEventButton();
        addTestEvent();
    }

    private void setupCompactCalendarView() {
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                // 클릭한 날짜에 대한 이벤트 처리
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                getSupportActionBar().setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
    }

    private void setupAddEventButton() {
        Button addButton = findViewById(R.id.buttonAddEvent);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddEventDialog();
            }
        });
    }

    private void addTestEvent() {
        Event event = new Event(getResources().getColor(R.color.colorAccent), System.currentTimeMillis(), "일정 제목");
        compactCalendarView.addEvent(event);
    }

    private void showAddEventDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_event, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextEventTitle = dialogView.findViewById(R.id.editTextEventTitle);
        Button addButton = dialogView.findViewById(R.id.buttonAddEvent);

        final AlertDialog alertDialog = dialogBuilder.create();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventTitle = editTextEventTitle.getText().toString();
                if (!eventTitle.isEmpty()) {
                    Date selectedDate = new Date(); // 예를 들어 선택한 날짜 가져오기
                    long timeInMillis = selectedDate.getTime();
                    Event event = new Event(Color.BLUE, timeInMillis, eventTitle);
                    compactCalendarView.addEvent(event);

                    alertDialog.dismiss();
                } else {
                    // 제목이 비어있을 때의 처리
                }
            }
        });

        alertDialog.show();
    }
}
