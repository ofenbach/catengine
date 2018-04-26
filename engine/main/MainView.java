package ofenbach.exampleapp.main;	// change this to your package name

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import ofenbach.exampleapp.views.GameStart;	// change this to your package name

/* @creation:   March 2018      */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class MainView extends View {

    /** ONLY CHANGE THIS IF YOU KNOW WHAT YOU ARE DOING! **/
    
    /* Explanation: */
    /* This Class is the real screen thats being displayed by android os. */
    /* It selects the current screen and displays/repeats it's repeat() method. */

    public static Canvas global_canvas;     // used by Image.java to draw

    GameStart gamestart;
    boolean first_time = true;

    public MainView() {
        super(Settings.context);

        gamestart = new GameStart();    // start game

    }

    public void onDraw(Canvas c) {

        global_canvas = c;

        if (first_time) {   // save screen size, start game
            Settings.screen_height = c.getHeight();
            Settings.screen_width = c.getWidth();
            first_time = false;
            gamestart.start();
        }

        Screen.screens.get(Camera.currentscreen_id).repeat();   // display current screen

        invalidate();   // repeat

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        TouchEvent.touch_event = ev;    // update event

        Screen.screens.get(Camera.currentscreen_id).touch();    // trigger touch function in the right screen

        return true;
    }

}
