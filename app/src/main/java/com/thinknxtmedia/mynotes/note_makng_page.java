package com.thinknxtmedia.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.thinknxtmedia.mynotes.databinding.ActivityNoteMakngPageBinding;

public class note_makng_page extends AppCompatActivity {
    ActivityNoteMakngPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteMakngPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Removing task bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       binding.backBtnId.setOnClickListener(view -> {
           onBackPressed();
       });

    }
}