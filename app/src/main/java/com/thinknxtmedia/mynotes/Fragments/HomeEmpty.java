package com.thinknxtmedia.mynotes.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.thinknxtmedia.mynotes.R;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;
import com.thinknxtmedia.mynotes.note_makng_page;

public class HomeEmpty extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static CardView cardBtn;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeEmpty() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeEmpty newInstance(String param1, String param2) {
        HomeEmpty fragment = new HomeEmpty();
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
        ReplaceFreagment replaceFreagment = new ReplaceFreagment();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_empty, container, false);
        cardBtn = v.findViewById(R.id.addNote_Btn);
        cardBtn.setOnClickListener(view -> {
          Intent intent = new Intent(getContext(), note_makng_page.class);
          startActivity(intent);
        });
        return v;
    }
}