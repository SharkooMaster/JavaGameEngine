package Main.Objects.Components;

import Main.Msc.Vector2;
import Main.Objects.Object;

import java.awt.*;

public class Component {

    private Vector2 position=new Vector2(0,0);
    private Vector2 offset=new Vector2(0,0);
    private Vector2 scale;
    private boolean visible = false;
    private Object parent;
    public Polygon p = new Polygon();

    public Component() {
        p = new Polygon(new int[]{0,0,0,0},new int[]{0,0,0,0},4);
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
        for(int i = 0;i<p.ypoints.length;i++)
        {
            p.ypoints[i] += position.getY();
        }
        for(int i = 0;i<p.xpoints.length;i++)
        {
            p.xpoints[i] += position.getX();
        }
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
        //System.out.println((getPosition().getX()-scale.getX()));
        p = new Polygon(new int[]{(int) (getPosition().getX()-scale.getX()/2), (int) (getPosition().getX()+scale.getX()/2), (int) (getPosition().getX()+scale.getX()/2), (int) (getPosition().getX()-scale.getX()/2)}
                ,new int[]{(int) (getPosition().getY()- scale.getY()/2), (int) (getPosition().getY()- scale.getY()/2), (int) (getPosition().getY()+ scale.getY()/2), (int) (getPosition().getY()+ scale.getY()/2)},4);

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
        //p.translate((int) (-this.position.getX()), (int) (this.position.getY()));
    }

    public Component copy()
    {

        return this;
    }

}
