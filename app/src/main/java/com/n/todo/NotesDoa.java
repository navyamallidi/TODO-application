package com.n.todo;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDoa {

    @Insert
    public void insert(Note note);

    @Delete
    public void delete(Note note);

    @Update
    public void update(Note note);

    @Query("SELECT * FROM MyNotes")
    public LiveData<List<Note>> getAllDate();
}
