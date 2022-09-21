package com.thinknxtmedia.mynotes.Tools;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.databinding.ActivityNoteMakngPageBinding;

public class InsertData {
    public InsertData(Context applicationContext, String title, String notes, String tag, ActivityNoteMakngPageBinding binding) {
        if (title.isEmpty()){
            Toast.makeText(applicationContext, "Please Enter Title First.", Toast.LENGTH_SHORT).show();
        }else if (notes.isEmpty()){
            Toast.makeText(applicationContext, "Please Make Note First.", Toast.LENGTH_SHORT).show();
        }else{
            NoteDataBase dataBase = Room.databaseBuilder(applicationContext,NoteDataBase.class,"NoteDataBase").allowMainThreadQueries().build();
            NoteDao noteDao = dataBase.noteDao();
            NoteEntity noteEntity = new NoteEntity(0,title,notes,tag);
            noteDao.InsertData(noteEntity);
            binding.NoteTitleId.setText("");
            binding.NoteNotesId.setText("");
            Toast.makeText(applicationContext, "Successfully created your note.", Toast.LENGTH_SHORT).show();
        }

    }


}
