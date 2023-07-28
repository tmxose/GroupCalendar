package com.example.groupcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CreateEventActivity extends AppCompatActivity {

    public static final String EXTRA_EVENT = "com.example.groupcalendar.EXTRA_EVENT";
    private List<String> selectedGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        selectedGroups = new ArrayList<>();

        // Get references to UI elements
        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText descriptionEditText = findViewById(R.id.descriptionEditText);
        CheckBox group1CheckBox = findViewById(R.id.group1CheckBox);
        CheckBox group2CheckBox = findViewById(R.id.group2CheckBox);
        CheckBox group3CheckBox = findViewById(R.id.group3CheckBox);
        Button createEventButton = findViewById(R.id.createEventButton);

        // Set up the "Create Event" button
        createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get event details from the UI elements
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                // Check if any group checkboxes are selected
                if (group1CheckBox.isChecked()) {
                    selectedGroups.add("Group 1");
                }
                if (group2CheckBox.isChecked()) {
                    selectedGroups.add("Group 2");
                }
                if (group3CheckBox.isChecked()) {
                    selectedGroups.add("Group 3");
                }

                // Validate input fields
                if (title.trim().isEmpty()) {
                    Toast.makeText(CreateEventActivity.this, "Please enter a title", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create the new event and send it back to the MainActivity
                Event newEvent = new Event(title, description);
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_EVENT, newEvent);
                resultIntent.putStringArrayListExtra("selectedGroups", (ArrayList<String>) selectedGroups);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
