package com.alehshyliuk.roastbattlecontroller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private final List<ImageButton> playButtons = new ArrayList<>();
    private final List<MediaPlayer> players = new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initializePlayers();
        initializeButtons();

        for (final ImageButton btn: playButtons){
            btn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int ind = playButtons.indexOf(btn);

                    if (event.getAction() == MotionEvent.ACTION_DOWN)
                        btn.setBackgroundResource(R.drawable.but_green);
                    else if (event.getAction() == MotionEvent.ACTION_UP){
                        btn.setBackgroundResource(ind % 2 == 0 ? R.drawable.but_blue : R.drawable.but_red);
                        if (players.get(ind).isPlaying()){
                            players.get(ind).pause();
                        }
                        players.get(ind).seekTo(0);
                        players.get(ind).start();
                    }
                    return false;
                }
            });
        }
    }

    private void initializeButtons() {
        playButtons.add((ImageButton) this.findViewById(R.id.button1));
        playButtons.add((ImageButton) this.findViewById(R.id.button2));
        playButtons.add((ImageButton) this.findViewById(R.id.button3));
        playButtons.add((ImageButton) this.findViewById(R.id.button4));
        playButtons.add((ImageButton) this.findViewById(R.id.button5));
        playButtons.add((ImageButton) this.findViewById(R.id.button6));
    }

    private void initializePlayers() {
        players.add(MediaPlayer.create(this, R.raw.cock));
        players.add(MediaPlayer.create(this, R.raw.gong));
        players.add(MediaPlayer.create(this, R.raw.grenade));
        players.add(MediaPlayer.create(this, R.raw.gun));
        players.add(MediaPlayer.create(this, R.raw.haha));
        players.add(MediaPlayer.create(this, R.raw.horn));
    }
}