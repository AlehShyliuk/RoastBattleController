package com.alehshyliuk.roastbattlecontroller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    private static final DataEntry[] buttons = new DataEntry[]{
            new DataEntry("button1", "cock"),
            new DataEntry("button2", "gong"),
            new DataEntry("button3", "grenade"),
            new DataEntry("button4", "gun"),
            new DataEntry("button5", "haha"),
            new DataEntry("button6", "horn")
    };

    private final ButtonController[] buttonControllers = new ButtonController[buttons.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        for (int ind = 0; ind < buttons.length; ++ind) {
            buttonControllers[ind] = new ButtonController(this,
                    buttons[ind],
                    R.drawable.but_green,
                    ind % 2 == 0 ? R.drawable.but_blue : R.drawable.but_red);
        }
    }

    private static class DataEntry {
        public String viewName, dataName;

        public DataEntry(String viewName, String dataName) {
            this.viewName = viewName;
            this.dataName = dataName;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private static class ButtonController implements View.OnTouchListener {
        private final ImageButton button;
        private final MediaPlayer player;
        private final int backgroundActiveId;
        private final int backgroundInactiveId;

        public ButtonController(Activity activity, DataEntry dataEntry, int backgroundActiveId, int backgroundInactiveId) {
            this(activity, dataEntry.viewName, dataEntry.dataName, backgroundActiveId, backgroundInactiveId);
        }


        public ButtonController(Activity activity, String buttonName, String dataName, int backgroundActiveId, int backgroundInactiveId) {
            this(activity,
                    activity.getResources().getIdentifier(buttonName, "id", activity.getPackageName()),
                    activity.getResources().getIdentifier(dataName, "raw", activity.getPackageName()),
                    backgroundActiveId,
                    backgroundInactiveId);
        }

        public ButtonController(Activity activity, int buttonId, int dataId, int backgroundActiveId, int backgroundInactiveId) {
            this.button = (ImageButton) activity.findViewById(buttonId);
            this.player = MediaPlayer.create(activity, dataId);
            this.backgroundActiveId = backgroundActiveId;
            this.backgroundInactiveId = backgroundInactiveId;
            this.button.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                button.setBackgroundResource(backgroundActiveId);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                button.setBackgroundResource(backgroundInactiveId);
                if (player.isPlaying()) {
                    player.pause();
                }
                player.seekTo(0);
                player.start();
            }

            return false;
        }
    }
}
