package com.thinknxtmedia.mynotes.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        holder.unPinBtn.setOnLongClickListener(view -> {
            showUnpinSheet(holder,position);
            return false;
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    private void showUnpinSheet(MyViewHolder holder, int position) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(R.layout.single_unpin_layout);
        LinearLayout unPinBtn = bottomSheetDialog.findViewById(R.id.unPinNoteId);
        assert unPinBtn != null;
        unPinBtn.setOnClickListener(view -> {
            NoteDataBase db = Room.databaseBuilder(context,NoteDataBase.class,"NoteDataBase").allowMainThreadQueries().build();
            NoteDao dao = db.noteDao();
            dao.unpinNote(noteEntities.get(position).getId());
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
        TextView note_title;
        CardView unPinBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            note_title = itemView.findViewById(com.thinknxtmedia.mynotes.R.id.s_note_title_pin);
            unPinBtn = itemView.findViewById(R.id.pinCardBtnId);
        }
    }
}
