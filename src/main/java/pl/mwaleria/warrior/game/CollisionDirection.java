package pl.mwaleria.warrior.game;

/**
 * Created by Marcin on 2015-04-03.
 */
public enum CollisionDirection {

    LEFT,RIGHT,DOWN,UP,NONE;


    public CollisionDirection getOpositeDirection() {
        switch(this) {

            case LEFT:
                return RIGHT;

            case RIGHT:
                return LEFT;

            case DOWN:
                return UP;

            case UP:
                return DOWN;

            case NONE:
                return NONE;

        }
        return NONE;
    }


}
