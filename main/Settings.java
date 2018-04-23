package catgames.main;    // TODO: Change this one to your main package

/* CLASS WITH TOOLS (e.g. random) AND SAVINGS */

import android.content.Context;

public class Settings {

    public static Context context;

    public static int screen_height;
    public static int screen_width;

    public static boolean sound_on = true;


    public static Context getContext() {
        return context;
    }

    public static int getScreenHeight() {
        return screen_height;
    }
    public static int getScreenWidth() {
        return screen_width;
    }



}
