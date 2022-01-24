package JGame.Msc;

import JGame.Objects.GameObject;

import java.util.LinkedList;

public class ObjectHandler {

    private static LinkedList<GameObject> objects = new LinkedList<>();

    public static void addObject(GameObject object)
    {
        objects.add(object);
    }

    public static LinkedList<GameObject> getObjects() {
        return objects;
    }

    public static void removeObject(GameObject object)
    {
        objects.remove(object);

    }
    public static void setObjects(LinkedList<GameObject> objects2) {
        objects = objects2;
    }
}
