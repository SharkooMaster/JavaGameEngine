package Testing.Plattformer;

import Main.Msc.Input.Input;
import Main.Msc.Input.Keys;
import Main.Msc.Vector2;
import Main.Objects.Animation;
import Main.Objects.Components.Collision.ScareCollider;
import Main.Objects.Components.Physics.PhysicsBody;
import Main.Objects.Object;

public class Item extends Object {

    private float speed = 2;

    public Item(boolean goDown) {

        super();

        setPosition(new Vector2(100,500));

        setAnimation(new Animation());
        setScale(new Vector2(100,100));
        getAnimation().setPath("/playerSheet.png");
        setAngle(0);
        getAnimation().setTILE_SIZE(new Vector2(128,150));
        getAnimation().setTimer(5);
        getAnimation().loadAnimation(new Vector2[]{new Vector2(0,0)});
        getAnimation().loadAnimation(new Vector2[]{new Vector2(0,0),new Vector2(1,0),new Vector2(2,0),new Vector2(3,0),new Vector2(4,0),new Vector2(5,0)
                ,new Vector2(6,0),new Vector2(0,1),new Vector2(1,1),new Vector2(2,1),new Vector2(3,1),new Vector2(3,1),
                new Vector2(4,1),new Vector2(5,1)
                ,new Vector2(6,1),new Vector2(0,2),new Vector2(1,2),new Vector2(2,2),new Vector2(4,2),new Vector2(5,2),new Vector2(6,2),});

        ScareCollider c = new ScareCollider();
        c.setScale(new Vector2(100,100));
        c.setParent(this);
        c.setOffset(new Vector2(0,-10));
        c.setVisible(true);
        addCollider(c);

        PhysicsBody b = new PhysicsBody();
        b.setScale(getScale());
        b.setVisible(true);
        b.setParent(this);
        b.setUseGravity(goDown);
        setPhysicsbody(b);

        setTag("Item");

    }

    @Override
    public void onCollisionExit(Object parent) {
        super.onCollisionExit(parent);
        System.out.println("i have collided ");
    }

    private void move()
    {
        //setPosition(getPosition().add(getDirection().multiply(speed)));
        getPhysicsbody().addForce(getDirection(),50);
    }

    @Override
    public void onCollision(Object collision) {
        super.onCollision(collision);
        System.out.println("colliding");
        hasJumped = false;
    }

    private boolean hasJumped = false;

    @Override
    public void Update() {
        super.Update();
        speed = 2;
        if(Input.isKeyDown(Keys.W))
        {
            getPhysicsbody().addForce(new Vector2(0,-1),50);
            hasJumped = true;
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

        this.UpdateComponents();

    }
}
