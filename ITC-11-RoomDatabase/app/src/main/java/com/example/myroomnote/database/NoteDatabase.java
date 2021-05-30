package com.example.myroomnote.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myroomnote.model.Note;

@Database(entities = Note.class, version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    private static String DB_NAME = "db_notes";
    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static NoteDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
