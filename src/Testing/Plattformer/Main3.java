package Testing.Plattformer;

import Main.Display.Map;
import Main.Main;
import Main.Msc.ObjectHandler;
import Main.Msc.Vector2;

import javax.swing.*;
import java.awt.*;


public class Main3  {

    public static JLabel vel = new JLabel("0");
    public static JLabel dir = new JLabel("0");

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setTitle("Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Main.isPlaying=true;
        Main.background= new Color(44, 157, 228);
        Map.addJComponent(vel);
        Map.addJComponent(dir);

        ObjectHandler.addObject(new Item(true));
        //ObjectHandler.addObject(new Enemy(new Vector2(300,500)));
        ObjectHandler.addObject(new Ground(new Vector2(300,600), new Vector2(1000,100),"ground1"));
        ObjectHandler.addObject(new Ground(new Vector2(300,500),new Vector2(100,100),"ground2"));

        Main.Start(frame);
    }

}
