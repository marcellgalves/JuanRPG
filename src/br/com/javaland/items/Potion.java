package br.com.javaland.items;
import br.com.javaland.entities.Character;
public class Potion extends Item{
    public Potion(String name, int price) {
        super(name, price);
    }

    @Override
    public void usar(Character character) {
        character.setHp(character.getHp() + 20);
    }
}
