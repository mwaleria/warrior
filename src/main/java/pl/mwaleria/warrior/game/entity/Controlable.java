package pl.mwaleria.warrior.game.entity;

import org.newdawn.slick.Input;

/**
 * Created by Marcin on 2015-04-02.
 */
public interface Controlable {

    public void doControl(Input input,long delta);
}
