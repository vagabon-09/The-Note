package com.thinknxtmedia.mynotes;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.thinknxtmedia.mynotes.Tools.updateData;
import com.thinknxtmedia.mynotes.databinding.ActivityUpdateNoteBinding;

import java.util.Objects;

import yuku.ambilwarna.AmbilWarnaDialog;


public class Update_Note extends AppCompatActivity {
    ActivityUpdateNoteBinding binding;
    EditText title;
    updateData updateData;
    String note_color;
    String noteTag;
    String ColorName;
    private int note_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Removing status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        note_color = getIntent().getStringExtra("color");
        noteTag = getIntent().getStringExtra("note_tag");
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


        //Bold button
        binding.boldTextId.setOnClickListener(view -> {
            Spannable spannableString = new SpannableStringBuilder(binding.UpdateNoteNotesId.getText());
            spannableString.setSpan(new StyleSpan(Typeface.BOLD),
                    binding.UpdateNoteNotesId.getSelectionStart(),
                    binding.UpdateNoteNotesId.getSelectionEnd(),
                    0);
            binding.UpdateNoteNotesId.setText(spannableString);
        });

        //Italic Button
        binding.ItalicTextId.setOnClickListener(view -> {
            Spannable spannableString = new SpannableStringBuilder(binding.UpdateNoteNotesId.getText());
            spannableString.setSpan(new StyleSpan(Typeface.ITALIC),
                    binding.UpdateNoteNotesId.getSelectionStart(),
                    binding.UpdateNoteNotesId.getSelectionEnd(),
                    0);
            binding.UpdateNoteNotesId.setText(spannableString);
        });

        //Center element
        binding.alignCenterId.setOnClickListener(view -> {
            binding.UpdateNoteNotesId.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            Spannable spannableString = new SpannableStringBuilder(binding.UpdateNoteNotesId.getText());
            binding.UpdateNoteNotesId.setText(spannableString);
        });

        //Right element
        binding.alignRightId.setOnClickListener(view -> {
            binding.UpdateNoteNotesId.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            Spannable spannableString = new SpannableStringBuilder(binding.UpdateNoteNotesId.getText());
            binding.UpdateNoteNotesId.setText(spannableString);
        });

        //End element
        binding.alignLeftId.setOnClickListener(view -> {
            binding.UpdateNoteNotesId.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            Spannable spannableString = new SpannableStringBuilder(binding.UpdateNoteNotesId.getText());
            binding.UpdateNoteNotesId.setText(spannableString);
        });


    }


    private void updateContent() {
        binding.noteSaveBtnId.setOnClickListener(view -> onBackPressed());
        binding.colorPanelId.setOnClickListener(view -> ColorDialogShow());
        binding.noteTagId.setOnClickListener(view -> showTagDialog());
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    private void showTagDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.note_tag);

        TextView all_tag = bottomSheetDialog.findViewById(R.id.all_tag_add);
        TextView home_tag = bottomSheetDialog.findViewById(R.id.home_tag_add);
        TextView work_tag = bottomSheetDialog.findViewById(R.id.work_tag_add);
        TextView personal_tag = bottomSheetDialog.findViewById(R.id.personal_tag_add);
        TextView set_tag = bottomSheetDialog.findViewById(R.id.NoteTagId);
        Button updateTag = bottomSheetDialog.findViewById(R.id.addTagButton);

        assert updateTag != null;
        updateTag.setOnClickListener(view -> bottomSheetDialog.dismiss());

        if (Objects.equals(noteTag, "")) {

            assert set_tag != null;
            set_tag.setText(noteTag);
            assert all_tag != null;
            all_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            assert home_tag != null;
            home_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert work_tag != null;
            work_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personal_tag != null;
            personal_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));

        } else if (Objects.equals(noteTag, "Home")) {

            assert set_tag != null;
            set_tag.setText(noteTag);
            assert home_tag != null;
            home_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            assert all_tag != null;
            all_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert work_tag != null;
            work_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personal_tag != null;
            personal_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));

        } else if (Objects.equals(noteTag, "Work")) {

            assert set_tag != null;
            set_tag.setText(noteTag);
            assert work_tag != null;
            work_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            assert home_tag != null;
            home_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert all_tag != null;
            all_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personal_tag != null;
            personal_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));

        } else if (Objects.equals(noteTag, "Personal")) {

            assert set_tag != null;
            set_tag.setText(noteTag);
            assert personal_tag != null;
            personal_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            assert home_tag != null;
            home_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert all_tag != null;
            all_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert work_tag != null;
            work_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        }

        assert all_tag != null;
        all_tag.setOnClickListener(view -> {
            noteTag = "All";
            all_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            assert home_tag != null;
            home_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert work_tag != null;
            work_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personal_tag != null;
            personal_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        });

        assert home_tag != null;
        home_tag.setOnClickListener(view -> {
            noteTag = "Home";
            home_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            all_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert work_tag != null;
            work_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personal_tag != null;
            personal_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        });

        assert work_tag != null;
        work_tag.setOnClickListener(view -> {
            noteTag = "Work";
            work_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            home_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            all_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personal_tag != null;
            personal_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        });

        assert personal_tag != null;
        personal_tag.setOnClickListener(view -> {
            noteTag = "Personal";
            personal_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            work_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            home_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            all_tag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        });


        bottomSheetDialog.show();
