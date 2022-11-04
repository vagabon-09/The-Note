package com.thinknxtmedia.mynotes.Tools;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class NightMode {
   @SuppressLint("NotConstructor")
   public boolean isDarkModeOn(Context context){
       SharedPreferences sharedPreferences = context.getSharedPreferences("darkMode",MODE_PRIVATE);
       @SuppressLint("CommitPrefEdits") final SharedPreferences.Editor editor = sharedPreferences.edit();
       return sharedPreferences.getBoolean("isDarkModeOn",false);
   }

   public SharedPreferences isNight(Context context){
       SharedPreferences sharedPreferences = context.getSharedPreferences("darkMode",MODE_PRIVATE);
       final SharedPreferences.Editor editor = sharedPreferences.edit();
       return  sharedPreferences;
   }
}
