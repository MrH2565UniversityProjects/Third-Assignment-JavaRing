package org.project.entity.enemies;

import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public abstract class Enemy {
    Weapon weapon;
    private String name;
    private int hp;
    private int mp;

    public Enemy(String name,int hp, int mp, Weapon weapon) {
        this.hp = hp;
        this.mp = mp;
        this.name = name;
        this.weapon = weapon;
    }


    public void takeDamage(int damage) {
        hp -= damage;
    }

    public int getHp() {
        return hp;
    }
    public String getName(){
        return name;
    }
    public int getMp() {
        return mp;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
