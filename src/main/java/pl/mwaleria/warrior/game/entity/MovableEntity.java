package pl.mwaleria.warrior.game.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import pl.mwaleria.warrior.game.Entity;
import pl.mwaleria.warrior.game.Gravity;
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

    /**Horizontal speed of entity */
    protected float horizontalMoveSpeed;

    /**Vertical speed of entity */
    protected float verticalMoveSpeed;



    protected float jumpSpeed;

    private MoveStrategy moveStrategy;

    public MovableEntity(final World world, final float x, final float y, final float width, final float height) {
        super(world,x, y,  width,height);
        moveStrategy = new LandUnitMoveStrategy(this, new Gravity(0.01f));

    }


    public void move() {
        moveStrategy.move();
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

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        this.standing = false;
        super.update(gameContainer, stateBasedGame, i);
    }
}
