package ofenbach.exampleapp.framework;	// change this to your package name

import android.media.MediaPlayer;

import ofenbach.exampleapp.main.Settings;	// change this to your package name

/* Music.java to play simple background music in your app */
/* @creation:   May 2014        */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Music {

	// MediaPlayer
	MediaPlayer mediaplayer;
	
	// Pfad
	int path;
	boolean isPrepared;
	
	
	/* KONSTRUKTOR */
	public Music(int path) {
		
		this.path = path;
		
		// Musik laden
		mediaplayer = new MediaPlayer();
		mediaplayer = MediaPlayer.create(Settings.context, path);
		//mediaplayer.setLooping(true);
		
	}
	
	
	/* PLAY */
	public void play() {
		mediaplayer.start();
	}
	
	
	/* STOP */
	public void stop() {
		mediaplayer.stop();
		synchronized (this) {
			isPrepared = false;
		}
	}
	
	
	/* PAUSE */
	public void pause() {
		if (mediaplayer.isPlaying()) {
			mediaplayer.pause();
		}
	}
	
	
	/* LAUTSTAERKE */
	public void setVolume(float volume) {
		mediaplayer.setVolume(volume, volume);
	}
    
	
	/* WIEDERHOLUNG */
	public void setLooping(boolean looping) {
		mediaplayer.setLooping(looping);
	}
	
	
	/* DELETE */
	public void delete() {
		if (mediaplayer.isPlaying()) {
			mediaplayer.stop();
		}
		mediaplayer.release();
	}
	
	
}
