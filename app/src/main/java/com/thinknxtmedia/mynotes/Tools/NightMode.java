package com.thinknxtmedia.mynotes.Tools;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class NightMode {
   @SuppressLint("NotConstructor")
   public void isDarkModeOn(Context context){
       //Checking dark mode is on or not
       SharedPreferences sharedPreferences =context.getSharedPreferences("sharedPrefs", MODE_PRIVATE);
       @SuppressLint("CommitPrefEdits") final SharedPreferences.Editor editor = sharedPreferences.edit();
       final boolean isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false);
       if (isDarkModeOn) {
           AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
       } else {
           AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
       }

   }

   public SharedPreferences isNight(Context context){
       SharedPreferences sharedPreferences = context.getSharedPreferences("darkMode",MODE_PRIVATE);
       final SharedPreferences.Editor editor = sharedPreferences.edit();
       return  sharedPreferences;
   }
}
