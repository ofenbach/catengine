package ofenbach.exampleapp.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

/* @creation:   February 2014   */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class MainActivity extends Activity {

    /** ONLY CHANGE THIS IF YOU KNOW WHAT YOU ARE DOING! **/

    RelativeLayout layout;
    MainView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Settings.context = this;

        layout = new RelativeLayout(this);
        setContentView(layout);

        view = new MainView();
        layout.addView(view);

    }


}