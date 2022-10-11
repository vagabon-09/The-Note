package com.thinknxtmedia.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.WindowManager;
import android.widget.EditText;

import com.thinknxtmedia.mynotes.databinding.ActivityUpdateNoteBinding;

import jp.wasabeef.richeditor.RichEditor;

public class Update_Note extends AppCompatActivity {
    ActivityUpdateNoteBinding binding;
EditText title;
RichEditor note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Removing status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //finding views from layout
        getView();
        //Setting data to views
        setContent();
        //onBackBtn Pressed
        backBtnPressed();
    }

    private void backBtnPressed() {
        binding.UpdateBackBtnId.setOnClickListener(view-> onBackPressed());
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setContent() {
        Spanned title_u = Html.fromHtml(getIntent().getStringExtra("title"));
        title.setText(title_u);
        binding.UpdateNoteNotesId.loadData(getIntent().getStringExtra("note"), "text/html; charset=utf-8", "UTF-8");

    }

    private void getView() {
        title = findViewById(R.id.update_NoteTitleId);
        note = findViewById(R.id.Update_NoteNotesId);
    }

}