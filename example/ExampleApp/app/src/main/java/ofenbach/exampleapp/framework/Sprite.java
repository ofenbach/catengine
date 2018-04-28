package ofenbach.exampleapp.framework;	// change this to your package name

import java.util.ArrayList;
import java.util.List;

/* @creation:   28.4.2018	    */
/* @update:     -               */
/* @author:     Tim B. Ofenbach */

public class Sprite {

    public List<Image> images = new ArrayList<>();   // list with pictures

    int current_pic;            // current pic to display
    double duration;	        // how long each pic will display / change between the pics (in sec)
    double complete_duration;	// #pictures*duration
    boolean animation;          // to start the animation
    double timer;               // animationtimer


    public Sprite(int[] pictures, double duration) {

        // parameter update
        this.duration = duration;
        this.timer = duration;
        this.complete_duration = pictures.length * duration;

        // load
        for (int i = 0; i<pictures.length; i++) {
            images.add(new Image(pictures[i]));
        }

    }


    public void startAnimation() {
        this.animation = true;
    }


    public void draw() {    // put this in your repeat()

        if (animation) {

            if (timer < duration) {

                timer += 0.01666666666;

            } else {

                timer = 0;

                if (current_pic < images.size() - 1) {
                    current_pic++;  // change to next pic
                } else {
                    current_pic = 0;    // finished
                    animation = false;
                }

            }

            if (animation) { images.get(current_pic).draw(); }

        }

    }


    /* SET FUNCTIONS */
    public void setX(int id, int x) {
        images.get(id).setX(x);
    }
    public void setY(int id, int y) {
        images.get(id).setY(y);
    }


    /* GET FUNCTIONS */
    public int getWidth(int id) {
        return images.get(id).getWidth();
    }
    public int getHeight(int id) {
        return images.get(id).getHeight();
    }


    /* SCALE */
    public void scaleHalf() {
        for (int i = 0; i<images.size(); i++) {
            images.get(i).scaleHalf();
        }
    }
    public void scale() {
        for (int i = 0; i<images.size(); i++) {
            images.get(i).scale();
        }
    }


}