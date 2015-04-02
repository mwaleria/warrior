package pl.mwaleria.warrior.game.entity;

/**
 * Created by Marcin on 2015-04-02.
 */
public class JumpSkill extends UnitSkill {

    public JumpSkill(UnitEntity entity, long callback) {
        super(entity,callback);
    }

    @Override
    protected void executeAction() {
        this.entity.setDy(entity.getJumpSpeed());
    }

}
