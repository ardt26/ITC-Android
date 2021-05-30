package com.example.myroomnote.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myroomnote.model.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM notes")
    List<Note> getAllData();

    @Insert
    void insertData(Note note);

    @Update
    void updateData(Note note);

    @Delete
    void deleteData(Note note);
}
