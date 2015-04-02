package pl.mwaleria.warrior.game.entity;

/**
 * Created by Marcin on 2015-04-02.
 */
public abstract class UnitSkill {

    /** The callback time in the next execution can be run */
    protected long callback;

    protected long lastRun;

    protected final UnitEntity entity;

    public UnitSkill(UnitEntity entity, long callback) {
        this.entity = entity;
        lastRun = 0;
        this.callback = callback;
    }

    public void execute(long timeOrWhatever) {
        if(timeOrWhatever > lastRun + callback) {
            executeAction();
            lastRun = timeOrWhatever;
        }

    }

    protected abstract void executeAction() ;


}
