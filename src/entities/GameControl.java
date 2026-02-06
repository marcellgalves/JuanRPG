package entities;


import java.util.Scanner;

public class GameControl {
    Scanner scanner = new Scanner(System.in);
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
        gameFunctions.clearConsole();
        System.out.print(  "Qual é o seu " + "NOME" + ", viajante? ");
        String characterName = scanner.nextLine();
        gameFunctions.esperar(1500);
        this.character = new Character(characterName, 50, 10, 5, 1, 20, 50);
        System.out.println("\nBem-vindo, " + characterName + "! Seus atributos iniciais foram definidos.");
    }
    public void mainLoop(){
        boolean leave = false;

        while (character.isAlive() || !leave){
            gameFunctions.esperar(2000);
            gameFunctions.clearConsole();
            System.out.println("---------- ÁREA DE EXPLORAÇÃO ----------");
            System.out.println("-- STATUS - " + "NAME: " + character.getName() + " - HP: " + character.getHp());
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





