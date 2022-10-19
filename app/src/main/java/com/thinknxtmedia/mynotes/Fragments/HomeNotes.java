package com.thinknxtmedia.mynotes.Fragments;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.FetchData.NoteAdapter;
import com.thinknxtmedia.mynotes.R;
import com.thinknxtmedia.mynotes.note_makng_page;

import java.util.List;
import java.util.Objects;


public class HomeNotes extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recView,tagRecyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    NoteDao noteDao;
    String title;
    String text;
    private String clicked;


    public HomeNotes(String title, String text) {
        this.title = title;
        this.text = text;
    }

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
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_notes, container, false);
        CardView addBtn = v.findViewById(R.id.makeNoteBtnHome);

        //Calling InsertData
        NoteDataBase dataBase = Room.databaseBuilder(requireContext(), NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        noteDao = dataBase.noteDao();

        //Finding through id
        recView = v.findViewById(R.id.recViewHomeId);
        recView.setLayoutManager(new GridLayoutManager(requireActivity().getApplicationContext(), 2));
            //Tag adapter
        tagRecyclerView = v.findViewById(R.id.tag_list_id);
//        tagRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        //setting swipe refresh layout
        swipeRefreshLayout = v.findViewById(R.id.swipeRefreshId);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            swipDone();
        });




        List<NoteEntity> noteEntities = noteDao.getAll();
        NoteAdapter adapter = new NoteAdapter(noteEntities, getContext());
//        TagAdapter adapter1 = new TagAdapter(noteEntities,getContext());
        recView.setAdapter(adapter);
//        tagRecyclerView.setAdapter(adapter1);



        //Setting Action when clicking on add notes button
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), note_makng_page.class);
            startActivity(intent);
        });
        workingTag(v);

        return v;

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void workingTag(View v) {
        TextView all = v.findViewById(R.id.all_tag);
        TextView home = v.findViewById(R.id.home_tag);
        TextView work = v.findViewById(R.id.work_tag);
        TextView Personal = v.findViewById(R.id.personal_tag);
        ImageView tagBtn = v.findViewById(R.id.tag_btn);

        
        all.setOnClickListener(view -> {
            clicked = "all";
            all.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            home.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            work.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            Personal.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            onResume();
        });
        home.setOnClickListener(view -> {
            clicked ="home";
            home.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            all.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            work.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            Personal.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            onResume();
        });
        work.setOnClickListener(view -> {
            clicked ="work";
            work.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            home.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            all.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            Personal.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            onResume();
        });
        Personal.setOnClickListener(view -> {
            clicked="Personal";
            Personal.setBackground(getResources().getDrawable(R.drawable.tag_shape));
            work.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            home.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            all.setBackground(getResources().getDrawable(R.drawable.tag_shape_));
            onResume();
        });
        //When tag button clicked 
        
       tagBtn.setOnClickListener(view -> Toast.makeText(getActivity(), "Coming Soon...", Toast.LENGTH_SHORT).show());

    }

    private void swipDone() {
        NoteAdapter adapter;
        List<NoteEntity> noteEntities;
        if (Objects.equals(clicked, "all")){
           noteEntities = noteDao.getAll();
        }else if (Objects.equals(clicked, "home")){
            noteEntities = noteDao.getTag(clicked);

        }else if (Objects.equals(clicked, "work")){
            noteEntities = noteDao.getTag(clicked);

        }else if (Objects.equals(clicked, "Personal")){
            noteEntities = noteDao.getTag(clicked);

        }else{
            noteEntities = noteDao.getAll();

        }

//        TagAdapter adapter1 = new TagAdapter(noteEntities,getContext());
//        tagRecyclerView.setAdapter(adapter1);
        adapter = new NoteAdapter(noteEntities, getContext());
        recView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
       swipDone();
        super.onResume();
    }
    
    
}
