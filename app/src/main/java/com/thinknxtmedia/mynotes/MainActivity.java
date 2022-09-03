package com.thinknxtmedia.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.thinknxtmedia.mynotes.databinding.ActivityHomeBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}