package ofenbach.exampleapp.main;	// change this to your package name

/* class with mostly statics, to save your app data and get device information */
/* @creation:   September 2016  */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

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