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
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.thinknxtmedia.mynotes.DialogBox.ShowDialogBox;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;
import com.thinknxtmedia.mynotes.Tools.FontEditor;
import com.thinknxtmedia.mynotes.Tools.InsertData;
import com.thinknxtmedia.mynotes.databinding.ActivityNoteMakngPageBinding;

public class note_makng_page extends AppCompatActivity {
    static String note_data = "";
    ActivityNoteMakngPageBinding binding;
    ShowDialogBox dialogBox;
    InsertData insertData;
    String tag;
    Button tagSave;
    EditText EditTag;
    ReplaceFreagment replaceFreagment;
    FontEditor fontEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteMakngPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Removing task bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Fragment class object creating here
        replaceFreagment = new ReplaceFreagment();
        //Creating objects for use
        dialogBox = new ShowDialogBox();
        //Setting bottom
        ButtonFunction();
        //Note Function
        checkNoteEmptyorNot();
        //Sending data to the databse
        sendDataToDataBase();
        //Giving font style
        fontEditor = new FontEditor(binding);
        //Sending data in note making page


    }

    @SuppressLint("CutPasteId")
    private void sendDataToDataBase() {
        @SuppressLint("InflateParams") final View view1 = getLayoutInflater().inflate(R.layout.note_tag, null);
        tagSave = view1.findViewById(R.id.addTagButton);
        EditTag = view1.findViewById(R.id.NoteTagId);
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
        binding.colorPanelId.setOnClickListener(view -> bottomSheet());
        //When user clicked add Tag button
        binding.noteTagId.setOnClickListener(view -> TagDialogBox());
        //When user clicked on font style button
        binding.fontStyleId.setOnClickListener(view -> fontFamilyDialog());


    }

    private void fontFamilyDialog() {
        dialogBox.show(this, R.layout.font_family_panel);
    }

    private void TagDialogBox() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.note_tag);
        Button tag = bottomSheetDialog.findViewById(R.id.addTagButton);
        assert tag != null;
        tag.setOnClickListener(view -> {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.show();

    }

    private void bottomSheet() {
        dialogBox.show(this, R.layout.color_plate);
    }
    


    @Override
    public void onBackPressed() {
        if (!note_data.isEmpty() || !binding.NoteTitleId.getText().toString().isEmpty()) {
            insertData = new InsertData(getApplicationContext(), binding.NoteTitleId.getText().toString(), note_data, tag, binding);
            note_data = "";
        }

        super.onBackPressed();

    }
}
