package br.com.javaland.logic;

public class Race {
    private String name;
    private int hpBonus;
    private int damageBonus;
    private int speedBonus;
    private int luckBonus;

    public Race(String name, int hpBonus, int damageBonus, int speedBonus, int luckBonus) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.damageBonus = damageBonus;
        this.speedBonus = speedBonus;
        this.luckBonus = luckBonus;
    }


    public String getName() {
        return name;
    }
    public int getHpBonus() {
        return hpBonus;
    }
    public int getDamageBonus() {
        return damageBonus;
    }
    public int getSpeedBonus() {
        return speedBonus;
    }
    public int getLuckBonus() {
        return luckBonus;
    }
}
