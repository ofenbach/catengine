package ofenbach.exampleapp.main;

import java.util.ArrayList;
import java.util.List;

/* Saves its own children, to know what screens there are and which one to display. */
/* @creation:   March 2018      */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public abstract class Screen  {

    public static List<Screen> screens = new ArrayList<>(); // child list (used by Camera.java)

    public Screen() {
        screens.add(this);  // save child
    }

    public void repeat() {} // loop 60FPS

    public void load() {}   // when the screen starts

    public void touch() {}  // triggered by touch

}