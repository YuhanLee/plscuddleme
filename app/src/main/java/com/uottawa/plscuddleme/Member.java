package com.uottawa.plscuddleme;

/**
 * Created by Yuhan on 11/1/2017.
 */

public class Member {
    private String id;
    private String memberEmail;
    private String familyMemberName;
    private String userRole;
    private int numberOfAssignedTasks;
    private int rewards;


    public Member() {}

    public Member(String id, String memberEmail, String familyMemberName, String userRole, int numberOfAssignedTasks, int rewards) {
        this.id = id;
        this.memberEmail = memberEmail;
        this.familyMemberName = familyMemberName;
        this.userRole = userRole;
        this.numberOfAssignedTasks = numberOfAssignedTasks;
        this.rewards = rewards;
    }



    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getfamilyMemberName() {
        return familyMemberName;
    }

    public void setfamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }

    public String getMemberEmail () {
        return memberEmail;
    }

    public void setEmail (String email) {
        this.memberEmail= email;
    }
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getNumberOfAssignedTasks() {
        return numberOfAssignedTasks;
    }

    public void setNumberOfAssignedTasks(int numberOfAssignedTasks) {
        this.numberOfAssignedTasks = numberOfAssignedTasks;
    }
    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards = rewards;
    }
}