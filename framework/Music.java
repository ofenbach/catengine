package catgames.framework;

import android.media.MediaPlayer;

import catgames.main.Settings;    // change this one to your main package

public class Music {

	// MediaPlayer
	MediaPlayer mediaplayer;
	
	// Path
	int path;
	boolean isPrepared;
	
	
	/* CONSTRUCTOR */
	public Music(int path) {
		
		this.path = path;
		
		// load music
		mediaplayer = new MediaPlayer();
		mediaplayer = MediaPlayer.create(Settings.context, path);
		// OPTIONAL: mediaplayer.setLooping(true);
		
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
	
	
	/* VOLUME */
	public void setVolume(float volume) {
		mediaplayer.setVolume(volume, volume);
	}
    
	
	/* LOOP */
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
