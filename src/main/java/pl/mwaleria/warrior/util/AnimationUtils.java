package pl.mwaleria.warrior.util;

import com.google.common.collect.ImmutableMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import pl.mwaleria.warrior.game.EntityState;
import pl.mwaleria.warrior.game.entity.Hero;
import pl.mwaleria.warrior.game.entity.HeroEntity;
import pl.mwaleria.warrior.game.entity.Terrain;
import pl.mwaleria.warrior.game.entity.TerrainEntity;

/**
 * Created by Marcin on 2015-04-02.
 */
public class AnimationUtils {
    /**private constructor for util class */
    private AnimationUtils() {}

    public static void loadAllAnimation(){
        loadHeroAnimations();
        loadTerianAnimations();

    }

    private static void loadHeroAnimations(){
        try {
            ImmutableMap<EntityState,Animation> animations;
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

            HeroEntity.setAnimations(animations);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private static void loadTerianAnimations() {
        ImmutableMap<Terrain,Image> images;
        SpriteSheet ss = null;
        try {
            ss = new SpriteSheet("world.png",64,64);
            images = ImmutableMap.<Terrain,Image>builder().put(Terrain.ROCK, ss.getSprite(0,0)).put(Terrain.GRASS,ss.getSprite(1,0)).build();
            TerrainEntity.setImages(images);
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }
}
