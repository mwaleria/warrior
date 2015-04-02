package pl.mwaleria.warrior.game.entity;


import pl.mwaleria.warrior.game.World;

/**
 * Created by Marcin on 2015-04-02.
 */
public abstract class UnitEntity extends MovableEntity implements Hurtable {

    protected int hp;
    protected boolean alive;

    public UnitEntity(World world,float x, float y, float height, float width) {
        super(world,x, y, height, width, true);
    }


    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void takeDamage(int damage) {
        this.hp = this.hp - damage;
        if(this.hp <= 0 ) {
            this.alive = false;
        }
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
