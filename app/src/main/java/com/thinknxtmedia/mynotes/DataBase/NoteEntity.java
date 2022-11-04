package com.thinknxtmedia.mynotes.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NoteEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "Title")
    public String title;
    @ColumnInfo(name = "NoteDetails")
    public String note;
    @ColumnInfo(name = "Tag")
    public String tag;
    @ColumnInfo(name = "trash")
    public String trash;
    @ColumnInfo(name = "color")
    public String color;
    @ColumnInfo(name = "starred")
    public String starred;
    @ColumnInfo(name = "pin")
    public String pin;

    public NoteEntity(int id, String title, String note, String tag, String trash, String color, String starred, String pin) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.tag = tag;
        this.trash = trash;
        this.color = color;
        this.starred = starred;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTag() {
        return tag;
    }

    public String setTag(String tag) {
        this.tag = tag;
        return tag;
    }

    public String getTrash() {
        return trash;
    }

    public String setTrash(String trash) {
        this.trash = trash;
        return trash;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStarred() {
        return starred;
    }

    public void setStarred(String starred) {
        this.starred = starred;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
