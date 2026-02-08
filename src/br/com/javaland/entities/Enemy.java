package br.com.javaland.entities;


public class Enemy extends Entity {
    int enemyXp = getLevel() * 25;

    public Enemy(String name, int hp, int damage, int speed) {
        super(name, hp, damage, speed);
    }


}
