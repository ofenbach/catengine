package catgames.views;

/* YOU NEED THIS FILE */

public class GameStart  {

    IntroScreen introscreen;
    MenuScreen menuscreen;
    GameScreen gamescreen;

    public GameStart() {

        introscreen = new IntroScreen();
        menuscreen = new MenuScreen();
        gamescreen = new GameScreen();

    }

    public void start() {

        introscreen.load();
        menuscreen.load();

    }

}
