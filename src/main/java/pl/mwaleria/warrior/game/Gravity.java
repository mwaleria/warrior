package pl.mwaleria.warrior.game;

/**
 * Created by Marcin on 2015-04-02.
 */
public class Gravity {

    private final float gravityAccelerate;

    public Gravity( final float gravityAccelerate) {
        this.gravityAccelerate = gravityAccelerate;
    }

    public float getGravityAccelerate() {
        return this.gravityAccelerate;
    }
}
