package com.thinknxtmedia.mynotes;


import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;

import com.thinknxtmedia.mynotes.Fragments.HomeEmpty;
import com.thinknxtmedia.mynotes.Navigation.ToggleDrawer;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;
import com.thinknxtmedia.mynotes.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {
    ActivityHomeBinding bind;
    Toolbar toolbar;
    ReplaceFreagment replaceFreagment;
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
        replaceFreagment = new ReplaceFreagment();
        toggleDrawer = new ToggleDrawer();

        /* Finding view */
        getView();
        /* Replacing FrameLayout with fragment */
        replaceFragment();
        /* Supporting toolbar*/
        setToolbar();

    }

    private void replaceFragment() {

        FragmentManager fm = getSupportFragmentManager();
        replaceFreagment.setItemClickable(R.id.main_container_id, new HomeEmpty(), fm);

    }

    private void setToolbar() {
        /* Crating toggle drawer using custom toolbar */
        setSupportActionBar(toolbar);
        toolbar.post(() -> toolbar.setNavigationIcon(R.drawable.hamburger_32));
        tBar.ActionToolBar(this, bind.drawerId, toolbar);
        /* Replacing Fragment on clicking drawer button */
        FragmentManager fm = getSupportFragmentManager();
        toggleDrawer.setClickFragment(fm, bind.homeNavigationId, bind.drawerId);
    }

    @Override
    public void onBackPressed() {
        if (bind.drawerId.isDrawerOpen(GravityCompat.START)) {
            bind.drawerId.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    private void getView() {

        toolbar = findViewById(R.id.toolbar);

    }
}