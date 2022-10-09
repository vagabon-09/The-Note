package com.thinknxtmedia.mynotes.Tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.thinknxtmedia.mynotes.R;
import com.thinknxtmedia.mynotes.databinding.ActivityNoteMakngPageBinding;

public class FontEditor {
    public FontEditor(ActivityNoteMakngPageBinding binding) {

        //Italic style
      binding.ItalicTextId.setOnClickListener(view -> binding.NoteNotesId.setItalic());
        //Bold style
        binding.boldTextId.setOnClickListener(view -> binding.NoteNotesId.setBold());
        //Align center
        binding.alignCenterId.setOnClickListener(view -> binding.NoteNotesId.setAlignCenter());
        //Align left
        binding.alignLeftId.setOnClickListener(view -> binding.NoteNotesId.setAlignLeft());
        //Align Right
        binding.alignRightId.setOnClickListener(view -> binding.NoteNotesId.setAlignRight());
        //H2 Text
        binding.h2Id.setOnClickListener(view -> binding.NoteNotesId.setHeading(2));
        //H text
        binding.hId.setOnClickListener(view -> binding.NoteNotesId.setHeading(1));
        //H3 text
        binding.h3Id.setOnClickListener(view -> binding.NoteNotesId.setHeading(3));
        //Setting color panel color

    }
}
