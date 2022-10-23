package com.thinknxtmedia.mynotes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinknxtmedia.mynotes.DataBase.NoteEntity;
import com.thinknxtmedia.mynotes.R;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyViewHolder> {
    List<NoteEntity> tagList;
    Context context;

    public TagAdapter(List<NoteEntity> tagList, Context context) {
        this.tagList = tagList;
        this.context = context;
    }

    @NonNull
    @Override
    public TagAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_tag,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TagAdapter.MyViewHolder holder, int position) {
        holder.h_tag.setText(tagList.get(position).getTag());
        holder.h_tag.setOnClickListener(view -> Toast.makeText(context, tagList.get(position).getTag(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView h_tag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            h_tag = itemView.findViewById(R.id.tagId);
        }

    }
}
