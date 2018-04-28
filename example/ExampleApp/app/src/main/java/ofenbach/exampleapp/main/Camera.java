package ofenbach.exampleapp.main;	// change this to your package name

/* to switch screens            */
/* @creation:   March 2018      */
/* @update:     26.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Camera {

    /* Explanation: */
    /* only saves which screen_id to display */
    /* MainView displays Screen.children[Camera.currentscreen_id] */
    
    public static int currentscreen_id = 0;     // current screen to display

    public static void setScreen(int id) {
        currentscreen_id = id;      // switch current screen to display
    }

}