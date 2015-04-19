package pl.mwaleria.warrior.game.entity;


import pl.mwaleria.warrior.game.World;

/**
 * Created by Marcin on 2015-04-02.
 */
public abstract class UnitEntity extends MovableEntity implements Hurtable {

    protected int hp;
    protected boolean alive;

    public UnitEntity(World world,float x, float y, float width, float height) {
        super(world, x, y, width, height);
    }



    public int getHp() {
        return hp;
    }


    public void setHp(int hp) {
        this.hp = hp;
    }


    public void takeDamage(int damage) {
        this.hp = this.hp - damage;
        if(this.hp <= 0 ) {
            this.alive = false;
        }
    }


    public boolean isAlive() {
        return alive;
    }


    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
