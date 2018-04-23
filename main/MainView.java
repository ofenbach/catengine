package catgames.main;    // TODO: Change this to your main package

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import catgames.views.GameStart;

public class MainView extends View {

    public static Canvas global_canvas;
    public static MotionEvent global_motionevent;
    GameStart gamestart;
    boolean firsttime = true;

    public MainView() {
        super(Settings.context);

        gamestart = new GameStart();

    }

    public void onDraw(Canvas c) {

        if (firsttime)
            Settings.screen_height = c.getHeight();
            Settings.screen_width = c.getWidth();
            gamestart.start();
            firsttime = false;

        global_canvas = c;

        Screen.screens.get(Camera.currentscreen_id).repeat();

        invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        TouchEvent.touch_event = ev;

        Screen.screens.get(Camera.currentscreen_id).touch();

        return true;
    }

}
