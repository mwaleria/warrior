package pl.mwaleria.warrior.game.entity;

import com.google.common.collect.ImmutableMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import pl.mwaleria.warrior.game.CollisionDirection;
import pl.mwaleria.warrior.game.Entity;
import pl.mwaleria.warrior.game.EntityState;
import pl.mwaleria.warrior.game.World;

/**
 * Created by Marcin on 2015-04-02.
 */
public class HeroEntity extends UnitEntity implements Controlable {

    private UnitSkill jumpSkill;

    public static void setAnimations(ImmutableMap<EntityState,Animation> animations) {
        HeroEntity.animations = animations;
    }

    private static ImmutableMap<EntityState,Animation> animations;

    public HeroEntity(final World world, final float x,final float y,final float width, final float height) {
        super(world,x, y, width,  height);
        this.horizontalMoveSpeed = 0.5f;
        this.verticalMoveSpeed = 0.2f;
        this.jumpSpeed = -1.67f;
        this.jumpSkill = new JumpSkill(this,300);
    }

    @Override
    public Animation getAnimation() {
        return animations.get(entityState);
    }

    public void doControl(Input input, long delta) {

        dx = 0;
        if(input.isKeyDown(Input.KEY_LEFT)) {
            this.entityState = EntityState.MOVE_LEFT;
            this.dx = -this.horizontalMoveSpeed;
        } else if(input.isKeyDown(Input.KEY_RIGHT)) {
            this.entityState = EntityState.MOVE_RIGHT;
            this.dx = this.horizontalMoveSpeed;
        }
        if(input.isKeyDown(Input.KEY_SPACE)) {
            jumpSkill.execute(delta);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        this.doControl(gameContainer.getInput(),gameContainer.getTime());
        this.move();

    }

    @Override
    public void collisionAction(Entity other, CollisionDirection direction) {
        if(direction != CollisionDirection.NONE) {
            switch(direction) {
                case LEFT:
                    this.dx = 0;
                    this.setX(other.getXPlusWidth());
                    break;
                case RIGHT:
                    this.dx = 0;
                    this.setX(other.getX() - this.getWidth());
                    break;
                case DOWN:

                    this.dy = 0;
                    this.setY(other.getY() - this.getHeight() - 0.001f);
                    break;
                case UP:
                    this.dy = 0;
                    this.setY(other.getYPlusHeight() + 0.001f);
                    break;
            }
        }
    }
}
