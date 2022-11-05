package com.thinknxtmedia.mynotes.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinknxtmedia.mynotes.DataBase.NoteEntity;

import java.util.List;

public class pinNoteAdapter extends RecyclerView.Adapter<pinNoteAdapter.MyViewHolder> {
    List<NoteEntity> noteEntities;
    Context context;

    public pinNoteAdapter(List<NoteEntity> noteEntities, Context context) {
        this.noteEntities = noteEntities;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(com.thinknxtmedia.mynotes.R.layout.pin_note, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.note_title.setText(noteEntities.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return noteEntities.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView note_title ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            note_title = itemView.findViewById(com.thinknxtmedia.mynotes.R.id.s_note_title_pin);
        }
    }
}
