package com.thinknxtmedia.mynotes.FetchData;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class trashAdapter extends RecyclerView.Adapter<trashAdapter.MyViewHolder> {
    List<NoteEntity> noteEntities;
    Context context;

    public trashAdapter(List<NoteEntity> noteEntities, Context context) {
        this.noteEntities = noteEntities;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_trash_view, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.trash_title.setText(noteEntities.get(position).getTitle());
        holder.trash_layout.setOnLongClickListener(view -> {
            deleteTrash(position);
            return false;
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    private void deleteTrash(int position) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(R.layout.trash_recover);
        Button delete_trash = bottomSheetDialog.findViewById(R.id.trashDelete);
        Button recover_trash = bottomSheetDialog.findViewById(R.id.trashRecoverBtnId);
        assert delete_trash != null;
        delete_trash.setOnClickListener(v -> {
            NoteDataBase db = Room.databaseBuilder(context, NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
            NoteDao dao = db.noteDao();
            dao.DeleteNote(noteEntities.get(position).getId());
            noteEntities.remove(position);
            notifyDataSetChanged();
            bottomSheetDialog.dismiss();
        });

        assert recover_trash != null;
        recover_trash.setOnClickListener(view -> {
            NoteDataBase db = Room.databaseBuilder(context, NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
            NoteDao dao = db.noteDao();
            dao.editTrash(noteEntities.get(position).setTrash("all"));
            noteEntities.remove(position);
            notifyDataSetChanged();
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.show();
    }

    @Override
    public int getItemCount() {
        return noteEntities.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView trash_title;
        CardView trash_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            trash_title = itemView.findViewById(R.id.trash_title_id);
            trash_layout = itemView.findViewById(R.id.trash_layout_id);
        }
    }
}
