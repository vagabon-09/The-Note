package com.thinknxtmedia.mynotes;


import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
import com.thinknxtmedia.mynotes.Fragments.HomeEmpty;
import com.thinknxtmedia.mynotes.Fragments.HomeNotes;
import com.thinknxtmedia.mynotes.Navigation.ToggleDrawer;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;
import com.thinknxtmedia.mynotes.Tools.NightMode;
import com.thinknxtmedia.mynotes.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {
    ActivityHomeBinding bind;
    Toolbar toolbar;
    com.thinknxtmedia.mynotes.Navigation.Toolbar tBar;
    ToggleDrawer toggleDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Creating object of toolbar
        tBar = new com.thinknxtmedia.mynotes.Navigation.Toolbar();
        toggleDrawer = new ToggleDrawer();
        /* Finding view */
        getView();
        /* Replacing FrameLayout with fragment */
        replaceFragment();
        /* Supporting toolbar*/
        setToolbar();
        /*Check night mode on or not*/
        checkNightMode();
        //Activating night mode
        NightMode nightMode = new NightMode();
        nightMode.isDarkModeOn(getApplicationContext());
    }

    private void checkNightMode() {

    }

    private void replaceFragment() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        NoteDataBase dataBase = Room.databaseBuilder(getApplicationContext(), NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao noteDao = dataBase.noteDao();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (noteDao.getRow()) {
            ReplaceFreagment replaceFreagment = new ReplaceFreagment();
            replaceFreagment.setItemClickable(R.id.main_container_id, new HomeNotes(), fragmentManager);
        } else {
            ft.replace(R.id.main_container_id, new HomeEmpty());
            ft.commit();
        }


    }

    private void setToolbar() {
        /* Crating toggle drawer using custom toolbar */
        setSupportActionBar(toolbar);
        toolbar.post(() -> toolbar.setNavigationIcon(R.drawable.hamburger_s));
        tBar.ActionToolBar(this, bind.drawerId, toolbar);
        /* Replacing Fragment on clicking drawer button */
        FragmentManager fm = getSupportFragmentManager();
        toggleDrawer.setClickFragment(fm, bind.homeNavigationId, bind.drawerId);
    }

    @Override
    public void onBackPressed() {
        replaceFragment();
        if (bind.drawerId.isDrawerOpen(GravityCompat.START)) {
            bind.drawerId.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    private void getView() {

        toolbar = findViewById(R.id.toolbar);

    }

    @Override
    protected void onResume() {
        checkNightMode();
        super.onResume();
    }


}