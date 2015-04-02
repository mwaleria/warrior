package pl.mwaleria.warrior.game.entity;

/**
 * Created by Marcin on 2015-04-02.
 */
public interface Hurtable {

    public int getHp();
    public void setHp(int hp);
    public void takeDamage(int damage);
    public boolean isAlive();
    public void setAlive(boolean alive);
}
