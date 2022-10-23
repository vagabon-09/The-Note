package com.thinknxtmedia.mynotes.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.Adapter.starredAdapter;
import com.thinknxtmedia.mynotes.R;

import java.util.List;

public class Starred_activity extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private starredAdapter starredAdapter;

    public Starred_activity() {
        // Required empty public constructor
    }


    public static Starred_activity newInstance(String param1, String param2) {
        Starred_activity fragment = new Starred_activity();
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
        View v = inflater.inflate(R.layout.fragment_starred_activity, container, false);
        recyclerView = v.findViewById(R.id.starred_Id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        NoteDataBase dataBase = Room.databaseBuilder(requireContext(), NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao noteDao = dataBase.noteDao();
        List<NoteEntity> noteEntities = noteDao.getStarred();
        starredAdapter = new starredAdapter(noteEntities,getContext());
        recyclerView.setAdapter(starredAdapter);
        return v;
    }
}