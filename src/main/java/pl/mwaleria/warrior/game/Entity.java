package pl.mwaleria.warrior.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Marcin on 2015-04-01.
 */
public abstract class Entity  {


    protected Rectangle rectangle;

    protected  EntityState entityState;

    protected Line downLine;

    /**World in which the entity exists */
    protected final World world;

    public Entity(final World world,final float x,final float y,final float width,final float height) {
        this.world =world;
        rectangle = new Rectangle(x,y,width,height);
        entityState = EntityState.MOVE_LEFT;
        downLine = new Line(0,0,0,0);
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public boolean intersects(final Entity entity) {
        return this.rectangle.intersects(entity.getRectangle());
    }

    public abstract Animation getAnimation();



    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        getAnimation().draw(rectangle.getX(),rectangle.getY());
    }


    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    public float getX() {
        return rectangle.getX();
    }
    public float getY() {
        return rectangle.getY();
    }

    public void setX(float x){
        this.rectangle.setX(x);
    }

    public void setY(float y){
        this.rectangle.setY(y);
    }

    public float getWidth() {
        return this.rectangle.getWidth();
    }

    public float getHeight() {
        return this.rectangle.getHeight();
    }

    public Line getDownLine(){
        this.downLine.set(rectangle.getX(),rectangle.getY() +rectangle.getHeight(),rectangle.getX() + rectangle.getWidth(),rectangle.getY() +rectangle.getHeight());
        return downLine;
    }

    public CollisionDirection checkCollision(final Entity other) {
        if(this.intersects(other)) {
            if(this.getYPlusHeight() > other.getY()) {
                return CollisionDirection.DOWN;
            }
            if(this.getY() < other.getYPlusHeight()) {
                return CollisionDirection.UP;
            }
            if(this.getX() < other.getXPlusWidth()) {
                return CollisionDirection.LEFT;
            }
            if( this.getXPlusWidth() > other.getX()) {
                return CollisionDirection.RIGHT;
            }
        }


        return CollisionDirection.NONE;
    }

    public float getXPlusWidth() {
        return this.rectangle.getX() + this.getRectangle().getWidth();
    }

    public float getYPlusHeight() {
        return this.rectangle.getY() + this.getRectangle().getHeight();
    }

    public void collisionAction(final Entity other, final CollisionDirection direction) {
        //do nothing from default
    }
}
