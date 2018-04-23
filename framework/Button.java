package catgames.framework;

import android.text.method.Touch;
import android.view.MotionEvent;

import catgames.main.TouchEvent;    // change this one to your main package

/** Author: Tim Ofenbach **/

public class Button extends Image {

	/* CONSTRUCTOR */
	public Button(int path) { super(path); }

	/* TOUCH FUNCTION */
    public boolean isPressed() {
    	
    	// Touch coords
      int touchX = (int) TouchEvent.touch_event.getX();
      int touchY = (int) TouchEvent.touch_event.getY();
        
      // Return
      boolean pressed = false;
        
			// Hitbox check
			if (touchX > super.getX() && touchX < super.getX() + super.getWidth() && touchY > super.getY() && touchY < super.getY() + super.getHeight()) {
				pressed = true;
			} else {
				pressed = false;
			}
        
       return pressed;
    }
	
}
