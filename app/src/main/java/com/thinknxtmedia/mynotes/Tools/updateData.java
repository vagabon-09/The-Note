package com.thinknxtmedia.mynotes.Tools;

import android.content.Context;
import android.text.Editable;

import androidx.room.Room;
import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;

import com.thinknxtmedia.mynotes.databinding.ActivityUpdateNoteBinding;

public class updateData {



    public updateData(Context applicationContext, String text, String text1, ActivityUpdateNoteBinding binding) {
        NoteDataBase dataBase = Room.databaseBuilder(applicationContext, NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao noteDao = dataBase.noteDao();
        noteDao.noteTitle(text);
        noteDao.NoteNote(text1);
    }
}