//        Toast.makeText(this, noteTag, Toast.LENGTH_SHORT).show();
    }

    private void ColorDialogShow() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.color_plate);
        View red_circle = bottomSheetDialog.findViewById(R.id.red_circle);
        View green_circle = bottomSheetDialog.findViewById(R.id.green_circle);
        View orange_circle = bottomSheetDialog.findViewById(R.id.orange_circle);
        View white_circle = bottomSheetDialog.findViewById(R.id.white_circle);
        View blue_circle = bottomSheetDialog.findViewById(R.id.blue_circle);
        View yellow_circle = bottomSheetDialog.findViewById(R.id.yellow_circle);
        View seaBlue_circle = bottomSheetDialog.findViewById(R.id.sea_blue_circle);
        View purple_circle = bottomSheetDialog.findViewById(R.id.purple_circle);

        assert red_circle != null;
        red_circle.setOnClickListener(view -> {
            note_color = "#EC0D0D";
            bottomSheetDialog.dismiss();
        });

        assert green_circle != null;
        green_circle.setOnClickListener(view -> {
            note_color = "#2FFF00";
            bottomSheetDialog.dismiss();
        });

        assert orange_circle != null;
        orange_circle.setOnClickListener(view -> {
            note_color = "#F37806";
            bottomSheetDialog.dismiss();
        });

        assert white_circle != null;
        white_circle.setOnClickListener(view -> {
            note_color = "#FFFFFF";
            bottomSheetDialog.dismiss();
        });

        assert blue_circle != null;
        blue_circle.setOnClickListener(view -> {
            note_color = "#3D1EF9";
            bottomSheetDialog.dismiss();
        });

        assert yellow_circle != null;
        yellow_circle.setOnClickListener(view -> {
            note_color = "#F9DC1E";
            bottomSheetDialog.dismiss();
        });

        assert seaBlue_circle != null;
        seaBlue_circle.setOnClickListener(view -> {
            note_color = "#6DA8FF";
            bottomSheetDialog.dismiss();
        });

        assert purple_circle != null;
        purple_circle.setOnClickListener(view -> {
            note_color = "#A800F7";
            bottomSheetDialog.dismiss();
        });

        //Color picker
        ImageView colorPicker = bottomSheetDialog.findViewById(R.id.color_picker);
        assert colorPicker != null;
        colorPicker.setOnClickListener(view -> pickColorDialog(bottomSheetDialog));

        bottomSheetDialog.show();
    }

    private void pickColorDialog(BottomSheetDialog bottomSheetDialog) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, R.color.red, false, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                note_color = "#" + Integer.toHexString(color);
                bottomSheetDialog.dismiss();
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }


        });
        dialog.show();
    }

    private void backBtnPressed() {
        binding.UpdateBackBtnId.setOnClickListener(view -> onBackPressed());
    }

    @SuppressLint({"SetJavaScriptEnabled", "UseCompatLoadingForDrawables"})
    private void setContent() {
        Spanned title_u = Html.fromHtml(getIntent().getStringExtra("title"));
        Spanned note_u = Html.fromHtml(getIntent().getStringExtra("note"));
        note_color = getIntent().getStringExtra("color");
        note_id = getIntent().getIntExtra("note_id", 0);


        //Setting Color panel btn color
        /* This code will set color panel background color */
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
        //Blue color
        else if (Objects.equals(note_color, "#3D1EF9")) {
            binding.colorPanelId.setBackground(getResources().getDrawable(R.drawable.blue_circle));
        }
        //Yellow Color
        else if (Objects.equals(note_color, "#F9DC1E")) {
            binding.colorPanelId.setBackground(getResources().getDrawable(R.drawable.yellow));
        }
        //Sea blue color
        else if (Objects.equals(note_color, "#6DA8FF")) {
            binding.colorPanelId.setBackground(getResources().getDrawable(R.drawable.sea_blue_circle));
        }
        //Purple Color
        else if (Objects.equals(note_color, "#A800F7")) {
            binding.colorPanelId.setBackground(getResources().getDrawable(R.drawable.purple_circle));
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
        updateData = new updateData(getApplicationContext(), binding.updateNoteTitleId.getText().toString(), span_text, note_id, note_color, noteTag);
        super.onBackPressed();

    }
}