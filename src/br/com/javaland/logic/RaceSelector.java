package br.com.javaland.logic;

import java.util.Arrays;
import java.util.List;

public class RaceSelector {
    private final List<Race> races = Arrays.asList(
            new Race("Humano", 100, 15, 10, 20),
            new Race("Anão", 150, 12, 5, 15),
            new Race("Elfo", 80, 20, 15, 25),
            new Race("Orc", 130, 18, 7, 10)
    );

    public void showRaces(){
        System.out.println("--- ESCOLHA SUA RAÇA ---");
        for (int i = 0; i < races.size(); i++){
            Race r = races.get(i); // Busca a raça pela posição
            System.out.printf("%d. %-10s [HP: %d | DMG: %d | LUCK: %d]%n",
                    (i + 1), r.getName(), r.getHpBonus(), r.getDamageBonus(), r.getLuckBonus());
        }
    }

    public Race getRace(int index) {
        if (index >= 1 && index <= races.size()) {
            return races.get(index - 1);
        }
        return races.get(0);
    }
}
