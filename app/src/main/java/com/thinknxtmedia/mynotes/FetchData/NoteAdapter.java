package com.thinknxtmedia.mynotes.FetchData;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.Fragments.HomeNotes;
import com.thinknxtmedia.mynotes.MainActivity;
import com.thinknxtmedia.mynotes.R;
import com.thinknxtmedia.mynotes.ReplaceFreagment.ReplaceFreagment;
import com.thinknxtmedia.mynotes.Tools.InsertData;
import com.thinknxtmedia.mynotes.Update_Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {
    List<NoteEntity> noteEntities;
    Context context;

    public NoteAdapter(List<NoteEntity> noteEntities, Context context) {
        this.noteEntities = noteEntities;
        this.context = context;
    }

    @NonNull
    @Override
    public NoteAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_note_home_page,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.MyViewHolder holder, int position) {
    holder.s_title.setText(noteEntities.get(position).getTitle());
//    holder.s_date.setText(noteEntities.get(position).getTime());
        holder.cardView.setOnClickListener(view -> {
//            Update_Note update_note = new Update_Note(noteEntities.get(position).getTitle(),noteEntities.get(position).getNote());
            Intent intent = new Intent(context,Update_Note.class);
            intent.putExtra("title",noteEntities.get(position).getTitle());
            intent.putExtra("note",noteEntities.get(position).getNote());
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return noteEntities.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView s_title;
        ImageView delete;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            s_title = itemView.findViewById(R.id.s_note_title);
            delete = itemView.findViewById(R.id.s_deleteBtn);
            cardView = itemView.findViewById(R.id.cardViewBtn);
            cardView.setOnLongClickListener(view -> {
                delete.setVisibility(View.VISIBLE);

                return false;
            });
        }
    }
}
