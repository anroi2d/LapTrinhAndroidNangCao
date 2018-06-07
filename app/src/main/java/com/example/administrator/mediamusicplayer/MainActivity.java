package com.example.administrator.mediamusicplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnMp3,btnMp4;
    VideoView videoView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMp3 = (Button) findViewById(R.id.btnPlay);
        btnMp4= (Button) findViewById(R.id.btnMp4);
        videoView= (VideoView) findViewById(R.id.video_view);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);//vua vao an no di

        btnMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://khoapham.vn/download/vietnamoi.mp3";
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepareAsync();
                    //show Progressbar
                    progressBar.setVisibility(View.VISIBLE);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            progressBar.setVisibility(View.GONE);
                            mp.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://khoapham.vn/download/vuoncaovietnam.mp4";
                Uri uri = Uri.parse(url);
                videoView.setVideoURI(uri);
                videoView.setMediaController(new MediaController(MainActivity.this));
                videoView.start();

            }
        });
    }
}
