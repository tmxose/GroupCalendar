// GroupManager.java (Helper 클래스)
package com.example.groupcalendar.helpers;

import com.example.groupcalendar.models.Group;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GroupManager {
    private static final String GROUPS_NODE = "groups";

    private DatabaseReference groupsRef;

    public GroupManager() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        groupsRef = database.getReference(GROUPS_NODE);
    }

    public void createGroup(String groupName) {
        String groupId = groupsRef.push().getKey();
        Group group = new Group(groupId, groupName);
        groupsRef.child(groupId).setValue(group);
    }

    // 그룹에 멤버 추가/제거, 그룹 정보 수정 등의 메서드를 추가해주세요.
}
