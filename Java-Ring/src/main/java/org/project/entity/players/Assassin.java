package org.project.entity.players;

import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

class Assassin extends Player {
      public Assassin(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }
    private boolean isInvisible = false;
    private int invisibilityCooldown = 0;
    public void becomeInvisible() {
        if (invisibilityCooldown == 0) {
            isInvisible = true;
            invisibilityCooldown = 3;
            System.out.println(this.getName() + " vanishes into the shadows!");
        } else {
            System.out.println(this.getName() + " can't become invisible yet! Wait " + invisibilityCooldown + " more turns.");
        }
    }
    public void attack(Enemy enemy) {
        if (isInvisible) {
            int damage = this.getWeapon().getDamage() * 2;
            enemy.takeDamage(damage);
            System.out.println(this.getName() + " reappears and strikes with a deadly blow!");
            isInvisible = false;
        } else {
            this.attack(enemy);
        }
    }
    public void reduceCooldown() {
        if (invisibilityCooldown > 0) invisibilityCooldown--;
    }
}
