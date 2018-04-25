package ofenbach.exampleapp.main;	// change this to your package name

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

/* @creation:   April 2018	    */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Particle {

	// Leere Liste wo Bilder reinkönnen

	int current_pic;
	int duration;	// how long each pic will display / change between the pics
	int complete_duration;	// #pictures*duration

    public Particle(list pictures) {

    }
	
	public void setPictures(list pictures) {}	// setup
	
	public void startAnimation() {}	// trigger to start sprite
	
	public void draw() {}	// put this in your repeat()


}