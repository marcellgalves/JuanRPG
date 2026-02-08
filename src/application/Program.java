package application;


import br.com.javaland.entities.Character;
import br.com.javaland.logic.GameControl;

import java.util.Scanner;


public class Program {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameControl gameControl = new GameControl();


        gameControl.start();




        scanner.close();
    }
}
