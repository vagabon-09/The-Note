package com.thinknxtmedia.mynotes.Navigation;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.thinknxtmedia.mynotes.Fragments.HomeEmpty;
import com.thinknxtmedia.mynotes.Fragments.HomeNotes;
import com.thinknxtmedia.mynotes.Fragments.Trash;
import com.thinknxtmedia.mynotes.R;

public class ToggleDrawer {
Toolbar tBar = new Toolbar();
    public void setClickFragment(FragmentManager fm, NavigationView homeNavigationId, int MainContainer, DrawerLayout DrawerId){
        homeNavigationId.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.drawer_menu_home_id) {
                tBar.setItemClickable(R.id.main_container_id, new HomeNotes(), fm);
            } else if (id == R.id.drawer_menu_trash_id) {
                tBar.setItemClickable(R.id.main_container_id, new Trash(), fm);
            }
            DrawerId.closeDrawer(GravityCompat.START);

            return true;
        });
    }

}
