package com.thinknxtmedia.mynotes.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {NoteEntity.class},version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
