package catgames.main;    // TODO: Change this one to your main package

import java.util.ArrayList;
import java.util.List;

public abstract class Screen  {

    public static List<Screen> screens = new ArrayList<>();   // saves the classes children

    public Screen() {
        screens.add(this);
    }

    public void repeat() {}

    public void load() {}

    public void touch() {}

    public void comeFront() {}

}
