package ofenbach.exampleapp.framework;

import android.media.AudioManager;
import android.media.SoundPool;

import ofenbach.exampleapp.main.Settings;

/* to create simple sounds in your app (e.g. explosions, gunshots). */
/* @creation:   May 2014        */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Sound {

    SoundPool soundPool;

    // Path
    int path;


    /* CONSTRUCTOR */
    @SuppressWarnings("deprecation")
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