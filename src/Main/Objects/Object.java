package Main.Objects;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Main.Display.Map;
import Main.Msc.*;
import Main.Objects.Components.Collision.Collider;
import Main.Objects.Components.Collision.ScareCollider;
import Main.Objects.Components.Physics.PhysicsBody;
import Testing.Plattformer.Main3;

public class Object {

    private Sprite sprite;
    private Vector2 position=new Vector2(200,200);
    private Vector2 scale=new Vector2(100,100);
    private Vector2 direction = new Vector2(0,0);

    private boolean isColliding = false;

    private String tag="untagged";

    private float angle=180;

    ArrayList<Collider> colliders = new ArrayList<>();
    PhysicsBody physicsBody;


    private Animation animation;

    public Object(Vector2 position) {
        this.position = position;
        setScale(new Vector2(20,20));

        sprite = new Sprite();
        sprite.setPath("/spritesheet.png");
        sprite.loadSprite(new Vector2(0,0));
    }
    public Object(Vector2 position,String path) {
        this.position = position;
        setScale(new Vector2(20,20));
        sprite = new Sprite();
        sprite.setPath(path);
        sprite.loadSprite(new Vector2(0,0));

    }
    public Object() {
        sprite = new Sprite();
        setScale(new Vector2(100,100));

    }

    public boolean isColliding() {
        return isColliding;
    }

    public void setColliding(boolean colliding) {
        isColliding = colliding;
    }

    public void addCollider(Collider collider)
    {
        colliders.add(collider);
    }

    public void removeCollider(Collider collider)
    {
        colliders.remove(collider);
    }

    public void setPhysicsbody(PhysicsBody physicsBody)
    {
        this.physicsBody = (physicsBody);
    }

    public PhysicsBody getPhysicsbody()
    {
        return physicsBody;
    }

    public ArrayList<Collider> getColliders() {
        return colliders;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
        animation.setScale(scale);
        animation.setAngle(angle);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
        if(animation!=null)
            getAnimation().setAngle(angle);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

    public Vector2 getSpritePosition(){
        float x = (getPosition().getX()-((getScale().getX()/2)));
        float y = (getPosition().getY()-((getScale().getY()/2)));

        return new Vector2(x,y);
    }

    public Vector2 getScale() {
        return scale;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
        if(animation!=null)
            getAnimation().setScale(scale);
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position)
    {
        this.position = position;
    }

    public Vector2 movePosition(Vector2 position) {
         /*
        note that there is two similar function (setPosition) and (movePosition)
        the difference is that setPosition sets the position whiles move-position
        disposition with the velocity from the physicsbody
        */
        Vector2 dir = position.subtract(getPosition());

        if(physicsBody==null) {
            this.position = position;
        }
        else {
            for(Collider c : getColliders()) {
                if(!c.isTrigger()) {

                    Main3.dir.setText("My pos "+getPosition().toString()+" newpos "+position.toString()+" dir "+position.subtract(getPosition()));
                    Collider c2=null;


                    ScareCollider xcolider = (ScareCollider) c.copy();
                    xcolider.setPosition(getPosition().add(dir.removeX()));
                    if((ScareCollider.isCollision(xcolider,c,ObjectHandler.getObjects()))!=null) {
                        c2=ScareCollider.isCollision(xcolider,c,ObjectHandler.getObjects());
                        dir=(dir.removeY());
                        //b.setVelocity(b.getVelocity().removeY());

                    }

                    ScareCollider ycolider = (ScareCollider) c.copy();
                    ycolider.setPosition(getPosition().add(dir.removeY()));

                    if((ScareCollider.isCollision(ycolider,c,ObjectHandler.getObjects()))!=null) {
                        c2=ScareCollider.isCollision(ycolider,c,ObjectHandler.getObjects());
                        //getPhysicsbody().setVelocity(getDirection());
                        dir=(dir.removeX());
                    }
                    c.collisionHandler(c2);

                    setPosition(getPosition().add(dir));
                }
                else setPosition(position);
            }
        }
        return dir;
    }

    /**
     Returns the angle between object position and vector given
     **/
    public double LookAt(Vector2 toLookAt)
    {
        float b = position.getX()-toLookAt.getX();
        float a = position.getY()-toLookAt.getY();
        //a/b=tan v
        //System.out.println("a; "+a+"b: "+b);
        return(Math.toDegrees(Math.atan(a/b)));
    }

    public void Update()
    {
       // getInfoPanel().setLocation(new Point((int) (getPosition().getX()-100), (int) (getPosition().getY()-80)));
        //infoPanel.setData(this);
         //this.setHunger((this.getHunger()-0.01f));
    }
    public void UpdateComponents()
    {
        for(Collider collider : colliders)
        {
            collider.Update();
        }
        if(physicsBody!=null)
            getPhysicsbody().Update();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void onCollision(Object collision)
    {
        //setPosition(getPosition());
        //PhysicsBody b = getPhysicsbody();

    }

    public void onCollisionExit(Object collision)
    {

        setColliding(false);
    }


    public void onCollisionEnter(Object parent) {
        setColliding(true);

    }

    public void onTrigger(Object collision)
    {

    }



    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyDown(KeyEvent e) {
    }



    public BufferedImage Display()
    {
        if(animation!=null)
        {
            return animation.getAnimation();
        }
        else if (sprite.getSpriteImage()!=null)
        {
            return sprite.getSpriteImage();
        }
        else return null;
    }

    public void Destroy()
    {
        Map.delObjects.add(this);
    }

}

