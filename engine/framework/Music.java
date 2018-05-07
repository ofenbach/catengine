package ofenbach.exampleapp.framework;	// change this to your package name

import android.media.MediaPlayer;

import ofenbach.exampleapp.main.MainActivity;
import ofenbach.exampleapp.main.Settings;	// change this to your package name

/* Music.java to play simple background music in your app */
/* @creation:   May 2014        */
/* @update:     28.4.2018       */
/* @author:     Tim B. Ofenbach */

/* update news 28.4.2018:
	+ turns off when Settings.sound_on is false
	- removed unnecessary comments
 */

public class Music {

	MediaPlayer mediaplayer;
	int path;
	
	boolean isPrepared;

	public Music(int path) {
		
		this.path = path;

		mediaplayer = new MediaPlayer();
		mediaplayer = MediaPlayer.create(MainActivity.context, path); // load music
		
	}

	public void play() {
		if (Settings.sound_enabled()) {
			mediaplayer.start();
		}
	}

	public void stop() {
		mediaplayer.stop();
		synchronized (this) {
			isPrepared = false;
		}
	}

	public void pause() {
		if (mediaplayer.isPlaying()) {
			mediaplayer.pause();
		}
	}

	public void setVolume(float volume) {
		mediaplayer.setVolume(volume, volume);
	}

	public void setLooping(boolean looping) {
		mediaplayer.setLooping(looping);
	}

	public void delete() {
		if (mediaplayer.isPlaying()) {
			mediaplayer.stop();
		}
		mediaplayer.release();
	}
	
}
