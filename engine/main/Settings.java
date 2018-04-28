package ofenbach.exampleapp.main;	// change this to your package name

/* class with mostly statics, to save your app settings */
/* @creation:   September 2016  */
/* @update:     28.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Settings {

    /* Explanation: */
    /* You should also save your app settings (e.g. sound on) here. */

    public static boolean sound_on = Device.getSavingBool("sound_on");


    public static void set_sound_enabled(boolean bool) {
        sound_on = bool;
        // save
        if (bool) {
            Device.setSaving("sound_on", 1);
        } else {
            Device.setSaving("sound_on", 0);
        }
    }
    public static boolean sound_enabled() {
        return sound_on;
    }


}
