package com.thinknxtmedia.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class Update_Note extends AppCompatActivity {
TextView title;
TextView note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);
        title = findViewById(R.id.update_NoteTitleId);
        note = findViewById(R.id.Update_NoteNotesId);
         Spanned title_u = Html.fromHtml(getIntent().getStringExtra("title"));
         Spanned note_u = Html.fromHtml(getIntent().getStringExtra("note"));
        title.setText(title_u);
        note.setText(note_u);



    }
}