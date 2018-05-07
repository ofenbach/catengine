package ofenbach.exampleapp.main;	// change this to your package name

/* class with mostly statics, to save your app settings */
/* @creation:   September 2016  */
/* @update:     28.4.2018       */
/* @author:     Tim B. Ofenbach */

/* Explanation: */
/* You should also save your app settings (e.g. sound on) here. */

public class Settings {

    public static boolean sound_on = Device.getSavingBool("sound_on");

    public static void set_sound_enabled(boolean sound_on) {
        this.sound_on = sound_on;
        Device.setSavingBool("sound_on", sound_on);
    }
    public static boolean sound_enabled() {
        return sound_on;
    }

}
