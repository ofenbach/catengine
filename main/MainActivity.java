package catgames.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import catgames.views.GameStart;

/* DONT CHANGE ANYTHING HERE IF YOU DONT KNOW WHAT YOU ARE DOING! THIS IS THE HEART OF THE ENGINE! BEWARE! */

public class MainActivity extends Activity {

    RelativeLayout layout;  // ignore this
    MainView view;          // to display everything
    GameStart gamestart;    // to launch your game

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Settings.context = this;

        layout = new RelativeLayout(this);
        setContentView(layout);

        view = new MainView();
        layout.addView(view);   // start displaying

    }


}
