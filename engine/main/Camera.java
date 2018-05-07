package ofenbach.exampleapp.main;	// change this to your package name

/* to switch screens            */
/* @creation:   March 2018      */
/* @update:     26.4.2018       */
/* @author:     Tim B. Ofenbach */

/* Explanation: */
/* only saves which screen_id to display */
/* MainView displays Screen.children[Camera.currentscreen_id] */

public class Camera {
    
    public static int current_screen_id = 0;     // current screen to display

    public static void setScreen(int id) {
        current_screen_id = id;      // switch current screen to display
    }

}
