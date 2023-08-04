// Group.java (Model)
package com.example.groupcalendar.models;

public class Group {
    private String groupId;
    private String groupName;

    // 기본 생성자
    public Group() {
        // Firebase Realtime Database에서 데이터를 읽어올 때 필요한 기본 생성자
    }

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    // Getter, Setter 메서드
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    // 추가적인 그룹 정보 필드들에 대한 Getter, Setter 메서드를 추가해주세요.

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                // 추가적인 그룹 정보 필드들을 toString에 추가해주세요.
                '}';
    }
}
