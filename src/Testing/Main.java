package Testing;

import JavaGameEngine.Backend.ComponentHandler;
import JavaGameEngine.Backend.UpdateThread;
import JavaGameEngine.Components.Collider.SquareCollider;
import JavaGameEngine.Components.Component;
import JavaGameEngine.Components.GameObject;
import JavaGameEngine.Components.Ui.Label;
import JavaGameEngine.JavaGameEngine;
import JavaGameEngine.msc.Vector2;

import javax.swing.*;
import java.awt.*;

public class Main extends JavaGameEngine{

    public static void main(String[] args){
        Main m = new Main();
        m.init();

        Player s = new Player(new Vector2(40,10));
        ComponentHandler.addObject(s);
        JFrame frame = new JFrame();
        frame.setTitle("My example Title");

        Ground ground = new Ground();
        ComponentHandler.addObject(ground);

        Component camera = new Component();
        s.addChild(camera);

        UpdateThread.camera = camera;

        ComponentHandler.addObject(new T());



        m.start();
    }
    static class T extends GameObject{
        public T(){
            SquareCollider s = new SquareCollider();
            addChild(s);
        }
    }
}
