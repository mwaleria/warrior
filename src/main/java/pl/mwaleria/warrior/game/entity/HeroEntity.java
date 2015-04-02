package pl.mwaleria.warrior.game.entity;

import com.google.common.collect.ImmutableMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import pl.mwaleria.warrior.game.EntityState;
import pl.mwaleria.warrior.game.World;

/**
 * Created by Marcin on 2015-04-02.
 */
public class HeroEntity extends UnitEntity implements Controlable {

    private static Animation animation;



    private UnitSkill jumpSkill;

    public static void setAnimations(ImmutableMap<EntityState,Animation> animations) {
        HeroEntity.animations = animations;
    }

    private static ImmutableMap<EntityState,Animation> animations;

    public HeroEntity(final World world, final float x,final float y, final float height,final float width) {
        super(world,x, y, height, width);
        this.horizontalMoveSpeed = 0.5f;
        this.verticalMoveSpeed = 0.2f;
        this.jumpSpeed = -3.67f;
        this.jumpSkill = new JumpSkill(this,300);
    }

    @Override
    public Animation getAnimation() {
        return animations.get(entityState);
    }

    @Override
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
}
