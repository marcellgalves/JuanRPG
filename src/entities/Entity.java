package entities;

public class Entity {
    private String name;
    private int hp;
    private int damage;
    private int defense;
    private int level;
    private int xp;

    public Entity(String name, int hp, int damage, int defense) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.defense = defense;
        this.level = 1;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }

    public void receiveDamage(Entity target) {
        hp = (this.defense - target.damage) - this.hp;
    }
    public void atack(Entity target){
        int totalDamage = damage - target.defense;
        target.hp = target.hp - totalDamage;
    }
    public boolean isAlive(){
        return hp > 0;
    }

    public boolean leveledUp(){
        if (this.xp >= 0){
            this.level += 1;
            this.xp = 0;
            return true;
        }
        return false;
    }


}
