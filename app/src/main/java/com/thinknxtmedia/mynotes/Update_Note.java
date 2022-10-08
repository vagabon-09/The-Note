package com.thinknxtmedia.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.EditText;

import com.thinknxtmedia.mynotes.databinding.ActivityUpdateNoteBinding;

import jp.wasabeef.richeditor.RichEditor;

public class Update_Note extends AppCompatActivity {
    ActivityUpdateNoteBinding binding;
EditText title;
RichEditor note;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        title = findViewById(R.id.update_NoteTitleId);
        note = findViewById(R.id.Update_NoteNotesId);
        Spanned title_u = Html.fromHtml(getIntent().getStringExtra("title"));
        title.setText(title_u);

        binding.UpdateNoteNotesId.getSettings().setJavaScriptEnabled(true);
        binding.UpdateNoteNotesId.loadData(getIntent().getStringExtra("note"), "text/html; charset=utf-8", "UTF-8");


    }
}