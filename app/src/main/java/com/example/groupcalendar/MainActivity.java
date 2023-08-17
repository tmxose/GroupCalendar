package com.example.groupcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.groupcalendar.DefaultCalendarActivity;
import com.example.groupcalendar.CalendarViewActivity;
import com.example.groupcalendar.SettingsActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView userInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInfoTextView = findViewById(R.id.userInfoTextView);

        // 로그인된 사용자 정보 표시
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userEmail = user.getEmail();
            userInfoTextView.setText("Welcome, " + userEmail + "!");
        }

        setupButton(R.id.defaultCalendarButton, DefaultCalendarActivity.class);
        setupButton(R.id.groupCalendarButton, CalendarViewActivity.class);
        setupButton(R.id.settingsButton, SettingsActivity.class);
    }

    private void setupButton(int buttonId, final Class<?> targetActivityClass) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, targetActivityClass);
            startActivity(intent);
        });
    }
}