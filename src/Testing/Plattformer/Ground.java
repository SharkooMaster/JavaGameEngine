package Testing.Plattformer;

import Main.Msc.Vector2;
import Main.Objects.Components.Collision.ScareCollider;
import Main.Objects.Components.Physics.PhysicsBody;
import Main.Objects.Object;

public class Ground extends Object {
    public Ground(Vector2 position, Vector2 scale,String tagname) {
        super(position);
        setTag(tagname);
        ScareCollider c = new ScareCollider();
        c.setVisible(true);
        c.setParent(this);
        c.setScale(scale);
        c.setPosition(position);
        addCollider(c);


        PhysicsBody b = new PhysicsBody();
        b.setUseGravity(false);
        b.setParent(this);
        b.setScale(getScale());
        b.setPosition(getPosition());
        setPhysicsbody(b);
        setScale(scale);

    }

}
