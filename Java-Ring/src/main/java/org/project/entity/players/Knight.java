package org.project.entity.players;

import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

class Knight extends Player {
    public Knight(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }
    private int kickCooldown = 0;
    public void strongKick(Enemy enemy) {
        if (kickCooldown == 0) {
            int damage = this.getWeapon().getDamage() * 3;
            enemy.takeDamage(damage);
            System.out.println(this.getName() + " delivers a crushing kick!");
            kickCooldown = 4;
        } else {
            System.out.println(this.getName() + " can't use Strong Kick yet! Wait " + kickCooldown + " more turns.");
        }
    }
    public void reduceCooldown() {
        if (kickCooldown > 0) kickCooldown--;
    }
}
