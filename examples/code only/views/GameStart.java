package ofenbach.exampleapp.views;

/* @creation:   25.4.2018       */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class GameStart  {

    /** FEEL FREE TO EDIT THIS AND PLAY WITH IT! **/

    ExampleScreen escreen;      // add your costum screens here

    public GameStart() {

        escreen = new ExampleScreen();  // load your own screens here (order important as they will affect there id in Camera.java)

    }

    public void start() {

        escreen.load(); // load/start your own screens here

    }

}