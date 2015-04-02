package pl.mwaleria.warrior.game.entity;

import com.google.common.collect.ImmutableMap;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import pl.mwaleria.warrior.game.Entity;
import pl.mwaleria.warrior.game.EntityState;
import pl.mwaleria.warrior.game.World;

/**
 * Created by Marcin on 2015-04-01.
 */
public class Hero extends Entity {

    private static Animation animation;

    public static void setAnimations(ImmutableMap<EntityState,Animation> animations) {
        Hero.animations = animations;
    }

    private static ImmutableMap<EntityState,Animation> animations;

    public static void aa() {
        try {
            SpriteSheet ss = new SpriteSheet("sprites.png",47,67);
            Animation moveRight = new Animation();
            moveRight.addFrame(ss.getSprite(0, 2), 200);
            moveRight.addFrame(ss.getSprite(1, 2), 200);
            moveRight.addFrame(ss.getSprite(2, 2), 200);

            Animation moveLeft = new Animation();
            moveLeft.addFrame(ss.getSprite(0, 1), 200);
            moveLeft.addFrame(ss.getSprite(1, 1), 200);
            moveLeft.addFrame(ss.getSprite(2, 1), 200);

            Animation moveDown = new Animation();
            moveDown.addFrame(ss.getSprite(0, 0), 200);
            moveDown.addFrame(ss.getSprite(1, 0), 200);
            moveDown.addFrame(ss.getSprite(2, 0), 200);

            Animation moveUp = new Animation();
            moveUp.addFrame(ss.getSprite(0, 3), 200);
            moveUp.addFrame(ss.getSprite(1, 3), 200);
            moveUp.addFrame(ss.getSprite(2, 3), 200);

            animations = ImmutableMap.<EntityState,Animation>builder()
                    .put(EntityState.MOVE_DOWN, moveDown)
                    .put(EntityState.MOVE_LEFT,moveLeft)
                    .put(EntityState.MOVE_UP, moveUp)
                    .put(EntityState.MOVE_RIGHT , moveRight)
                    .build();


        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


    public Hero(World world , float x, float y, float height, float width) {

        super(world,x, y, height, width);
        aa();
    }

    @Override
    public Animation getAnimation() {
        return animations.get(entityState);
    }


    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        float speed = 0.3f;
        if(input.isKeyDown(Input.KEY_LEFT)) {
            entityState = EntityState.MOVE_LEFT;
            this.rectangle.setX(this.rectangle.getX() -speed);
        } else         if(input.isKeyDown(Input.KEY_RIGHT)) {
            entityState = EntityState.MOVE_RIGHT;
            this.rectangle.setX(this.rectangle.getX() + speed);
        } else         if(input.isKeyDown(Input.KEY_UP)) {
            entityState = EntityState.MOVE_UP;
            this.rectangle.setY(this.rectangle.getY() - speed);
        } else         if(input.isKeyDown(Input.KEY_DOWN)) {
            entityState = EntityState.MOVE_DOWN;
            this.rectangle.setY(this.rectangle.getY() + speed);
        }
    }

    public void update(Input input) {

    }
}
