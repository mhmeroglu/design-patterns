package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class MonsterOld {
    protected String name;
    protected int health;
    protected int attackPower;
    protected Monster monster;

    public abstract void attack(Monster target);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower(){return attackPower;}

    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public Monster clone() throws CloneNotSupportedException {
        return (Monster) super.clone(); // Shallow copy for now
    }

    public static Monster createMonster(String type) {
        switch (type) {
            case "Goblin":
                return new Goblin();
            case "Dragon":
                return new Dragon();
            case "Elf":
                return new Elf();
            case "GrayWolf":
                return new GrayWolf(); // En güçlü canavar
            default:
                throw new IllegalArgumentException("Unknown monster type: " + type);
        }
    }

    private Random rand = new Random();
    private String[] monsters = {"Goblin", "Dragon", "GrayWolf", "Elf"};
    private List<Monster> availableMonsters = new ArrayList<>();

    public Monster getMonster() {
        if (availableMonsters.isEmpty()) {
            int choice = rand.nextInt(monsters.length);
            return MonsterFactory.createMonster(monsters[choice]);
        }
        return availableMonsters.remove(availableMonsters.size() - 1);
    }

    public void releaseMonster(Monster monster) {
        availableMonsters.add(monster);
    }


    public Monster cloneMonster() {
        try {
            return monster.clone(); // Deep copy using the Cloneable interface
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
