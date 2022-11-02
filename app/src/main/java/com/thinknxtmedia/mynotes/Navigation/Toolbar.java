package com.thinknxtmedia.mynotes.Navigation;

import android.app.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.thinknxtmedia.mynotes.R;

public class Toolbar {
    public void ActionToolBar(Activity activity, DrawerLayout drawerLayout, androidx.appcompat.widget.Toolbar toolbar) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }


}


