package com.thinknxtmedia.mynotes;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.thinknxtmedia.mynotes.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {
    ActivityHomeBinding bind;
    Toolbar toolbar;
    com.thinknxtmedia.mynotes.Navigation.Toolbar tBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Creating object of toolbar
        tBar = new com.thinknxtmedia.mynotes.Navigation.Toolbar();
        //Finding view
        getView();
        //Supporting toolbar
        setSupportActionBar(toolbar);
        tBar.ActionToolBar(this, bind.drawerId, toolbar);

    }

    private void getView() {
        toolbar = findViewById(R.id.toolbar);
    }
}