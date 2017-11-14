package com.uottawa.plscuddleme;

import java.util.Date;

/**
 * Created by Yuhan on 11/1/2017.
 */

public class Item {
    private int id;
    private String itemName;
    private Date dueDate;
    private String note;


    public Item(int id, String itemName, Date dueDate, String note) {
        this.id = id;
        this.itemName = itemName;
        this.dueDate = dueDate;
        this.note = note;
    }
    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setDueDate (Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setNote (String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }


}

