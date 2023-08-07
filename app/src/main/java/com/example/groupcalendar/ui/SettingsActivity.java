package com.example.groupcalendar.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupcalendar.R;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // 설정 페이지의 UI 구현
        TextView textView = findViewById(R.id.textView);
        textView.setText("설정 페이지");
    }
}

