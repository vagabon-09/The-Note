package com.thinknxtmedia.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.thinknxtmedia.mynotes.Tools.NightMode;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
private final static int SPLASH_TIME= 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Removing top bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Checking dark mode is on or not
        NightMode nightMode = new NightMode();
        boolean isDarkModeOn = nightMode.isDarkModeOn(getApplicationContext());
        if (isDarkModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        //Redirection to home page
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
            finish();
        },SPLASH_TIME);
    }
}