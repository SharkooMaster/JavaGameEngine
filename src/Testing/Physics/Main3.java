package Testing.Physics;

import Main.Main;
import Main.Msc.ObjectHandler;
import Main.Msc.Vector2;
import Testing.Plattformer.Item;

import javax.swing.*;
import java.awt.*;


public class Main3 {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setTitle("Physics Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Main.isPlaying=true;
        Main.background= new Color(44, 157, 228);
        Testing.Physics.Item item1 = new  Testing.Physics.Item(true);
        item1.setPosition(new Vector2(200,200));

        Ground g = new Ground();
        g.setPosition(new Vector2(200,500));
        ObjectHandler.addObject(g);

        ObjectHandler.addObject(item1);

        Ground g1 = new Ground();
        g1.setPosition(new Vector2(300,300));
        ObjectHandler.addObject(g1);

        Main.Start(frame);
    }

}
