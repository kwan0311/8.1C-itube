package com.example.itube_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
    Button PlayButton, AddButton, MylistButton;
    EditText urltext;
    public static final String USER_CODE="com.example.itube_app.USER_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        PlayButton = findViewById(R.id.Play_Button);
        AddButton = findViewById(R.id.Add_playlist_Button);
        MylistButton = findViewById(R.id.My_Playlist_Button);
        urltext = findViewById(R.id.urlcode);

        PlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(urltext.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(Homepage.this, "Please enter the URL link ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String urlcode = urltext.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.setClass(Homepage.this, Playpage.class);
                    intent.putExtra("url", urlcode);
                    startActivity(intent);
                }

            }
        });

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name;
                Intent intent =getIntent();
                name = intent.getStringExtra(USER_CODE);

                if(urltext.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(Homepage.this, "Please enter the URL link ", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    playlistHelper db = new playlistHelper(Homepage.this);
                    db.add_Data1(name,urltext.getText().toString().trim());
                }


            }
        });

        MylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name;
                Intent a = getIntent();
                name = a.getStringExtra(USER_CODE);

                Intent intent = new Intent();
                intent.setClass(Homepage.this, Myplaylist.class);
                intent.putExtra("name", name);
                startActivity(intent);

                ;
            }
        });
    }
}