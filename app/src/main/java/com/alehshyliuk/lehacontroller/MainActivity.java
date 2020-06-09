package com.alehshyliuk.lehacontroller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {

    private MediaPlayer mp1;
    private MediaPlayer mp2;
    private MediaPlayer mp3;
    private MediaPlayer mp4;
    private MediaPlayer mp5;
    private MediaPlayer mp6;

    void create1(){ mp1 = MediaPlayer.create(this, R.raw.cock); }
    void create2(){ mp2 = MediaPlayer.create(this, R.raw.gong); }
    void create3(){ mp3 = MediaPlayer.create(this, R.raw.grenade); }
    void create4(){ mp4 = MediaPlayer.create(this, R.raw.gun); }
    void create5(){ mp5 = MediaPlayer.create(this, R.raw.haha); }
    void create6(){ mp6 = MediaPlayer.create(this, R.raw.horn); }

    void createAll(){
        create1();
        create2();
        create3();
        create4();
        create5();
        create6();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        createAll();

        final Button one = this.findViewById(R.id.button1);
        final Button two = this.findViewById(R.id.button2);
        final Button three = this.findViewById(R.id.button3);
        final Button four = this.findViewById(R.id.button4);
        final Button five = this.findViewById(R.id.button5);
        final Button six = this.findViewById(R.id.button6);

        one.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    one.setBackgroundColor(0xFF4CAF50);
                else if (event.getAction() == MotionEvent.ACTION_UP){
                    one.setBackgroundColor(0xFFCC0000);
                    if (mp1.isPlaying()){
                        mp1.stop();
                        create1();
                    }
                    mp1.start();
                }
                return false;
            }
        });

        two.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    two.setBackgroundColor(0xFF4CAF50);
                else if (event.getAction() == MotionEvent.ACTION_UP){
                    two.setBackgroundColor(0xFFCC0000);
                    if (mp2.isPlaying()){
                        mp2.stop();
                        create2();
                    }
                    mp2.start();
                }
                return false;
            }
        });

        three.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    three.setBackgroundColor(0xFF4CAF50);
                else if (event.getAction() == MotionEvent.ACTION_UP){
                    three.setBackgroundColor(0xFFCC0000);
                    if (mp3.isPlaying()){
                        mp3.stop();
                        create3();
                    }
                    mp3.start();
                }
                return false;
            }
        });

        four.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    four.setBackgroundColor(0xFF4CAF50);
                else if (event.getAction() == MotionEvent.ACTION_UP){
                    four.setBackgroundColor(0xFFCC0000);
                    if (mp4.isPlaying()){
                        mp4.stop();
                        create4();
                    }
                    mp4.start();
                }
                return false;
            }
        });

        five.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    five.setBackgroundColor(0xFF4CAF50);
                else if (event.getAction() == MotionEvent.ACTION_UP){
                    five.setBackgroundColor(0xFFCC0000);
                    if (mp5.isPlaying()){
                        mp5.stop();
                        create5();
                    }
                    mp5.start();
                }
                return false;
            }
        });

        six.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    six.setBackgroundColor(0xFF4CAF50);
                else if (event.getAction() == MotionEvent.ACTION_UP){
                    six.setBackgroundColor(0xFFCC0000);
                    if (mp6.isPlaying()){
                        mp6.stop();
                        create6();
                    }
                    mp6.start();
                }
                return false;
            }
        });
    }
}