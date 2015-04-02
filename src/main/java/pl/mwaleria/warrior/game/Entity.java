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

    public Entity(final World world,final float x,final float y,final float height,final float width) {
        this.world =world;
        rectangle = new Rectangle(x,y,height,width);
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
}
