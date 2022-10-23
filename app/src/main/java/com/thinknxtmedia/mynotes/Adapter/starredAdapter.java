package com.thinknxtmedia.mynotes.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
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
        View v = LayoutInflater.from(context).inflate(R.layout.single_starred,parent,false);
        return new MyViewHolder(v);

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull starredAdapter.MyViewHolder holder, int position) {
        holder.s_title.setText(noteEntities.get(position).getTitle());
        holder.s_starredUpdate.setOnLongClickListener(view -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(view.getContext());
            bottomSheetDialog.setContentView(R.layout.favourite_sheet);
            LinearLayout uNfavourite = bottomSheetDialog.findViewById(R.id.starred_unFavourite_id);
            assert uNfavourite != null;
            uNfavourite.setOnClickListener(view1 -> {
                NoteDataBase noteDataBase = Room.databaseBuilder(context,NoteDataBase.class,"NoteDataBase").allowMainThreadQueries().build();
                NoteDao noteDao = noteDataBase.noteDao();
                noteDao.updateStarred(noteEntities.get(position).getId());
                noteEntities.remove(position);
                notifyDataSetChanged();
                bottomSheetDialog.dismiss();
            });
            bottomSheetDialog.show();
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return noteEntities.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView s_title,s_date;
        ImageView s_color_star, s_non_color_star;
        CardView s_starredUpdate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            s_title = itemView.findViewById(R.id.s_starred_title_id);
            s_date = itemView.findViewById(R.id.s_starred_date_id);
            s_color_star = itemView.findViewById(R.id.star_color_id);
            s_non_color_star = itemView.findViewById(R.id.star_non_color_id);
            s_starredUpdate = itemView.findViewById(R.id.starred_favourite_id);
        }
    }
}
