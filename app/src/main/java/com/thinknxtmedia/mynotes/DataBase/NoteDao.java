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
    @Query("UPDATE noteentity SET Title = :uTitle WHERE id =:Uid")
    void noteTitle(String uTitle, int Uid);

    //Updating content
    @Query("UPDATE noteentity SET NoteDetails = :uNoteDetails WHERE id =:uid")
    void NoteNote(String uNoteDetails, int uid);

    //Update color
    @Query("UPDATE noteentity SET color = :colorHex WHERE id=:id")
    void UpdateColor(String colorHex, int id);

    //Update tag
    @Query("UPDATE noteentity SET trash = :editTrash WHERE id=:uId")
    void editTrash(String editTrash, int uId);

    //Checking data is available or not
    @Query("SELECT EXISTS(SELECT * FROM noteentity)")
    boolean getRow();

    //Searching tag wise
    @Query("SELECT * FROM NoteEntity WHERE Tag =:uTag and trash ='all'")
    List<NoteEntity> getTag(String uTag);

    //Starred Page
    @Query("SELECT * FROM noteentity WHERE starred ='1' and trash = 'all'")
    List<NoteEntity> getStarred();

    //Update starred page
    @Query("UPDATE noteentity SET starred ='0' WHERE id =:uId")
    void updateStarred(int uId);

    //Update starred page to one
    @Query("UPDATE noteentity SET starred ='1' WHERE id =:uId")
    void updateStarredOne(int uId);


}
