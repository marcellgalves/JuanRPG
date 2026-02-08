package br.com.javaland.logic;

import br.com.javaland.entities.Enemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyFactory {
    List<Enemy> tier1 = new ArrayList<>(Arrays.asList(
            new Enemy("Rato de Esgoto", 12, 4, 12),
            new Enemy("Morcego Cavernoso", 10, 5, 15),
            new Enemy("Goblin Aprendiz", 22, 6, 10),
            new Enemy("Cobra de Jardim", 15, 7, 11),
            new Enemy("Esqueleto Frágil", 18, 5, 6),
            new Enemy("Slime Azul", 25, 4, 5)
    ));

    List<Enemy> tier2 = new ArrayList<>(Arrays.asList(
            new Enemy("Orc Guerreiro", 50, 12, 8),
            new Enemy("Hobgoblin", 40, 15, 11),
            new Enemy("Lobo Atroz", 35, 18, 16),
            new Enemy("Aranha Gigante", 45, 14, 14),
            new Enemy("Bandido Veterano", 55, 13, 10),
            new Enemy("Zumbi Putrefato", 70, 10, 4)
    ));

    List<Enemy> tier3 = new ArrayList<>(Arrays.asList(
            new Enemy("Golem de Pedra", 120, 20, 3),
            new Enemy("Cavaleiro Negro", 90, 25, 9),
            new Enemy("Wyvern Novo", 80, 30, 18),
            new Enemy("Minotauro", 110, 28, 11),
            new Enemy("Espectro Sombrio", 60, 35, 15),
            new Enemy("Ogro Mutante", 150, 22, 7)
    ));

    public Enemy createRandomEnemy(int playerLevel){
        Random random = new Random();
        List<Enemy> selectedTier;

        if (playerLevel <= 5){
            selectedTier = tier1;
        } else if (playerLevel <= 15) {
            selectedTier = tier2;
        } else {
            selectedTier = tier3;
        }

        int selectedEnemyIndex = random.nextInt(selectedTier.size());
        Enemy template = selectedTier.get(selectedEnemyIndex);

        return (new Enemy(template.getName(), template.getHp(), template.getDamage(), template.getSpeed()));
    }
}
