package com.thinknxtmedia.mynotes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;
import com.thinknxtmedia.mynotes.Tools.FontEditor;
import com.thinknxtmedia.mynotes.Tools.InsertData;
import com.thinknxtmedia.mynotes.databinding.ActivityNoteMakngPageBinding;

import yuku.ambilwarna.AmbilWarnaDialog;


public class note_makng_page extends AppCompatActivity {
    static String note_data = "";
    ActivityNoteMakngPageBinding binding;
    InsertData insertData;
    String tag;
    Button tagSave;
    EditText EditTag;
    ReplaceFreagment replaceFreagment;
    FontEditor fontEditor;
    String ColorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteMakngPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Removing task bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Fragment class object creating here
        replaceFreagment = new ReplaceFreagment();
        //Setting bottom
        ButtonFunction();
        //Note Function
        checkNoteEmptyorNot();
        //Sending data to the database
        sendDataToDataBase();
        //Giving font style
        fontEditor = new FontEditor(binding);
        //Sending data in note making page


    }


    @SuppressLint("CutPasteId")
    private void sendDataToDataBase() {
        @SuppressLint("InflateParams") final View view1 = getLayoutInflater().inflate(R.layout.note_tag, null);
        tagSave = view1.findViewById(R.id.addTagButton);
//        EditTag = view1.findViewById(R.id.NoteTagId);
        tagSave.setOnClickListener(view -> {
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
            Log.d("LogdIS", "sendDataToDataBase: " + EditTag.toString());
        });

        binding.NoteNotesId.setOnTextChangeListener(text -> {
            binding.noteSaveBtnId.setVisibility(View.VISIBLE);
            binding.HintNote.setVisibility(View.GONE);
            note_data = text;
        });

        binding.noteSaveBtnId.setOnClickListener(view -> onBackPressed());
    }


    private void checkNoteEmptyorNot() {

        binding.NoteTitleId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.noteSaveBtnId.setVisibility(View.GONE);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.noteSaveBtnId.setVisibility(View.VISIBLE);

            }
        });


    }

    private void ButtonFunction() {
        //When users pressed back button
        binding.backBtnId.setOnClickListener(view -> onBackPressed());
        //When user click on color panel button
        binding.colorPanelId.setOnClickListener(view -> colorPlate());
        //When user clicked add Tag button
        binding.noteTagId.setOnClickListener(view -> TagDialogBox());


    }

    private void colorPlate() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.color_plate);
        View red_circle = bottomSheetDialog.findViewById(R.id.red_circle);
        ImageView colorPicker = bottomSheetDialog.findViewById(R.id.color_picker);
        //Red circle
        assert red_circle != null;
        red_circle.setOnClickListener(view -> {
            ColorName = "#EC0D0D";
            bottomSheetDialog.dismiss();
        });
        //Green Circle
        View green_circle = bottomSheetDialog.findViewById(R.id.green_circle);
        assert green_circle != null;
        green_circle.setOnClickListener(view -> {
            ColorName = "#2FFF00";
            bottomSheetDialog.dismiss();
        });
        //Orange Color
        View orange_color = bottomSheetDialog.findViewById(R.id.orange_circle);
        assert orange_color != null;
        orange_color.setOnClickListener(view -> {
            ColorName = "#F37806";
            bottomSheetDialog.dismiss();
        });
        //White Circle
        View white_circle = bottomSheetDialog.findViewById(R.id.white_circle);
        assert white_circle != null;
        white_circle.setOnClickListener(view -> {
            ColorName = "#FFFFFF";
            bottomSheetDialog.dismiss();
        });

        //Blue circle
        View blue_circle = bottomSheetDialog.findViewById(R.id.blue_circle);
        assert blue_circle != null;
        blue_circle.setOnClickListener(view -> {
            ColorName = "#3D1EF9";
            bottomSheetDialog.dismiss();
        });
        //Yellow circle
        View yellow_circle = bottomSheetDialog.findViewById(R.id.yellow_circle);
        assert yellow_circle != null;
        yellow_circle.setOnClickListener(view -> {
            ColorName = "#F9DC1E";
            bottomSheetDialog.dismiss();
        });
        //Sea Blue circle
        View sea_circle = bottomSheetDialog.findViewById(R.id.sea_blue_circle);
        assert sea_circle != null;
        sea_circle.setOnClickListener(view -> {
            ColorName = "#6DA8FF";
            bottomSheetDialog.dismiss();
        });

        //Purple circle
        View purple_circle = bottomSheetDialog.findViewById(R.id.purple_circle);
        assert purple_circle != null;
        purple_circle.setOnClickListener(view -> {
            ColorName = "#A800F7";
            bottomSheetDialog.dismiss();
        });

        //When click color picker icon
        assert colorPicker != null;
        colorPicker.setOnClickListener(view -> pickColor(bottomSheetDialog));
        bottomSheetDialog.show();
    }


    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    private void TagDialogBox() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.note_tag);
        Button savedTag = bottomSheetDialog.findViewById(R.id.addTagButton);
        assert savedTag != null;
        savedTag.setOnClickListener(view -> {
            TextView tag_text = bottomSheetDialog.findViewById(R.id.NoteTagId);
            assert tag_text != null;
            tag = tag_text.getText().toString();
//            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            bottomSheetDialog.dismiss();
        });
        TextView allTag = bottomSheetDialog.findViewById(R.id.all_tag_add);
        TextView homeTag = bottomSheetDialog.findViewById(R.id.home_tag_add);
        TextView workTag = bottomSheetDialog.findViewById(R.id.work_tag_add);
        TextView personalTag = bottomSheetDialog.findViewById(R.id.personal_tag_add);


        @SuppressLint("CutPasteId") TextView noteTagView = bottomSheetDialog.findViewById(R.id.NoteTagId);
        assert allTag != null;
        //When click all btn
        allTag.setOnClickListener(view -> {
            assert noteTagView != null;
            noteTagView.setText("All");
            allTag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            assert homeTag != null;
            homeTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert workTag != null;
            workTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personalTag != null;
            personalTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        });
        //When click home btn
        assert homeTag != null;
        homeTag.setOnClickListener(view -> {
            assert noteTagView != null;
            noteTagView.setText("Home");
            homeTag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            allTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert workTag != null;
            workTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personalTag != null;
            personalTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        });
        //When click work btn
        assert workTag != null;
        workTag.setOnClickListener(view -> {
            assert noteTagView != null;
            noteTagView.setText("Work");
            workTag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            homeTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            allTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            assert personalTag != null;
            personalTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        });
        //When click personal btn
        assert personalTag != null;
        personalTag.setOnClickListener(view -> {
            assert noteTagView != null;
            noteTagView.setText("Personal");
            personalTag.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            workTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            homeTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            allTag.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
        });

        bottomSheetDialog.show();
    }

    private void pickColor(BottomSheetDialog bottomSheetDialog) {

        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, R.color.red,false, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                ColorName = "#"+Integer.toHexString(color);
                bottomSheetDialog.dismiss();
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }


        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (tag == null) {
            tag = "";
        }
        if (ColorName == null) {
            ColorName = "#FFFFFF";
        }
        if (!note_data.isEmpty() || !binding.NoteTitleId.getText().toString().isEmpty()) {
            insertData = new InsertData(getApplicationContext(), binding.NoteTitleId.getText().toString(), note_data, tag, binding, ColorName);
            note_data = "";
        }
        super.onBackPressed();

    }
}
