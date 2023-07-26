package com.example.groupcalendar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupcalendar.model.Event;
import com.example.groupcalendar.utils.CalendarUtils;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.EventData;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private CompactCalendarView compactCalendar;
    private RecyclerView eventRecyclerView;
    private EventAdapter eventAdapter;
    private Button addEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compactCalendar = findViewById(R.id.calendarView);
        eventRecyclerView = findViewById(R.id.eventRecyclerView);
        addEventButton = findViewById(R.id.addEventButton);

        initCalendar();
        initEventList();

        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddEventDialog();
            }
        });
    }

    private void initCalendar() {
        // Calendar 초기화 작업을 수행하는 메서드
        // CompactCalendarView의 설정 등을 진행합니다.
        // 예제에서는 별도의 초기화 작업은 하지 않았습니다.
    }

    private void initEventList() {
        // 이벤트 목록 초기화 작업을 수행하는 메서드
        // RecyclerView에 어댑터를 설정하고, 이벤트 목록을 표시해야 합니다.
        // 예를 들어, 이벤트 정보를 데이터베이스에서 가져와서 어댑터에 전달하는 등의 작업이 필요합니다.

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        eventRecyclerView.setLayoutManager(layoutManager);

        // 이벤트 어댑터 초기화 및 설정
        eventAdapter = new EventAdapter(CalendarUtils.getSampleEvents());
        eventRecyclerView.setAdapter(eventAdapter);
    }

    private void showAddEventDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Event");

        // Custom layout for the dialog
        View view = getLayoutInflater().inflate(R.layout.dialog_add_event, null);
        builder.setView(view);

        final EditText titleEditText = view.findViewById(R.id.titleEditText);
        final EditText descriptionEditText = view.findViewById(R.id.descriptionEditText);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                // Create a new EventData object to store the event data
                EventData eventData = new EventData(title, description);

                // Generate a random event ID and add the event to the CompactCalendarView
                String eventId = CalendarUtils.generateRandomEventId();
                Event event = new Event(eventId, eventData, new Date().getTime());
                compactCalendar.addEvent(event);

                // Update the event list in the RecyclerView
                eventAdapter.addEvent(event);

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
