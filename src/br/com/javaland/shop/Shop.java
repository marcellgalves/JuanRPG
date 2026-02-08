package br.com.javaland.shop;
import br.com.javaland.entities.Character;
import br.com.javaland.items.Item;
import br.com.javaland.items.Potion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    List<Item> itensDaLoja = new ArrayList<>(Arrays.asList(new Potion("Poção de HP", 20)));
    public void showShop(Character character){
        int option = -1;
        while(option != 0){
            System.out.println("================================");
            System.out.println("   LOJA DO MERCADOR CAÓTICO   ");
            System.out.println("================================");
            System.out.println("Seu Ouro: " + character.getGold() + "g");
            System.out.println("--------------------------------");
            int n = 1;
            for (Item item : itensDaLoja){
                System.out.println(n + ". --" + item.getName() + " (" + item.getPrice() + "g)");
                n += 1;
            }
            System.out.println("\n0. Sair");
            System.out.println("--------------------------------");
            System.out.println("Mercador: O que você deseja, infeliz?");
            System.out.print("> _");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 0){
                System.out.println("Mercador: Se não vai comprar nada, vaza. ");
            } else if (option > 0 && option <= itensDaLoja.size()) {
                 Item selecionado = itensDaLoja.get(option - 1);
                if (character.getGold() >= selecionado.getPrice()) {
                    character.setGold(character.getGold() - selecionado.getPrice());

                    character.addInventory(selecionado);

                    System.out.println("Mercador: Aqui está seu item. ");
                } else {
                    System.out.println("Mercador: Sem ouro, sem item, Idiota.");
                }
            } else {
                System.out.println("Mercador: Você é idiota? Escolha um item que eu tenha!");
            }
        }

    }
}

