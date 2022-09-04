package com.thinknxtmedia.mynotes.ReplaceFreagment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ReplaceFreagment {
    public void setItemClickable(int FragmentId, Fragment fragment, FragmentManager fm) {

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(FragmentId,fragment);
        ft.commit();
    }

    //Overriding SetItemClickable Method
    public void setItemClickable(int FragmentId, Fragment fragment, FragmentManager fm,String tag) {

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(FragmentId,fragment).addToBackStack(tag);
        ft.commit();
    }
}
