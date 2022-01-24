package JGame;

import JGame.Display.GameWorld;
import JGame.Objects.GameObject;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static int DELAY = 10;
    public static Color background;
    public static int updates = 0;
    /**
     * Update game world*/
    public static boolean isPlaying = false;

    public static void Start(JFrame frame)
    {
        GameWorld m = new GameWorld();
        m.setFocusable(true);
        m.setBackground(background);
        frame.add(m);
        frame.setVisible(true);

        while(true)
        {

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }

            long start = System.nanoTime();

            if(isPlaying)
            {
                m.Update();
                updates++;
            }
            long end = System.nanoTime();
            //System.out.println((end-start)/1000000);
        }
    }
    public static void instantiate(GameObject obj)
    {
        //System.out.println("what");
        GameWorld.newObjects.add(obj);
    }
}
