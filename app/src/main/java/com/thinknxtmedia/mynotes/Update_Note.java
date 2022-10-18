package com.thinknxtmedia.mynotes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.thinknxtmedia.mynotes.Tools.updateData;
import com.thinknxtmedia.mynotes.databinding.ActivityUpdateNoteBinding;

public class Update_Note extends AppCompatActivity {
    ActivityUpdateNoteBinding binding;
    EditText title, note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Removing status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //finding views from layout
        getView();
        //Setting data to views
        setContent();
        //onBackBtn Pressed
        backBtnPressed();
        //Update Content
        updateContent();
        //Edit Text
        textEditor();
    }

    private void textEditor() {



    }

    private void updateContent() {
        binding.noteSaveBtnId.setOnClickListener(view -> onBackPressed());
    }

    private void backBtnPressed() {
        binding.UpdateBackBtnId.setOnClickListener(view -> onBackPressed());
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setContent() {
        Spanned title_u = Html.fromHtml(getIntent().getStringExtra("title"));
        Spanned note_u = Html.fromHtml(getIntent().getStringExtra("note"));
        title.setText(title_u);
        binding.UpdateNoteNotesId.setText(note_u);
        binding.UpdateNoteNotesId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.noteSaveBtnId.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void getView() {
        title = findViewById(R.id.update_NoteTitleId);
        note = findViewById(R.id.Update_NoteNotesId);
    }

    @Override
    public void onBackPressed() {
        updateData updateData = new updateData(getApplicationContext(), binding.updateNoteTitleId.getText().toString(), binding.UpdateNoteNotesId.getText().toString(), binding);
        super.onBackPressed();

    }
}