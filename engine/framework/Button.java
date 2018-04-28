package ofenbach.exampleapp.framework;  // change this to your package name

import ofenbach.exampleapp.main.TouchEvent; // change this to your package name

/* Same as Image.java but can register touch */
/* @creation:   March 2014      */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Button extends Image {

    public Button(int path) {
        super(path);
    }

    public boolean isPressed() {

        // Touch coords
        int touchX = TouchEvent.getX();
        int touchY = TouchEvent.getY();

        // Hitbox check
        return (touchX > super.getX() && touchX < super.getX() + super.getWidth() && touchY > super.getY() && touchY < super.getY() + super.getHeight());

    }

}