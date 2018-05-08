package ofenbach.exampleapp.views;

import ofenbach.exampleapp.framework.Image;
import ofenbach.exampleapp.framework.Sprite;
import ofenbach.exampleapp.main.R;
import ofenbach.exampleapp.main.Screen;

/* @creation:   25.4.2018       */
/* @author:     Tim B. Ofenbach */

/* update news 28.4.2018:
	+ added particle animation
	+ new gravity support used
	+ automatic positions used
	+ new touch functions added
 */


public class ExampleScreen extends Screen {

    /** FEEL FREE TO EDIT THIS AND PLAY WITH IT! **/

    // Create Images like this:
    Image background;
    Image player;
    Image floor_1, floor_2, floor_3;

    Sprite particle;

    double gravitytimer, sintimer;    // for the players gravity

    public void load() {

        // Load them like this (put your .png in the res/drawable folder
        background = new Image(R.drawable.backdrop);
        player = new Image(R.drawable.player);
        floor_1 = new Image(R.drawable.floor_1);
        floor_2 = new Image(R.drawable.floor_2);
        floor_3 = new Image(R.drawable.floor_3);
        particle = new Sprite(new int[] {R.drawable.dust_1, R.drawable.dust_2, R.drawable.dust_3,
                R.drawable.dust_4, R.drawable.dust_5, R.drawable.dust_6, R.drawable.dust_7}, 0.04);

        // Scale them like this (depending on your wish, use different scale functions, see Image.java)
        background.scaleFullscreen();
        player.scaleHalf();
        floor_1.scaleHalf();
        floor_2.scaleHalf();
        floor_3.scaleHalf();
        particle.scaleHalf();

        // Set your positions like this. Now works with the same resolution (virtual) on every device!
        player.setXtoMiddle();
        player.setYtoMiddle();
        floor_1.setX(0);
        floor_1.setY(1080 - floor_1.getHeight() * 0.65);
        floor_2.setX(0);
        floor_2.setY(floor_1.getY() - floor_2.getHeight()*0.45);
        floor_3.setY(floor_2.getY() - floor_3.getHeight() * 0.45);
        for (int i = 0; i < particle.images.size(); i ++) {
            particle.setX(i,(int) player.getX() + player.getWidth() / 2 - particle.getWidth(i) / 2);
            particle.setY(i,(int) (1080 * 0.81));
        }

        // Apply game functions
        player.setGravity(9.81);     // 9.81 earth gravity

    }


    public void repeat() {

        // Bounce Check
        if  (player.y >= floor_2.y - floor_2.getHeight()) {
            player.setGravityTimer(-3);
            particle.startAnimation();
        }

        // Floor animation
        floor_1.y = floor_1.getY() + Math.sin(sintimer*0.15)*0.8;        // 15% Speed, 0.8x Ausschwenkung
        floor_3.y = floor_3.getY() - Math.sin(sintimer*0.15)*0.8;
        sintimer += 0.5;

        // Draw your images
        background.draw();
        floor_3.draw();
        floor_2.draw();
        floor_1.draw();
        player.draw();
        particle.draw();

    }


    /* TOUCH FUNCTIONS */
    public void touchDown() {
        player.increaseGravity(1);
    }
    public void touchUp() {}
    public void touchHold() {}

}
