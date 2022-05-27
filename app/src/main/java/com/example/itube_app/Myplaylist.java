package com.example.itube_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Myplaylist extends AppCompatActivity {
    RecyclerView Playlistview;
    String name;
    ArrayList<String> urlcode= new ArrayList<>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplaylist);
        Playlistview = findViewById(R.id.Myplaylist_recycler);



        Intent a = getIntent();
        name = a.getStringExtra("name");

        playlistHelper database = new playlistHelper(Myplaylist.this);
        Cursor cursor = database.finddata(name);
        if(cursor.getCount() == 0){
            Toast.makeText(Myplaylist.this, "No Data exists", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                urlcode.add(cursor.getString((2)));
            }
        }
        Playlistadapter playlistadapter = new Playlistadapter(Myplaylist.this, urlcode);
        Playlistview.setAdapter(playlistadapter);
        Playlistview.setLayoutManager(new LinearLayoutManager(Myplaylist.this));
    }
}