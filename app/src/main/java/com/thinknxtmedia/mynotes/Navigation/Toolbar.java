package com.thinknxtmedia.mynotes.Navigation;

import android.app.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.thinknxtmedia.mynotes.Fragments.HomeEmpty;
import com.thinknxtmedia.mynotes.R;

public class Toolbar {
    public void ActionToolBar(Activity activity, DrawerLayout drawerLayout, androidx.appcompat.widget.Toolbar toolbar) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    public void setItemClickable(int FragmentId, Fragment fragment, FragmentManager fm) {

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(FragmentId,fragment);
        ft.commit();
    }


}


