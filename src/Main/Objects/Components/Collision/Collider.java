package Main.Objects.Components.Collision;

import Main.Msc.Vector2;
import Main.Objects.Components.Component;

public class Collider extends Component  {


    private boolean isTrigger = false;


    public Collider() {
    }

    public boolean isTrigger() {
        return isTrigger;
    }

    public void setTrigger(boolean trigger) {
        isTrigger = trigger;
    }

    public Collider(Vector2 position, Vector2 scale) {
        setPosition(position);
        setScale(scale);
    }

    public void collisionHandler(Collider ob2)
    {}

    public boolean isColliding(Collider otherCollider)
    {
        return false;
    }

    public void collided(Collider otherCollider)
    {

    }
    @Override
    public void Update()
    {
        setPosition(getParent().getPosition().add(getOffset()));
    }

}
