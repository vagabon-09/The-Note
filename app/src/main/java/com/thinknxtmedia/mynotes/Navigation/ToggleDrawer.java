package com.thinknxtmedia.mynotes.Navigation;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.thinknxtmedia.mynotes.Fragments.HomeNotes;
import com.thinknxtmedia.mynotes.Fragments.Trash;
import com.thinknxtmedia.mynotes.R;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;

public class ToggleDrawer {
    ReplaceFreagment replaceFreagment = new ReplaceFreagment();
    public void setClickFragment(FragmentManager fm, NavigationView homeNavigationId, DrawerLayout DrawerId){
        homeNavigationId.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.drawer_menu_home_id) {
                replaceFreagment.setItemClickable(R.id.main_container_id, new HomeNotes(), fm, "yes");
            } else if (id == R.id.drawer_menu_trash_id) {
                replaceFreagment.setItemClickable(R.id.main_container_id, new Trash(), fm, "yes");
            }
            DrawerId.closeDrawer(GravityCompat.START);

            return true;
        });
    }


}
