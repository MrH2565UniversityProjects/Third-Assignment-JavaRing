package org.project;

import org.project.entity.players.*;
import org.project.entity.enemies.*;
import org.project.location.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        List<Location> locations = new ArrayList<>();
        locations.add(new Location("Dark Forest"));
        locations.add(new Location("Ancient Ruins"));
        locations.add(new Location("Dragon's Lair"));

        System.out.println("Choose your character:");
        System.out.println("1. Knight ⚔️");
        System.out.println("2. Assassin 🗡️");
        System.out.println("3. Wizard 🧙‍♂️");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        Player player;

        switch (choice) {
            case 1 -> player = new Knight("Arthur");
            case 2 -> player = new Assassin("Shadow");
            case 3 -> player = new Wizard("Merlin");
            default -> {
                System.out.println("Invalid choice, defaulting to Knight.");
                player = new Knight("Arthur");
            }
        }

        System.out.println("\nWelcome, " + player.getName() + "! Let the adventure begin...\n");
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("Where would you like to go?");
            for (int i = 0; i < locations.size(); i++) {
                System.out.println((i + 1) + ". " + locations.get(i).getName());
            }
            System.out.println((locations.size() + 1) + ". Exit game");
            System.out.print("Enter your choice: ");

            int locationChoice = scanner.nextInt();
            if (locationChoice == locations.size() + 1) {
                System.out.println("Exiting game...");
                break;
            }

            if (locationChoice < 1 || locationChoice > locations.size()) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            Location selectedLocation = locations.get(locationChoice - 1);
            System.out.println("\nYou have arrived at " + selectedLocation.getName() + "!");

            Enemy enemy;
            int enemyType = random.nextInt(3);
            switch (enemyType) {
                case 0 -> enemy = new Goblin();
                case 1 -> enemy = new Dragon();
                case 2 -> enemy = new Skeleton();
                default -> throw new IllegalStateException("Unexpected value: " + enemyType);
            }

            System.out.println("A wild " + enemy.getName() + " appears!");

            while (player.isAlive() && enemy.isAlive()) {
                System.out.println("\nYour turn! Choose an action:");
                System.out.println("1. Attack");
                System.out.println("2. Defend (if available)");
                System.out.println("3. Use special ability (if available)");
                System.out.print("Enter choice: ");

                int action = scanner.nextInt();
                switch (action) {
                    case 1 -> player.attack(enemy);
                    case 2 -> player.useSpecialAbility(enemy);
                    default -> System.out.println("Invalid action. You wasted your turn!");
                }

                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }

            if (player.isAlive()) {
                System.out.println("You defeated the " + enemy.getName() + "!");
            } else {
                System.out.println("You were defeated! Game Over.");
                gameRunning = false;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
