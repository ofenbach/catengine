package ofenbach.exampleapp.main;

import android.content.SharedPreferences;

/* class with mostly statics, to save your app data and get device specs */
/* @creation:   28.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Device {

    public static int screen_height;
    public static int screen_width;

    /* Device specs */
    public static int get_screen_width() {
        return screen_width;
    }
    public static int get_screen_height() {
        return screen_height;
    }


    /* Save functions */
    public static void setSaving(String file_name, int value) {
        SharedPreferences file = MainActivity.context.getSharedPreferences(file_name, 0);
        SharedPreferences.Editor editor = file.edit();
        editor.putInt(file_name, value);
        editor.commit();
    }
    public static void setSaving(String file_name, boolean value) {
        SharedPreferences file = MainActivity.context.getSharedPreferences(file_name, 0);
        SharedPreferences.Editor editor = file.edit();
        if (value) { editor.putInt(file_name, 1); }
        else  { editor.putInt(file_name, 0); }
        editor.commit();
    }
    public static int getSaving(String file_name) {
        SharedPreferences file = MainActivity.context.getSharedPreferences(file_name, 0);
        return file.getInt(file_name, 0);
    }
    public static boolean getSavingBool(String file_name) {
        SharedPreferences file = MainActivity.context.getSharedPreferences(file_name, 0);
        if (file.getInt(file_name, 0) == 0) {
            return false;
        } else {
            return true;
        }
    }


}