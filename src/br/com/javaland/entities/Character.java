package br.com.javaland.entities;

import br.com.javaland.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Character extends Entity {
    List<Item> inventario = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    private int luck = 20;
    private int luckBonus = 0;
    private int level;
    private int xp;
    private int xpNecessario;
    private int gold;


    public Character(String name, int hp, int damage, int speed, int level, int luck, int maxHP) {
        super(name, hp, damage, speed);
        this.level = level;
        this.luck = luck;
        this.luckBonus = 0;
        this.xp = 0;
        this.gold = 0;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
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
    public void showInventory() {
        int option = -1;

        while (option != 0) {
            int x = 0;
            System.out.println("\n------ SEU INVENTÁRIO ------");

            if (inventario.isEmpty()) {
                System.out.println("[ Vazio ]");
                System.out.println("0. VOLTAR");
            } else {
                for (Item i : inventario) {
                    x += 1;
                    System.out.println(x + ". " + i.getName());
                }
                System.out.println("0. VOLTAR");
            }

            System.out.print("Escolha um item para usar: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option > 0 && option <= inventario.size()) {
                Item selecionado = inventario.get(option - 1);

                selecionado.usar(this);

                inventario.remove(option - 1);

                option = 0;
            } else if (option != 0) {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void useItemFlow(){
        showInventory();
        if (inventario.isEmpty()) return;
        System.out.print("Escolha o número do item para usar (ou 0 para voltar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= inventario.size()) {
            Item itemEscolhido = inventario.get(escolha - 1);

            itemEscolhido.usar();

            inventario.remove(itemEscolhido);
        }
    }

    public void addInventory(Item novoItem) {
        inventario.add(novoItem);
    }

    public void removeInventory(Item item) {
        inventario.remove(item);
    }

}
