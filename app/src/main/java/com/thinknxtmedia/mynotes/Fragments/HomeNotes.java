package com.thinknxtmedia.mynotes.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.thinknxtmedia.mynotes.R;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;


public class HomeNotes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static CardView addBtn;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeNotes() {
        // Required empty public constructor
    }

    public static HomeNotes newInstance(String param1, String param2) {
        HomeNotes fragment = new HomeNotes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_notes, container, false);
        addBtn = v.findViewById(R.id.makeNoteBtnHome);
        ReplaceFreagment replaceFreagment = new ReplaceFreagment();
        //Setting Action when clicking on add notes button
        addBtn.setOnClickListener(view -> {
            FragmentManager fm = getParentFragmentManager();
            replaceFreagment.setItemClickable(R.id.main_container_id, new MakeNote(), fm,"yes");
        });
        return v;

    }


}
