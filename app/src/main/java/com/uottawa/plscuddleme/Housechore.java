package com.uottawa.plscuddleme;

import java.util.Date;

/**
 * Created by Yuhan on 10/31/2017.
 */

public class Housechore {
    private int id;
    private String housechoreName;
    private String assignedBy;
    private String assignedTo;
    private String deletedBy;
    private Date dueDate;
    private String priority;
    private String category;
    private Boolean statusCompleted;
    private int reward;
    private String note;
//TODO consider if should add user previlage for deletion --> if so then need to add an extra attribute.


    public Housechore() {

    }

    public Housechore (int id, String housechoreName, String assignedTo, String assignedBy, String deletedBy, Date dueDate, String priority, String category, Boolean statusCompleted, int reward, String note) {
        this.id = id;
        this.housechoreName = housechoreName;
        this.assignedTo = assignedTo;
        this.assignedBy = assignedBy;
        this.deletedBy = deletedBy; //null at the beginning
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.statusCompleted = statusCompleted;
        this.reward = reward;
        this.note = note;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setHousechoreName (String housechoreName) {
        this.housechoreName = housechoreName;
    }
    public String getHousechoreName() {
        return housechoreName;
    }

    public void setAssignedTo (String personAssigned) {
        this.assignedTo = personAssigned;
    }
    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedBy (String taskAssignedBy) {
        this.assignedBy = taskAssignedBy;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setDeletedBy(String taskDeletedBy) {
        this.deletedBy = taskDeletedBy;
    }

    public String getDeletedBy () {
       return deletedBy;
    }

    public void setDueDate (Date dueDate) {
        this.dueDate = dueDate;
    }
    public Date getDueDate() {
        return dueDate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public void setCategory(String category) {
        category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCompletionStatus(boolean completed) {
        statusCompleted = completed;
    }

    public boolean getCompletedStatus() {
        return statusCompleted;
    }

    public void setReward(int reward) {
        reward = reward;
    }
    public int getReward() {
        return reward;
    }

    public void setNote(String note) {
        note = note;
    }
    public String getNote() {
        return note;
    }

}
