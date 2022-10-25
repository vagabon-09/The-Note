package com.thinknxtmedia.mynotes.Tools;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;

import androidx.room.Room;
import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;

import com.thinknxtmedia.mynotes.databinding.ActivityUpdateNoteBinding;

public class updateData {



    public updateData(Context applicationContext, String update_title, String update_note, int id) {
        NoteDataBase dataBase = Room.databaseBuilder(applicationContext, NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao noteDao = dataBase.noteDao();
        noteDao.noteTitle(update_title,id);
        noteDao.NoteNote(update_note,id);

    }
}
