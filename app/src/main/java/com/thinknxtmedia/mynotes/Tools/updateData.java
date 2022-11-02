package com.thinknxtmedia.mynotes.Tools;

import android.content.Context;

import androidx.room.Room;

import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;

public class updateData {


    public updateData(Context applicationContext, String update_title, String update_note, int id, String updateColor, String noteTag) {
        NoteDataBase dataBase = Room.databaseBuilder(applicationContext, NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao noteDao = dataBase.noteDao();
        noteDao.noteTitle(update_title, id);
        noteDao.NoteNote(update_note, id);
        noteDao.UpdateColor(updateColor, id);
        noteDao.updateTag(noteTag,id);
    }
}
