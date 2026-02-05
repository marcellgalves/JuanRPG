package entities;

public class Character extends Entity{
    private int level;
    public Character(String name, int hp, int damage, int defense, int level) {
        super(name, hp, damage, defense);
        this.level = level;
    }

    public boolean leveledUp(){
        if (this.getXp() >= 0){
            this.level += 1;
            this.setXp(0);
            return true;
        }
        return false;
    }
}
