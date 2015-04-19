package pl.mwaleria.warrior.game.entity;

import pl.mwaleria.warrior.game.Gravity;

/**
 * @author <a href="mailto:Walerianczyk.Marcin@gmail.com">Marcin Walerianczyk</a>
 */
public class LandUnitMoveStrategy implements MoveStrategy {

    private final Gravity localGravity;

    private final MovableEntity movableEntity;

    public LandUnitMoveStrategy(final MovableEntity unitEntity, final Gravity gravity) {
        this.movableEntity = unitEntity;
        this.localGravity = gravity;
    }

    public void move() {
        if (!movableEntity.isStanding()) {
            movableEntity.setDy(movableEntity.getDy() + localGravity.getGravityAccelerate());
            System.out.println("standing = false");
        } else {
            System.out.println("standing = true");
        }
        movableEntity.setY(movableEntity.getY() + movableEntity.getDy());
        movableEntity.setX(movableEntity.getX() + movableEntity.getDx());
    }
}
