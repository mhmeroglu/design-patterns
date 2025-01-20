package org.example;

public class BattleManager {
    public void battle(Monster monster1, Monster monster2) {
        while (monster1.getHealth() > 0 && monster2.getHealth() > 0) {
            monster1.attack(monster2);
            if (monster2.getHealth() <= 0) {
                System.out.println(monster2.getName() + " has been defeated!");
                break;
            }
            monster2.attack(monster1);
            if (monster1.getHealth() <= 0) {
                System.out.println(monster1.getName() + " has been defeated!");
            }
        }
    }
}


