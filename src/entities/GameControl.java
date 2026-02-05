package entities;

import java.util.Scanner;

public class GameControl {
    Scanner scanner = new Scanner(System.in);
    private Character character;
    private EnemyFactory factory = new EnemyFactory();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK  = "\u001B[30m";
    public static final String RED    = "\u001B[31m"; // Dano / Inimigos
    public static final String GREEN  = "\u001B[32m"; // Cura / Sucesso
    public static final String YELLOW = "\u001B[33m"; // Itens / Ouro / Alerta
    public static final String BLUE   = "\u001B[34m"; // Mana / Água
    public static final String PURPLE = "\u001B[35m"; // Magia / Bosses
    public static final String CYAN   = "\u001B[36m"; // Diálogos / Info
    public static final String WHITE  = "\u001B[37m";
    public static final String RED_BOLD    = "\033[1;31m";
    public static final String GREEN_BOLD  = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD   = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD   = "\033[1;36m";





    public void mainLoop(){
        boolean leave = false;

        while (character.isAlive() && !leave){
            esperar(2000);
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
                    clearConsole();

                    break;
                case "2":
                    showStatus();
                    esperar(2000);
                    break;

                case "3":
                    System.out.println("Salvando o progresso e saindo. ");
                    leave = true;
                    clearConsole();
                    esperar(2000);

                    break;

            }



        }

    }


    public void gameIntroduction(){
        System.out.println("========================================");
        System.out.println("       AS CRÔNICAS DE JAVA-LAND        " );
        System.out.println("========================================");
        System.out.println("O reino está em perigo e precisamos de um herói.");
        System.out.println();
        esperar(4000);

    }

    public void characterConfig(){
        clearConsole();
        System.out.print(  "Qual é o seu " + "NOME" + ", viajante? ");
        String characterName = scanner.nextLine();
        esperar(1500);
        this.character = new Character(characterName, 100, 10, 5, 1);
        System.out.println("\nBem-vindo, " + characterName + "! Seus atributos iniciais foram definidos.");
    }

    public void showStatus(){
        clearConsole();

        System.out.println("------ STATUS -----------------------------------------------------------------------------");
        System.out.println("Name: " + character.getName());
        System.out.println("HP: " + character.getHp());
        System.out.println("Damage: " + character.getDamage());
        System.out.println("Defense: " + character.getDefense());
        System.out.println("Level: " + character.getLevel());
        System.out.println("-------------------------------------------------------------------------------------------");

    }
    public void lutaSelvagem(){
        Enemy enemy = factory.createRandomEnemy(character.getLevel());
        System.out.println("Você encontrou um " + enemy.getName() + "!");
        esperar(700);
        System.out.println("[" + character.getName() + "]    VS    [" + enemy.getName().toUpperCase() + "]");
        while (enemy.getHp() != 0 || !character.isAlive()){
            System.out.println("        ✦ AÇÕES: \n     ✦ 1. LUTAR \n     ✦ 2. EXAMINAR");
            String acao = scanner.nextLine();
            switch (acao){
                case "1":
                    if (character.getSpeed() > enemy.getSpeed())
                        character.atack(enemy);
                    else enemy.atack(character);
            }
            System.out.println();
        }

    }

    public void start(){
        gameIntroduction();
        characterConfig();
        mainLoop();
    }
    public void clearConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    }
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
