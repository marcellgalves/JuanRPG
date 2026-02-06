package entities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FightLogic {
    GameFunctions gameFunctions = new GameFunctions();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private EnemyFactory factory = new EnemyFactory();


    public void showStatus(Entity entity) {
        gameFunctions.clearConsole();

        System.out.println("------ STATUS -----------------------------------------------------------------------------");
        System.out.println("Name: " + entity.getName());
        System.out.println("HP: " + entity.getHp());
        System.out.println("Damage: " + entity.getDamage());
        System.out.println("Level: " + entity.getLevel());
        System.out.println("-------------------------------------------------------------------------------------------");

    }
    private boolean oDestinoSorriu(Character character){
        int chanceTotal = character.getLuck() + character.getLuckBonus();

        if(chanceTotal > 100) chanceTotal = 100;

        int sorteio = random.nextInt(100) + 1;

        return sorteio <= chanceTotal;
    }


    public void lutaSelvagem(Character character, Enemy enemy) {
        System.out.println("Você encontrou um " + enemy.getName() + "!");
        gameFunctions.esperar(700);
        System.out.println("[" + character.getName().toUpperCase() + "]    VS    [" + enemy.getName().toUpperCase() + "]");
        while (enemy.getHp() > 0 && character.getHp() > 0) {
            System.out.println("✦ AÇÕES:    ✦ 1. LUTAR    ✦ 2. RÁPIDA EXAMINADA");
            String acao = scanner.nextLine();
            switch (acao) {
                case "1":
                    System.out.println(character.getName().toUpperCase() + " é CARA, e " + enemy.getName().toUpperCase() + " é COROA.");
                    gameFunctions.esperar(100);
                    System.out.println("Jogando a moeda do destino...");
                    if (oDestinoSorriu(character)){
                        System.out.println("COROA! Boa, você encontrou uma brecha!");
                        character.atack(enemy);
                        System.out.println("Dano causado: " + character.getDamage());
                        System.out.println("HP do adversário: " + enemy.getHp());
                        character.setLuckBonus(0);
                        gameFunctions.esperar(1300);
                        if (enemy.getHp() <= 0) {
                            System.out.println("O " + enemy.getName() + " caiu!");

                            int xpDoInimigo = (enemy.getDamage() * 3) + (enemy.getLevel() * 10);

                            character.setXp(character.getXp() + xpDoInimigo);
                            System.out.println("XP adquirido: " + xpDoInimigo);

                            if (character.leveledUp()) {
                                System.out.println("★ LEVEL UP! Você está mais perto de chegar ao topo... ou não. ★" );

                                character.setDamage(character.getDamage() + 2);
                                character.setMaxHp(character.getMaxHp() + 10);
                                character.setHp(character.getMaxHp());
                            }
                        }
                    } else {
                        System.out.println("COROA! Droga, " + enemy.getName() + " descobriu uma brecha!");
                        enemy.atack(character);
                        System.out.println("Dano recebido: " + enemy.getDamage());
                        System.out.println("Seu HP: " + character.getHp());
                        int novoBonus = character.getLuckBonus() + 15;
                        character.setLuckBonus(novoBonus);
                        System.out.println("Seu bônus de sorte agora é: +" + character.getLuckBonus() + "%");
                        gameFunctions.esperar(1800);




                    }
                    break;

                case "2":
                    showStatus(enemy);
                    gameFunctions.esperar(2500);
                    break;
            }
            System.out.println();


        }
    }
}