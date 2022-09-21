package com.thinknxtmedia.mynotes.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.FetchData.NoteAdapter;
import com.thinknxtmedia.mynotes.R;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;
import com.thinknxtmedia.mynotes.note_makng_page;

import java.util.List;


public class HomeNotes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static CardView addBtn;
    RecyclerView recView;
    NoteAdapter adapter;
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
        //Calling InsertData
        NoteDataBase dataBase = Room.databaseBuilder(getContext(), NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao noteDao = dataBase.noteDao();
        //Finding through id
        recView = v.findViewById(R.id.recViewHomeId);
        recView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));

        List<NoteEntity> noteEntities = noteDao.getAllData();
        NoteAdapter adapter = new NoteAdapter(noteEntities);
        recView.setAdapter(adapter);


        ReplaceFreagment replaceFreagment = new ReplaceFreagment();
        //Setting Action when clicking on add notes button
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), note_makng_page.class);
            startActivity(intent);
        });
        return v;

    }


}
