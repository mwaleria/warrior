package pl.mwaleria.warrior.gamestate;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import pl.mwaleria.warrior.game.Entity;
import pl.mwaleria.warrior.game.entity.Hero;
import pl.mwaleria.warrior.game.entity.HeroEntity;
import pl.mwaleria.warrior.game.entity.MovableEntity;
import pl.mwaleria.warrior.game.entity.TerrainEntity;
import pl.mwaleria.warrior.util.AnimationUtils;

/**
 * Created by Marcin on 2015-04-01.
 */
public class InGame extends BasicGameState {

    private final GameStateID gameState = GameStateID.IN_GAME;

    private HeroEntity testEntity;

    private TerrainEntity terrainEntity ;
    private TerrainEntity terrainEntity2 ;


    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        AnimationUtils.loadAllAnimation();
        //testEntity  = new Hero(10,10,50,50);

        testEntity = new HeroEntity(null,100,400,47,67);
        terrainEntity = new TerrainEntity(null,300,300,256,64);
        terrainEntity2 = new TerrainEntity(null,0,500,1024,64);
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.white);
        terrainEntity.render(gameContainer,stateBasedGame,graphics);
        terrainEntity2.render(gameContainer,stateBasedGame,graphics);
        testEntity.render(gameContainer,stateBasedGame,graphics);
        graphics.drawString("mouse x = " + gameContainer.getInput().getMouseX() + "mouse y = " + gameContainer.getInput().getMouseY(), 500, 50);
        graphics.drawString("hero x = " + testEntity.getRectangle().getX() + " y = "+ testEntity.getRectangle().getY(), 500,100 );
        graphics.drawString("down col = "+ testEntity.isDownCollision(), 500,180 );
    }


    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {


        if(testEntity.isGravitational() && Float.compare(testEntity.getDy(),0.0f) != 0) {
            testEntity.setDy(testEntity.getDy() + 0.01f);
        }

        testEntity.update(gameContainer,stateBasedGame,i);

        testEntity.checkCollision(terrainEntity);
        testEntity.checkCollision(terrainEntity2);

    }

    @Override
    public int getID() {
        return gameState.getId();
    }
}
