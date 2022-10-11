package com.thinknxtmedia.mynotes.FetchData;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_note_home_page, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.MyViewHolder holder, int position) {
        holder.s_title.setText(noteEntities.get(position).getTitle());
//    holder.s_date.setText(noteEntities.get(position).getTime());
        holder.s_title.setOnClickListener(view -> {
//            Update_Note update_note = new Update_Note(noteEntities.get(position).getTitle(),noteEntities.get(position).getNote());
            Intent intent = new Intent(context, Update_Note.class);
            intent.putExtra("title", noteEntities.get(position).getTitle());
            intent.putExtra("note", noteEntities.get(position).getNote());
            context.startActivity(intent);
        });
        holder.s_title.setOnLongClickListener(view -> {
            holder.delete.setAlpha(1f);
            holder.s_title.setAlpha(0.3f);
            holder.s_title.setClickable(false);
            holder.s_title.setEnabled(false);
            holder.NoteBtn.setClickable(false);
            holder.delete.setVisibility(View.VISIBLE);
            return false;
        });
        holder.cardView.setOnLongClickListener(view -> {
            holder.delete.setAlpha(1f);
            holder.s_title.setAlpha(0.3f);
            holder.s_title.setClickable(false);
            holder.s_title.setEnabled(false);
            holder.NoteBtn.setClickable(false);
            holder.delete.setVisibility(View.VISIBLE);
            return false;
        });
        holder.deleteBtn.setOnClickListener(view ->
                Toast.makeText(context, "This item is deleted", Toast.LENGTH_SHORT).show()
        );

    }

    @Override
    public int getItemCount() {
        return noteEntities.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView s_title;
        RelativeLayout delete, cardView;
        ImageView deleteBtn;
        LinearLayout NoteBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            s_title = itemView.findViewById(R.id.s_note_title);
            delete = itemView.findViewById(R.id.s_deleteBtn);
            cardView = itemView.findViewById(R.id.NoteBtnId);
            deleteBtn = itemView.findViewById(R.id.s_delete);
            NoteBtn = itemView.findViewById(R.id.NoteBtn);
        }
    }
}
