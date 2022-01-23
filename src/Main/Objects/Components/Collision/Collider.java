package Main.Objects.Components.Collision;

import Main.Msc.Vector2;
import Main.Objects.Components.Component;
import Main.Objects.Object;

public class Collider extends Component {


    private boolean isTrgger = false;


    public Collider() {
    }

    public boolean isTrgger() {
        return isTrgger;
    }

    public void setTrgger(boolean trgger) {
        isTrgger = trgger;
    }

    public Collider(Vector2 position, Vector2 scale) {
        setPosition(position);
        setScale(scale);
    }


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
