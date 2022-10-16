package com.thinknxtmedia.mynotes.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.FetchData.NoteAdapter;
import com.thinknxtmedia.mynotes.FetchData.trashAdapter;
import com.thinknxtmedia.mynotes.R;

import java.util.List;


public class Trash extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recTrashView;
    NoteDao noteDao;

    public Trash() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Trash newInstance(String param1, String param2) {
        Trash fragment = new Trash();
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
        View v = inflater.inflate(R.layout.fragment_trash, container, false);
        recTrashView = v.findViewById(R.id.recTrashView);
        recTrashView.setLayoutManager(new LinearLayoutManager(getContext()));
        NoteDataBase dataBase = Room.databaseBuilder(requireContext(), NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        noteDao = dataBase.noteDao();
        List<NoteEntity>noteEntityList = noteDao.getTrash();
        trashAdapter trashAdapter = new trashAdapter(noteEntityList,getContext());
        recTrashView.setAdapter(trashAdapter);
        return v ;
    }

    @Override
    public void onResume() {
        NoteDataBase dataBase = Room.databaseBuilder(requireContext(), NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        noteDao = dataBase.noteDao();
        List<NoteEntity>noteEntityList = noteDao.getTrash();
        trashAdapter trashAdapter = new trashAdapter(noteEntityList,getContext());
        recTrashView.setAdapter(trashAdapter);
        super.onResume();
    }
}