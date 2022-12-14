package com.thinknxtmedia.mynotes.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.thinknxtmedia.mynotes.DataBase.NoteDao;
import com.thinknxtmedia.mynotes.DataBase.NoteDataBase;
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

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.MyViewHolder holder, int position) {
        holder.s_title.setText(noteEntities.get(position).getTitle());
        holder.cardView.setBackgroundColor(Color.parseColor(noteEntities.get(position).getColor()));

//    holder.s_date.setText(noteEntities.get(position).getTime());
        holder.cardView.setOnClickListener(view -> {
//            Update_Note update_note = new Update_Note(noteEntities.get(position).getTitle(),noteEntities.get(position).getNote());
            Intent intent = new Intent(context, Update_Note.class);
            intent.putExtra("title", noteEntities.get(position).getTitle());
            intent.putExtra("note", noteEntities.get(position).getNote());
            intent.putExtra("color", noteEntities.get(position).getColor());
            intent.putExtra("note_id", noteEntities.get(position).getId());
            intent.putExtra("note_tag", noteEntities.get(position).getTag());
            context.startActivity(intent);
        });
        holder.s_title.setOnClickListener(view -> {
//            Update_Note update_note = new Update_Note(noteEntities.get(position).getTitle(),noteEntities.get(position).getNote());
            Intent intent = new Intent(context, Update_Note.class);
            intent.putExtra("title", noteEntities.get(position).getTitle());
            intent.putExtra("note", noteEntities.get(position).getNote());
            intent.putExtra("color", noteEntities.get(position).getColor());
            intent.putExtra("note_id", noteEntities.get(position).getId());
            intent.putExtra("note_tag", noteEntities.get(position).getTag());
            context.startActivity(intent);
        });
        holder.s_title.setOnLongClickListener(view -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
            bottomSheetDialog.setContentView(R.layout.buttom_operation);
            LinearLayout delete = bottomSheetDialog.findViewById(R.id.btm_deleteBtn_id);
            LinearLayout favourite = bottomSheetDialog.findViewById(R.id.FavouriteBtn);
            LinearLayout pinBtn = bottomSheetDialog.findViewById(R.id.pinNoteId);
            assert delete != null;
            delete.setOnClickListener(view1 -> {
                deleteF(position);
                bottomSheetDialog.dismiss();
            });
            assert favourite != null;
            favourite.setOnClickListener(view1 -> {
                favouriteOperation(position);
                bottomSheetDialog.dismiss();
            });

            assert pinBtn != null;
            pinBtn.setOnClickListener(view1 -> {
                pinOperation(position);
                notifyDataSetChanged();
                bottomSheetDialog.dismiss();
            });

            bottomSheetDialog.show();
            return false;

        });

        holder.cardView.setOnLongClickListener(view -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
            bottomSheetDialog.setContentView(R.layout.buttom_operation);
            LinearLayout delete = bottomSheetDialog.findViewById(R.id.btm_deleteBtn_id);
            LinearLayout favourite = bottomSheetDialog.findViewById(R.id.FavouriteBtn);
            LinearLayout pinBtn = bottomSheetDialog.findViewById(R.id.pinNoteId);
            assert delete != null;
            delete.setOnClickListener(view1 -> {
                deleteF(position);
                bottomSheetDialog.dismiss();
            });
            assert favourite != null;
            favourite.setOnClickListener(view1 -> {
                favouriteOperation(position);
                bottomSheetDialog.dismiss();
            });

            assert pinBtn != null;
            pinBtn.setOnClickListener(view1 -> {
                pinOperation(position);
                bottomSheetDialog.dismiss();
            });

            bottomSheetDialog.show();
            return false;
        });


    }

    private void pinOperation(int position) {
        NoteDataBase db = Room.databaseBuilder(context, NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao dao = db.noteDao();
        dao.pinNote(noteEntities.get(position).getId());
    }

    private void favouriteOperation(int position) {
        NoteDataBase db = Room.databaseBuilder(context, NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao dao = db.noteDao();
        dao.updateStarredOne(noteEntities.get(position).getId());
    }

    @SuppressLint("NotifyDataSetChanged")
    private void deleteF(int position) {
        NoteDataBase db = Room.databaseBuilder(context, NoteDataBase.class, "NoteDataBase").allowMainThreadQueries().build();
        NoteDao dao = db.noteDao();
//        dao.DeleteNote(noteEntities.get(position).getId());
        dao.editTrash(noteEntities.get(position).setTrash("trash"), noteEntities.get(position).getId());
        noteEntities.remove(position);
        notifyDataSetChanged();
        Toast.makeText(context, "Successfully Note Deleted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return noteEntities.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView colorCard;
        TextView s_title;
        RelativeLayout delete, cardView;
        ImageView deleteBtn;
        LinearLayout NoteBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            s_title = itemView.findViewById(R.id.s_note_title_pin);
//            delete = itemView.findViewById(R.id.s_deleteBtn);
            cardView = itemView.findViewById(R.id.NoteBtnId);
//            deleteBtn = itemView.findViewById(R.id.s_delete);
            NoteBtn = itemView.findViewById(R.id.NoteBtn);
            colorCard = itemView.findViewById(R.id.cardViewBtn);
        }
    }
}
