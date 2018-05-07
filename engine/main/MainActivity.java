package ofenbach.exampleapp.main;	// change this to your package name

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;

/* @creation:   February 2014   */
/* @update:     28.4.2018       */
/* @author:     Tim B. Ofenbach */

/* update news 28.4.2018:

    new features:
    + gravity support
    + save support
    + new sprite/particle class
    + automatic position support
    + new touch functions: touchHold, touchUp, touchDown

    code stuff:
    + added code documentation for each class
    + added Device.java to get specs (e.g. screen size) & save support
    + sound settings gets saved / loaded automatic
    + added new features to ExampleScreen.java
    + improved code style (w.i.p)

    small fixes:
    + music & sound stops when sound_on = false

    github:
    + example runs new update

 */

/* Explanation: */
/* The app starts here. */
/* From here, the MainView starts and selects the screen to display */

/** DO NOT CHANGE THIS UNLESS YOU KNOW WHAT YOU ARE DOING! **/
public class MainActivity extends Activity {

    RelativeLayout layout;
    MainView view;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = this;

        layout = new RelativeLayout(this);
        setContentView(layout);

        view = new MainView();
        layout.addView(view);   // MainView starts

    }

}
