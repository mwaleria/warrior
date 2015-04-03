package pl.mwaleria.warrior.game.entity;

import com.google.common.collect.ImmutableMap;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import pl.mwaleria.warrior.game.Entity;
import pl.mwaleria.warrior.game.EntityState;
import pl.mwaleria.warrior.game.World;

/**
 * Created by Marcin on 2015-04-02.
 */
public class TerrainEntity extends Entity {


    private Terrain terrain = Terrain.ROCK;

    private static final int TILES_64 = 64;

    private int countX;
    private int countY;

    public static void setImages(ImmutableMap<Terrain,Image> images) {
        TerrainEntity.images = images;
    }

    private static ImmutableMap<Terrain,Image> images;

    public TerrainEntity(World world, float x, float y, float width, float height) {
        super(world, x, y, width, height);
        if(height % TILES_64 != 0 || width% TILES_64 !=0) {
            throw new RuntimeException("invalid entity size, please use only 64s tiles");
        }
        countX =(int) width / TILES_64 ;
        countY =(int) height / TILES_64 ;

    }

    @Override
    public Animation getAnimation() {
        return null;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for(int i=0 ; i< countX ; i++) {
            images.get(terrain).draw(this.getX() + TILES_64 * i, this.getY());
        }
    }
}
