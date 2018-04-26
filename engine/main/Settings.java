package ofenbach.exampleapp.main;	// change this to your package name

/* class with mostly statics, to save your app data and get device information */
/* @creation:   September 2016  */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

import android.content.Context;

public class Settings {

    /* Explanation: */
    /* At the start of the app, device information (screen size) are transferred here, so they can be accesed from everywhere. */
    /* You should also save your app data (e.g. gamescore) here. Save support comes in the next version. */
    
    public static Context context;

    public static int screen_height;
    public static int screen_width;

    public static boolean sound_on = true;
    
    /** ADD YOUR SAVES HERE **/


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
