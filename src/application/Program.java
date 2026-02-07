package application;


import entities.GameControl;

import java.util.Scanner;


public class Program {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameControl gameControl = new GameControl();

        gameControl.start();




        scanner.close();
    }
}
