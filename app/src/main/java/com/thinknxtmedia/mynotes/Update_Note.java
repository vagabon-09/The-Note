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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.thinknxtmedia.mynotes.Tools.updateData;
import com.thinknxtmedia.mynotes.databinding.ActivityUpdateNoteBinding;

import java.util.Objects;


public class Update_Note extends AppCompatActivity {
    ActivityUpdateNoteBinding binding;
    EditText title;
    updateData updateData;
    private String ColorName, text_data;
    private int note_id;

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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.color_plate);

        //show color plate
//        binding.colorPanelId.setOnClickListener(view -> bottomSheetDialog.show());

        //Red circle
        View red_Circle = bottomSheetDialog.findViewById(R.id.red_circle);
        assert red_Circle != null;
        red_Circle.setOnClickListener(view -> {
            ColorName = "#EC0D0D";
            Toast.makeText(this, "Red Circle..", Toast.LENGTH_SHORT).show();
            bottomSheetDialog.dismiss();
        });
        //Green circle
        View green_circle = bottomSheetDialog.findViewById(R.id.green_circle);
        assert green_circle != null;
        green_circle.setOnClickListener(view -> {
            ColorName = "#2FFF00";
            Toast.makeText(this, "green circle", Toast.LENGTH_SHORT).show();
            bottomSheetDialog.dismiss();
        });
        //Orange circle
        View orange_circle = bottomSheetDialog.findViewById(R.id.orange_circle);
        assert orange_circle != null;
        orange_circle.setOnClickListener(view -> {
            ColorName = "#F37806";
            bottomSheetDialog.dismiss();
        });
        //White Circle
        View white_circle = bottomSheetDialog.findViewById(R.id.white_circle);
        assert white_circle != null;
        white_circle.setOnClickListener(view -> {
            ColorName = "#FFFFFFFF";
            Toast.makeText(this, "White Circle", Toast.LENGTH_SHORT).show();
            bottomSheetDialog.dismiss();
        });

    }

    private void updateContent() {
        binding.noteSaveBtnId.setOnClickListener(view -> onBackPressed());
        binding.colorPanelId.setOnClickListener(view -> {
            ColorDialogShow();
        });
        binding.noteTagId.setOnClickListener(view -> {
            showTagDialog();
        });
    }

    private void showTagDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.note_tag);
        bottomSheetDialog.show();
    }

    private void ColorDialogShow() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.color_plate);
        bottomSheetDialog.show();
    }

    private void backBtnPressed() {
        binding.UpdateBackBtnId.setOnClickListener(view -> onBackPressed());
    }

    @SuppressLint({"SetJavaScriptEnabled", "UseCompatLoadingForDrawables"})
    private void setContent() {
        Spanned title_u = Html.fromHtml(getIntent().getStringExtra("title"));
        Spanned note_u = Html.fromHtml(getIntent().getStringExtra("note"));
        String note_color = getIntent().getStringExtra("color");
        note_id = getIntent().getIntExtra("note_id", 0);


        //Red color
        if (Objects.equals(note_color, "#EC0D0D")) {
            binding.colorPanelId.setBackground(getResources().getDrawable(R.drawable.red_circle));
        }
        //Green color
        else if (Objects.equals(note_color, "#2FFF00")) {
            binding.colorPanelId.setBackground(getResources().getDrawable(R.drawable.green_circle));
        }
        //Orange color
        else if (Objects.equals(note_color, "#F37806")) {
            binding.colorPanelId.setBackground(getResources().getDrawable(R.drawable.orange_circle));
        }
        //White color
        else if (Objects.equals(note_color, "#D9D9D9")) {
            binding.colorPanelId.setBackground(getResources().getDrawable(R.drawable.white_circle));
        }


        title.setText(title_u);
//        binding.UpdateNoteNotesId.loadData(Html.fromHtml(getIntent().getStringExtra("note"),text/html, "UTF-8"));

        binding.UpdateNoteNotesId.setText(note_u);
//        Toast.makeText(this, note_u, Toast.LENGTH_SHORT).show();
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
//        note = findViewById(R.id.Update_NoteNotesId);
    }

    @Override
    public void onBackPressed() {
        String span_text = Html.toHtml(binding.UpdateNoteNotesId.getText());
        updateData = new updateData(getApplicationContext(), binding.updateNoteTitleId.getText().toString(), span_text, note_id);
        super.onBackPressed();

    }
}