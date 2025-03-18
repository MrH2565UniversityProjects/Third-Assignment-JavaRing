package org.project.entity.enemies;

import org.project.object.weapons.Weapon;

public class Dragon extends Enemy {
          public Dragon(String name,int hp, int mp, Weapon weapon) {
        super(name,hp, mp, weapon);
    }
    public Dragon() {
        this("Dragon",50,20,null);
    }
    
}
