package ofenbach.exampleapp.views;

import ofenbach.exampleapp.framework.Image;
import ofenbach.exampleapp.framework.Button;
import ofenbach.exampleapp.main.Camera;
import ofenbach.exampleapp.main.R;
import ofenbach.exampleapp.main.Screen;
import ofenbach.exampleapp.main.Settings;

/* @creation:   25.4.2018       */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class ExampleScreen extends Screen {

    /** FEEL FREE TO EDIT THIS AND PLAY WITH IT! **/

    // Create Images like this:
    Image background;
    Image player;
    Image floor_1, floor_2, floor_3;

    double gravitytimer;    // for the players gravity

    public void load() {

        // Load them like this (put your .png in the res/drawable folder
        background = new Image(R.drawable.backdrop);
        player = new Image(R.drawable.player);
        floor_1 = new Image(R.drawable.floor_1);
        floor_2 = new Image(R.drawable.floor_2);
        floor_3 = new Image(R.drawable.floor_3);

        // Scale them like this (depending on your wish, use different scale functions, see Image.java)
        background.scaleFullscreen();
        player.scaleHalf();             // scaleHalf because the png is twice its normal size (don't ask why)
        floor_1.scaleHalf();
        floor_2.scaleHalf();
        floor_3.scaleHalf();

        // Set your positions like this. Remember to always use relative positions so your app works with every device!
        player.setXtoMiddle();
        player.setYtoMiddle();
        floor_1.setX(0);
        floor_1.setY(Settings.getScreenHeight() - floor_1.getHeight() * 0.65);  // IMPORTANT: Relative Positions independent of the screen size
        floor_2.setX(0);
        floor_2.setY(floor_1.getY() - floor_2.getHeight()*0.45);
        floor_3.setY(floor_2.getY() - floor_3.getHeight() * 0.45);

    }

    public void repeat() {

        // Player Gravity
        if (player.y >= floor_2.y -floor_2.getHeight()) {       // Bounce
            gravitytimer = -3;
        }
        gravitytimer += 0.06;
        player.y += gravitytimer * 9.81;

        // Draw your images
        background.draw();
        floor_3.draw();
        floor_2.draw();
        floor_1.draw();
        player.draw();

    }

    public void touch() {

        // here you can add your button.isPressed() check

    }

}