package com.thinknxtmedia.mynotes.Tools;


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
    }
}
