package pl.mwaleria.warrior.gamestate;

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

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        AnimationUtils.loadAllAnimation();
        //testEntity  = new Hero(10,10,50,50);

        testEntity = new HeroEntity(null,100,400,47,67);
        terrainEntity = new TerrainEntity(null,300,300,256,64);
        terrainEntity2 = new TerrainEntity(null,0,500,1024,64);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        terrainEntity.render(gameContainer,stateBasedGame,graphics);
        terrainEntity2.render(gameContainer,stateBasedGame,graphics);
        testEntity.render(gameContainer,stateBasedGame,graphics);
        graphics.drawString("mouse x = " + gameContainer.getInput().getMouseX() + "mouse y = " + gameContainer.getInput().getMouseY(), 500, 450);
        graphics.drawString("hero x = " + testEntity.getRectangle().getX() + " y = "+ testEntity.getRectangle().getY(), 500,500 );
        graphics.drawString("line = "+ lineToString(testEntity.getDownLine()), 50,540 );
        graphics.drawString("down col = "+ testEntity.isDownCollision(), 500,580 );
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {


        if(testEntity.isGravitational()) {
            testEntity.setDy(testEntity.getDy() + 0.01f);
        }

        testEntity.update(gameContainer,stateBasedGame,i);

        testEntity.collisionAction(terrainEntity,testEntity.checkCollision(terrainEntity));
        testEntity.collisionAction(terrainEntity2,testEntity.checkCollision(terrainEntity2));

    }

    @Override
    public int getID() {
        return gameState.getId();
    }

    private String lineToString(Line line) {
        return "Line [x1="+line.getX1() + " y1="+line.getY1() + " x2="+line.getX2()+" y2="+line.getY2();
    }
}
