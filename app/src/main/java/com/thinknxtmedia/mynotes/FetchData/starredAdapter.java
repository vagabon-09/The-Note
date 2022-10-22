package com.thinknxtmedia.mynotes.FetchData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.R;

import java.util.List;

public class starredAdapter extends RecyclerView.Adapter<starredAdapter.MyViewHolder> {
    List<NoteEntity> noteEntities;
    Context context;

    public starredAdapter(List<NoteEntity> noteEntities, Context context) {
        this.noteEntities = noteEntities;
        this.context = context;
    }

    @NonNull
    @Override
    public starredAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.s_starred,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull starredAdapter.MyViewHolder holder, int position) {
        holder.s_title.setText(noteEntities.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return noteEntities.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView s_title,s_date;
        ImageView s_color_star, s_non_color_star;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            s_title = itemView.findViewById(R.id.s_starred_title);
            s_date = itemView.findViewById(R.id.s_starred_date_id);
            s_color_star = itemView.findViewById(R.id.star_color_id);
            s_non_color_star = itemView.findViewById(R.id.star_non_color_id);
        }
    }
}
