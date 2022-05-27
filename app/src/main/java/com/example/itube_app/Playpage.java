package com.example.itube_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Playpage extends YouTubeBaseActivity {
    YouTubePlayerView playerview;
    Button playbutton;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    private static final String TAG = "Playpage";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playpage);
        Log.d(TAG, "onCreate Starting ~ ");

        playerview = (YouTubePlayerView) findViewById(R.id.YouTube_Player);
        playbutton = findViewById(R.id.Video_Play_Button);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                Log.d(TAG, "Finished.");
                String URL;
                Intent a = getIntent();
                URL = a.getStringExtra("url");

                youTubePlayer.loadVideo(URL);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Log.d(TAG, "Sorry, failed");
            }
        };

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Initializing YouTube Player.");
                playerview.initialize(YoutubeConfig.getApiKey(), onInitializedListener );



            }
        });
    }
}