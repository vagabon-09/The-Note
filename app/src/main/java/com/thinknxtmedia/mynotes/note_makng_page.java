package com.thinknxtmedia.mynotes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.thinknxtmedia.mynotes.DialogBox.ShowDialogBox;
import com.thinknxtmedia.mynotes.Tools.InsertData;
import com.thinknxtmedia.mynotes.databinding.ActivityNoteMakngPageBinding;
public class note_makng_page extends AppCompatActivity {
    ActivityNoteMakngPageBinding binding;
    ShowDialogBox dialogBox;
    InsertData insertData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteMakngPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Removing task bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Creating objects for use
        dialogBox = new ShowDialogBox();
        //Setting bottom
        ButtonFunction();
        //Note Function
        checkNoteEmptyorNot();
        //Sending data to the databse
        sendDataToDataBase();
    }

    private void sendDataToDataBase() {

        binding.noteSaveBtnId.setOnClickListener(view -> {
            String tag;
            @SuppressLint("InflateParams") View buttonSheet = getLayoutInflater().inflate(R.layout.note_tag,null);
            EditText tag_text = buttonSheet.findViewById(R.id.NoteTagId);
            if(tag_text.getText().toString().equals("")){
                tag = "All";
            }else{
               tag = tag_text.getText().toString();
            }
            insertData = new InsertData(getApplicationContext(),binding.NoteTitleId.getText().toString(),binding.NoteNotesId.getText().toString(),tag);
            binding.NoteTitleId.setText("");
            binding.NoteNotesId.setText("");
        });

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

       binding.NoteNotesId.addTextChangedListener(new TextWatcher() {
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
        //When user clicked text format button
        binding.TextFormatId.setOnClickListener(view -> textFormatDialog());

    }

    private void textFormatDialog() {
        dialogBox.show(this,R.layout.s_format_text_layout);
    }

    private void fontFamilyDialog() {
        dialogBox.show(this,R.layout.font_family_panel);
    }

    private void TagDialogBox() {
        dialogBox.show(this,R.layout.note_tag);
    }

    private void bottomSheet() {
        dialogBox.show(this,R.layout.bottom_sheet);
    }


}