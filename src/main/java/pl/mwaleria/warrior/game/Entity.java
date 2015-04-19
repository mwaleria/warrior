package pl.mwaleria.warrior.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Marcin on 2015-04-01.
 */
public abstract class Entity  {


    protected Rectangle rectangle;

    protected  EntityState entityState;

    /**World in which the entity exists */
    protected final World world;

    /**
     * Flag which tell us if entity is stand on ground
     */
    protected boolean standing;

    public Entity(final World world,final float x,final float y,final float width,final float height) {
        this.world =world;
        rectangle = new Rectangle(x,y,width,height);
        entityState = EntityState.MOVE_LEFT;
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

    public CollisionDirection checkCollision(final Entity other) {

            CollisionDirection collisionDirection = CollisionDirection.NONE;

        if (this.hasCommonPoints(this.getX(), this.getWidth(), other.getX(), other.getWidth()) &&
                this.isBetween(this.getY(), other.getY(), other.getYPlusHeight())) {
            collisionDirection = CollisionDirection.UP;
        } else if (this.hasCommonPoints(this.getX(), this.getWidth(), other.getX(), other.getWidth()) &&
                this.isBetween(this.getYPlusHeight(), other.getY(), other.getYPlusHeight())) {
            collisionDirection = CollisionDirection.DOWN;
        } else if (this.hasCommonPoints(this.getY(), this.getHeight(), other.getY(), other.getHeight()) &&
                this.isBetween(this.getXPlusWidth(), other.getX(), other.getXPlusWidth())) {
            collisionDirection = CollisionDirection.RIGHT;
        } else if (this.hasCommonPoints(this.getY(), this.getHeight(), other.getY(), other.getHeight()) &&
                this.isBetween(this.getX(), other.getX(), other.getXPlusWidth())) {
            collisionDirection = CollisionDirection.LEFT;
        }
        return collisionDirection;
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

    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("[Entity x=");
        sb.append(rectangle.getX());
        sb.append(", y=");
        sb.append(rectangle.getY());
        sb.append(", width=");
        sb.append(rectangle.getWidth());
        sb.append(", height=");
        sb.append(rectangle.getHeight());
        sb.append("]");
        return sb.toString();
    }

    protected boolean hasCommonPoints(final float x1, final float h1, final float x2, final float h2) {
        return (x1 >= x2 && x1 <= x2 + h2) || (x1 + h1 >= x2 && x1 + h1 <= x2 + h2) ||
                (x2 >= x1 && x2 <= x1 + h1) || (x2 + h2 >= x1 && x2 + h2 <= x1 + h1);
    }

    protected boolean isBetween(final float a, final float b, final float c) {
        return a >= b && a <= c;
    }
}
