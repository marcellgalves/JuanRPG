package entities;


import java.util.Scanner;

public class GameControl {
    Scanner scanner = new Scanner(System.in);
    Race raca;
    RaceSelector raceSelector = new RaceSelector();
    EnemyFactory factory = new EnemyFactory();
    GameFunctions gameFunctions = new GameFunctions();
    FightLogic fightLogic = new FightLogic();
    private Character character;

    public void start(){
        gameIntroduction();
        characterConfig();
        mainLoop();
    }


    public void gameIntroduction(){
        System.out.println("========================================");
        System.out.println("       AS CRÔNICAS DE JAVA-LAND        " );
        System.out.println("========================================");
        System.out.println("O reino está em perigo e precisamos de um herói.");
        System.out.println();
        gameFunctions.esperar(4000);

    }
    public void characterConfig(){
        raceSelector.showRaces();
        System.out.print("Qual é a sua linhagem, herói? ");
        String input = scanner.nextLine();

        int index;
        try {
            index = Integer.parseInt(input) - 1;
            raca = raceSelector.getRace(index + 1);
        } catch (Exception e) {
            raca = raceSelector.getRace(1);
        }
        gameFunctions.clearConsole();
        System.out.print( "E o seu NOME, viajante? ");
        String characterName = scanner.nextLine();
        character = new Character(characterName, 10, 1, 5, 1, 20, 10);
        gameFunctions.esperar(1500);
        character.setMaxHp(character.getMaxHp() + raca.getHpBonus());
        character.setHp(character.getMaxHp());
        character.setDamage(character.getDamage() + raca.getDamageBonus());
        character.setSpeed(character.getSpeed() + raca.getSpeedBonus());
        character.setLuck(character.getLuck() + raca.getLuckBonus());
        System.out.println("\nBem-vindo, " + characterName + "! Seus atributos iniciais foram definidos.");
    }
    public void mainLoop(){
        boolean leave = false;

        while (character.isAlive() || !leave){
            gameFunctions.esperar(2000);
            gameFunctions.clearConsole();
            System.out.println("---------- ÁREA DE EXPLORAÇÃO ----------");
            System.out.println("-- STATUS - "+ "RACE: " + raca.getName() + " - NAME: " + character.getName() + " - HP: " + character.getHp());
            System.out.println("===========================================");
            System.out.println("1. LUTAR");
            System.out.println("2. STATUS");
            System.out.println("3. SAIR");
            System.out.println();
            String choise = scanner.nextLine();
            switch (choise){
                case "1":
                    gameFunctions.clearConsole();
                    fightLogic.lutaSelvagem(character, factory.createRandomEnemy(character.getLevel()));
                    break;
                case "2":
                    fightLogic.showStatus(character);
                    gameFunctions.esperar(2000);
                    break;

                case "3":
                    System.out.println("Salvando o progresso e saindo. ");
                    leave = true;
                    gameFunctions.clearConsole();
                    gameFunctions.esperar(2000);

                    break;

            }



        }

    }









    }





