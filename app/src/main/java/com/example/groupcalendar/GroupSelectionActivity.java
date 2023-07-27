package com.example.groupcalendar;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GroupSelectionActivity extends AppCompatActivity {

    private List<String> selectedGroups = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_selection);

        // 그룹 목록을 동적으로 추가할 레이아웃
        LinearLayout groupListLayout = findViewById(R.id.groupListLayout);

        // 사용자가 가입된 여러 그룹을 가정한 예시 (실제로는 데이터베이스에서 사용자가 가입한 그룹을 가져와야 함)
        List<String> groups = new ArrayList<>();
        groups.add("Group A");
        groups.add("Group B");
        groups.add("Group C");
        groups.add("Group D");

        // 동적으로 체크박스 목록을 생성하여 레이아웃에 추가
        for (String group : groups) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(group);
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    selectedGroups.add(group); // 선택한 그룹 추가
                } else {
                    selectedGroups.remove(group); // 선택 해제한 그룹 제거
                }
            });
            groupListLayout.addView(checkBox);
        }

        // "Confirm" 버튼 클릭 리스너 설정
        findViewById(R.id.confirmButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 선택한 그룹들을 메인 액티비티에 반환
                getIntent().putStringArrayListExtra("selectedGroups", (ArrayList<String>) selectedGroups);
                setResult(RESULT_OK, getIntent());
                finish();
            }
        });
    }
}
