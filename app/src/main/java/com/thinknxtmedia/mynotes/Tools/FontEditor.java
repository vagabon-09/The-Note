package com.thinknxtmedia.mynotes.Tools;


import com.thinknxtmedia.mynotes.databinding.ActivityNoteMakngPageBinding;

public class FontEditor {
    public FontEditor(ActivityNoteMakngPageBinding binding) {
        //Italic style
        binding.ItalicTextId.setOnClickListener(view -> binding.NoteNotesId.setItalic());
        //Bold style
        binding.boldTextId.setOnClickListener(view -> binding.NoteNotesId.setBold());
    }
}
