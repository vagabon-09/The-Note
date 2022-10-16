package com.thinknxtmedia.mynotes.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    //For Inserting data into databse
    @Insert
    void InsertData(NoteEntity note);

    //Fetching data from room Database
    @Query("SELECT * FROM NoteEntity")
    List<NoteEntity> getAllData();

    //Getting data from all
    @Query("SELECT * FROM NoteEntity WHERE trash = 'all'")
    List<NoteEntity> getAll();

    //Fetching data to trash
    @Query("SELECT * FROM NoteEntity WHERE trash = 'trash'")
    List<NoteEntity> getTrash();

    //Deleting data from database
    @Query("DELETE FROM NoteEntity WHERE id = :uid")
    void DeleteNote(int uid);

    //Update dating note title
    @Query("UPDATE noteentity SET Title = :uTitle")
    void noteTitle(String uTitle);

    //Updating content
    @Query("UPDATE noteentity SET NoteDetails = :uNoteDetails")
    void NoteNote(String uNoteDetails);

    //Update tag
    @Query("UPDATE noteentity SET trash = :editTrash WHERE id=:uId")
    void editTrash(String editTrash, int uId);

    //Checking data is available or not
    @Query("SELECT EXISTS(SELECT * FROM noteentity)")
    boolean getRow();


}
