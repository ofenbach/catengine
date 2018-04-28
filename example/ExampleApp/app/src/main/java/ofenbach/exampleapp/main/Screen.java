package ofenbach.exampleapp.main;	// change this to your package name

import java.util.ArrayList;
import java.util.List;

/* Saves its own children, to know what screens there are and which one to display. */
/* @creation:   March 2018      */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Screen  {
    
    /* Explanation: */
    /* acts as a superclass for your screens. */
    /* here are all the screens which were created stored  */
    /* MainView displays the right screen (id stored at Camera) via this list */

    public static List<Screen> screens = new ArrayList<>(); // child list (used by MainView to display the right screen)

    public Screen() {
        screens.add(this);  // save child
    }

    public void repeat() {} // loop 60FPS

    public void load() {}   // when the screen starts

    public void touchHold() {}  // triggered by touch

    public void touchDown() {}

    public void touchUp() { }

}
