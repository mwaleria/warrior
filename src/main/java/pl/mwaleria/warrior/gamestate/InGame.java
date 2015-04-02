package pl.mwaleria.warrior.gamestate;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
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

    private MovableEntity testEntity;

    private TerrainEntity terrainEntity ;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        AnimationUtils.loadAllAnimation();
        //testEntity  = new Hero(10,10,50,50);

        testEntity = new HeroEntity(null,100,400,50,50);
        terrainEntity = new TerrainEntity(null,300,300,64,256);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        testEntity.render(gameContainer,stateBasedGame,graphics);
        terrainEntity.render(gameContainer,stateBasedGame,graphics);

        graphics.drawString("hero x = " + testEntity.getRectangle().getX() + " y = "+ testEntity.getRectangle().getY(), 500,500 );
        graphics.drawString("rock x = " + terrainEntity.getRectangle().getX() + " y = "+ terrainEntity.getRectangle().getY(), 500,550 );
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        testEntity.update(gameContainer,stateBasedGame,i);

        if(testEntity.intersects(terrainEntity)) {
            testEntity.undoMove();
            testEntity.setDy(0);
            //testEntity.setDx(0);
        }

      if(testEntity.isGravitational() && testEntity.getRectangle().getY() < 400) {
           testEntity.setDy(testEntity.getDy() + 0.03f);
      } else {
          testEntity.setDy(0);
      }


    }

    @Override
    public int getID() {
        return gameState.getId();
    }
}
