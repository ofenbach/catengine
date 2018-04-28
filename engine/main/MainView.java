package ofenbach.exampleapp.main;	// change this to your package name

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import ofenbach.exampleapp.views.GameStart;	// change this to your package name

/* @creation:   March 2018      */
/* @update:     28.4.2018       */
/* @author:     Tim B. Ofenbach */

public class MainView extends View {

    /** ONLY CHANGE THIS IF YOU KNOW WHAT YOU ARE DOING! **/
    
    /* Explanation: */
    /* This Class is the real screen thats being displayed by android os. */
    /* It selects the current screen (saved in Camera) and repeats it's repeat() method. */

    public static Canvas global_canvas;     // used by Image.java to draw

    GameStart gamestart;
    boolean first_time = true;

    boolean touch_hold;

    public MainView() {
        super(MainActivity.context);

        gamestart = new GameStart();    // start game

    }

    public void onDraw(Canvas c) {

        global_canvas = c;

        if (first_time) {   // save screen size, start game
            Device.screen_height = c.getHeight();
            Device.screen_width = c.getWidth();
            first_time = false;
            gamestart.start();
        }

        Screen.screens.get(Camera.currentscreen_id).repeat();   // display current screen

        if (touch_hold) {
            Screen.screens.get(Camera.currentscreen_id).touchHold();    // trigger touch function in the right screen
        }

        invalidate();   // repeat this method

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        TouchEvent.touch_event = ev;    // update event

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {    // finger starts touching the screen
            touch_hold = true;
            Screen.screens.get(Camera.currentscreen_id).touchDown();
        }

        if (ev.getAction() == MotionEvent.ACTION_UP) {  // finger loses touch
            touch_hold = false;
            Screen.screens.get(Camera.currentscreen_id).touchUp();
        }

        return true;
    }

}
