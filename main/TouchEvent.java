package catgames.main;    // TODO: Change this to your main package

import android.view.MotionEvent;

public class TouchEvent {

    public static MotionEvent touch_event;

    public static int getX() {
        return (int) touch_event.getX();
    }

    public static int getY() {
        return (int) touch_event.getY();
    }

}
