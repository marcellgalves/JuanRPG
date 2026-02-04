package application;

import entities.Character;
import entities.Enemy;
import entities.Entity;

public class Program {
    static void main(String[] args) {
        Entity mainCharacter = new Character("Juan", 100, 30, 10);
        Entity enemy = new Enemy("Goblin", 100, 15, 10);


    }
}
