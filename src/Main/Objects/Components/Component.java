package Main.Objects.Components;

import Main.Msc.Vector2;
import Main.Objects.Object;

public class Component {

    private Vector2 position;
    private Vector2 offset=new Vector2(0,0);
    private Vector2 scale;
    private boolean visible = false;
    private Object parent;


    public Component() {
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getOffset() {
        return offset;
    }

    public void setOffset(Vector2 offset) {
        this.offset = offset;
    }

    public Vector2 getScale() {
        return scale;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void Update()
    {

    }

    public Component copy()
    {

        return this;
    }

}
