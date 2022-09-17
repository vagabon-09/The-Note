package com.thinknxtmedia.mynotes;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;


import com.thinknxtmedia.mynotes.DialogBox.ShowDialogBox;
import com.thinknxtmedia.mynotes.databinding.ActivityNoteMakngPageBinding;
public class note_makng_page extends AppCompatActivity {
    ActivityNoteMakngPageBinding binding;
    ShowDialogBox dialogBox;
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