package entities;

public class Character extends Entity{
    private int luck = 20;
    private int luckBonus = 0;
    private int level;
    private int xp;
    private int xpNecessario;

    public Character(String name, int hp, int damage, int speed, int level, int luck, int maxHP) {
        super(name, hp, damage, speed);
        this.level = level;
        this.luck = luck;
        this.luckBonus = 0;
        this.xp = 0;


    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getLuckBonus() {
        return luckBonus;
    }

    public void setLuckBonus(int luckBonus) {
        this.luckBonus = luckBonus;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getXp() {
        return xp;
    }
    public void setXp(int xp){
        this.xp = xp;
    }

    public void addXp(int xp) {
        this.xp += xp;
    }
    public Character(String name, int hp, int damage, int speed, int luck) {
        super(name, hp, damage, speed);
        this.luck = luck;
        this.luckBonus = 0;
    }

    public boolean leveledUp(){
        if (this.getXp() >= this.xpNecessario) {
            this.level += 1;
            this.setXp(this.getXp() - this.xpNecessario);
            this.xpNecessario *= 1.5;
            return true;
        }
        return false;
    }

}
