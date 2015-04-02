package pl.mwaleria.warrior.gamestate;

/**
 * Created by Marcin on 2015-04-01.
 */
public enum GameStateID {

    IN_GAME(1);

    GameStateID(final int id) {
        this.id = id;
    }
    private final int id;

    public int getId() {
        return id;
    }
}
