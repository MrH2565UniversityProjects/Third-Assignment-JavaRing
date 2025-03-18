package org.project.entity.players;

import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public class Wizard extends Player {
    public Wizard(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }
    public void castSpecialSpell(Enemy enemy) {
        int healAmount = 10;
        int damageAmount = 15;
        this.heal(healAmount);
        enemy.takeDamage(damageAmount);
        System.out.println(this.getName() + " casts a powerful spell!");
        System.out.println(this.getName() + " heals for " + healAmount + " HP!");
        System.out.println(enemy.getName() + " takes " + damageAmount + " damage!");
    }
}
