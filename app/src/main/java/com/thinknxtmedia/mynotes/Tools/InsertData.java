package com.thinknxtmedia.mynotes.Tools;

import android.content.Context;

import androidx.room.Room;

import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
import com.thinknxtmedia.mynotes.DataBase.NoteEntity;

public class InsertData {
    public InsertData(Context applicationContext, String title, String notes, String tag) {
        NoteDataBase dataBase = Room.databaseBuilder(applicationContext,NoteDataBase.class,"NoteDataBase").allowMainThreadQueries().build();
        NoteDao noteDao = dataBase.noteDao();
        NoteEntity noteEntity = new NoteEntity(0,title,notes,tag);
       noteDao.InsertData(noteEntity);
    }


}
