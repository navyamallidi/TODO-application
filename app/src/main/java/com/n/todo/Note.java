package com.n.todo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MyNotes")
public class Note {

    private String title;
    private String description;

    @PrimaryKey(autoGenerate = true)
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
