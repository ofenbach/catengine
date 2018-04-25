package ofenbach.exampleapp.main;	// change this to your package name

import android.view.MotionEvent;

/* @creation:   March 2018      */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class TouchEvent {

    public static MotionEvent touch_event;  // to access coordinations, action-event etc.

    public static int getX() {
        return (int) touch_event.getX();
    }

    public static int getY() {
        return (int) touch_event.getY();
    }

}