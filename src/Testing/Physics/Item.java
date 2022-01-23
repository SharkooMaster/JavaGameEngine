package Testing.Physics;

import Main.Msc.Input.Input;
import Main.Msc.Input.Keys;
import Main.Msc.Vector2;
import Main.Objects.Components.Collision.ScareCollider;
import Main.Objects.Components.Physics.PhysicsBody;
import Main.Objects.Object;

public class Item extends Object {

    private float speed = 2;

    public Item(boolean goDown) {

        super();

        setPosition(new Vector2(200,200));

        ScareCollider c = new ScareCollider();
        c.setPosition(getPosition());
        c.setScale(getScale());
        c.setVisible(true);
        c.setParent(this);
        addCollider(c);

        PhysicsBody b = new PhysicsBody();
        b.setScale(getScale());
        b.setVisible(true);
        b.setParent(this);
        b.setUseGravity(goDown);
        setPhysicsbody(b);

    }

    @Override
    public void onCollisionExit(Object parent) {
        super.onCollisionExit(parent);
    }

    private void move()
    {
            setPosition(getPosition().add(getDirection().multiply(speed)));
    }




    @Override
    public void Update() {
        super.Update();
        speed = 2;
        if(Input.isKeyDown(Keys.W))
        {
            getPhysicsbody().addForce(new Vector2(0,-1),1000);
        }
        else if(Input.isKeyDown(Keys.D))
        {
            setDirection(new Vector2(1,0));

        }
        else if(Input.isKeyDown(Keys.A))
        {
            setDirection(new Vector2(-1,0));
        }
        else
            setDirection(new Vector2(0,0));
        move();


    }
}
