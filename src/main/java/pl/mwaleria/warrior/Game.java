package pl.mwaleria.warrior;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import pl.mwaleria.warrior.gamestate.InGame;

/**
 * A game using Slick2d
 */
public class Game extends StateBasedGame {

    /** Screen width */
    private static final int WIDTH = 800;
    /** Screen height */
    private static final int HEIGHT = 600;


    public Game() {
        super("A Slick2d game");

    }




    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new InGame());
    }
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.setForceExit(false);
        app.start();
    }

}
