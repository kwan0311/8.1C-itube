package com.example.itube_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Playlistadapter extends RecyclerView.Adapter<Playlistadapter.MyViewHolder>{
    private Context context;
    private ArrayList urlcode;

    public Playlistadapter(Context context, ArrayList urlcode){

        this.context = context;
        this.urlcode = urlcode;


    }

    @NonNull
    @Override
    public Playlistadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.playlist_print, parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Playlistadapter.MyViewHolder holder, int position) {

        holder.urlcode.setText(String.valueOf(urlcode.get(position)));

    }

    @Override
    public int getItemCount() {
        return urlcode.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView urlcode;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            urlcode = itemView.findViewById(R.id.Playlist_item);
        }
    }
}
