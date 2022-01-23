package Main.Objects.Components.Physics;

import Main.Msc.Vector2;
import Main.Objects.Components.Component;
import Testing.Plattformer.Main3;

public class PhysicsBody extends Component {

    private boolean useGravity= true;
    private float mass=10;//kg
    private Vector2 velocity = new Vector2(0,0);
    private Vector2 force = new Vector2(0,0);
    private float frictionAmount = 1f;

    public boolean isUseGravity() {
        return useGravity;
    }

    public void setUseGravity(boolean useGravity) {
        this.useGravity = useGravity;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getForce() {
        return force;
    }

    public void setForce(Vector2 force) {
        this.force = force;
    }

    public float getFrictionAmount() {
        return frictionAmount;
    }

    public void setFrictionAmount(float frictionAmount) {
        this.frictionAmount = frictionAmount;
    }

    public void addForce(Vector2 direction, float force)
    {
        Vector2 direction1 = direction.multiply(force/100);
        setVelocity(getVelocity().add(direction1));
        //getParent().setPosition(getParent().getPosition().add(direction1));
    }

    float updateTimer = 0;

    @Override
    public void Update()
    {
        Main3.vel.setText(getVelocity().toString());
        if(useGravity)
        {
            Vector2 force = PhysicsWorld.getGravityAcceleration().multiply(mass);
            //System.out.println(force);
            setVelocity(getVelocity().add(force.devide(mass)));
        }

        getParent().setPosition(getParent().getPosition().add(getVelocity().multiply(getFrictionAmount())));

        //System.out.println(velocity);


    }



}
