package Testing.Plattformer;

import Main.Msc.Vector2;
import Main.Objects.Animation;
import Main.Objects.Components.Collision.ScareCollider;
import Main.Objects.Components.Physics.PhysicsBody;
import Main.Objects.Components.Physics.PhysicsWorld;
import Main.Objects.Object;

public class Enemy extends Object {

    public Enemy(Vector2 position) {
        super(position);
        setAnimation(new Animation());
        setAngle(90);
        getAnimation().setTILE_SIZE(new Vector2(229,251));
        getAnimation().setPath("/spritesheet.png");
        setScale(new Vector2(100,100));
        getAnimation().loadAnimation(new Vector2[]{new Vector2(0,0),new Vector2(0,1)});

        ScareCollider collider = new ScareCollider();
        collider.setScale(new Vector2(100,100));
        collider.setPosition(this.getPosition());
        collider.setParent(this);
        collider.setVisible(true);
        addCollider(collider);

        PhysicsBody b = new PhysicsBody();
        b.setUseGravity(false);
        b.setParent(this);
        b.setScale(getScale());
        b.setPosition(getPosition());
        setPhysicsbody(b);

    }

    @Override
    public void onCollision(Object collision) {
        super.onCollision(collision);
        System.out.println(collision);
        if(collision.getTag().equals("Bullet"))
        {
            this.Destroy();
        }
    }
}
