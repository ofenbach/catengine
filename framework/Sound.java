package catgames.framework;

import android.media.AudioManager;
import android.media.SoundPool;

import catgames.main.Settings;    // TODO: Change this one to your main package
  
public class Sound {

	// Soundpool
	SoundPool soundPool;
	
	// Path
	int path;
	
	
	/* CONSTRUCTOR */
	@SuppressWarnings("")
	public Sound(int sound_direction) {
		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		this.path = soundPool.load(Settings.getContext(), sound_direction, 1);
	}
	
	
	/* PLAY */
	public void play() {
		soundPool.play(path, 1, 1, 0, 0, 1);
	}

	/* VOLUME */
	public void setVolume(double procent) {
		soundPool.setVolume(path, (float) procent, (float) procent);
	}

	/* DELETE */
	public void delete() {
		soundPool.unload(path);
	}
	
}
