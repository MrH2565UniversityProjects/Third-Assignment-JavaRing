package org.project.location;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private List<String> exits;
    private List<Enemy> enemies;

    public Location(String name) {
        this.name = name;
        this.exits = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public void addExit(String locationName) {
        exits.add(locationName);
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void resetLocation() {
        enemies.clear(); 
    }

    public String getName() {
        return name;
    }

    public List<String> getExits() {
        return exits;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
