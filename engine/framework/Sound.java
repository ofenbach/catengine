package ofenbach.exampleapp.framework;  // change this to your package name

import android.media.AudioManager;
import android.media.SoundPool;

import ofenbach.exampleapp.main.MainActivity;	// change this to your package name
import ofenbach.exampleapp.main.Settings;   // change this to your package name

/* to create simple sounds in your app (e.g. explosions, gunshots). */
/* @creation:   May 2014        */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

/* update news 28.4.2018:
	+ turns off when Settings.sound_on is false
	- removed unnecessary comments
 */


public class Sound {

    SoundPool soundPool;
    int path;

    public Sound(int sound_direction) {
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        this.path = soundPool.load(MainActivity.context, sound_direction, 1);
    }

    public void play() {
        if (Settings.sound_enabled()) {
            soundPool.play(path, 1, 1, 0, 0, 1);
        }
    }

    public void setVolume(double procent) {
        soundPool.setVolume(path, (float) procent, (float) procent);
    }

    public void delete() {
        soundPool.unload(path);
    }

}
