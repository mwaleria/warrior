package pl.mwaleria.warrior.game.entity;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import pl.mwaleria.warrior.game.Entity;
import pl.mwaleria.warrior.game.World;

/**
 * Class represents movable entities in game.
 * Examples of movable entities are :
 * Player
 * Enemy unit,
 * Bullet,
 * Some box.
 *
 * Created by mwaleria on 2015-04-02.
 */
public abstract class MovableEntity extends Entity {


    /** accelerate in x axis */
    protected float dx;

    /** accelerate int y axis */
    protected  float dy;

    /** Vector which hold last move for undo action */
    private Vector2f lastMove;

    /**Is gravity action on this entity*/
    protected boolean gravitational;

    /**Horizontal speed of entity */
    protected float horizontalMoveSpeed;

    /**Vertical speed of entity */
    protected float verticalMoveSpeed;

    /**Flag which tell us if entity is stand on ground */
    protected boolean standing;

    protected float jumpSpeed;

    public MovableEntity(final World world,final float x,final float y,final float width,final float height, final boolean gravitional) {
        super(world,x, y,  width,height);
        this.gravitational = gravitional;
        lastMove = new Vector2f();
    }


    public void move() {
        lastMove.set(dx,dy);
        this.rectangle.setX(this.rectangle.getX() + this.dx);
        this.rectangle.setY(this.rectangle.getY() + this.dy);
    }

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public void undoMove() {
        this.rectangle.setX(this.rectangle.getX() - lastMove.getX());
        this.rectangle.setY(this.rectangle.getY() - lastMove.getY());
    }

    public boolean isGravitational() {
        return gravitational;
    }

    public void setGravitational(final boolean gravitational) {
        this.gravitational = gravitational;
    }

    public float getJumpSpeed() {
        return jumpSpeed;
    }

    public void setJumpSpeed(float jumpSpeed) {
        this.jumpSpeed = jumpSpeed;
    }

    public boolean isStanding() {
        return standing;
    }

    public void setStanding(boolean standing) {
        this.standing = standing;
    }
}
