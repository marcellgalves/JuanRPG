package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyFactory {
    List<Enemy> tier1 = new ArrayList<>(Arrays.asList(
            new Enemy("Rato de Esgoto", 12, 4, 0),
            new Enemy("Morcego Cavernoso", 10, 5, 0),
            new Enemy("Goblin Aprendiz", 22, 6, 1),
            new Enemy("Cobra de Jardim", 15, 7, 0),
            new Enemy("Esqueleto Frágil", 18, 5, 2),
            new Enemy("Slime Azul", 25, 4, 1)
    ));
    List<Enemy> tier2 = new ArrayList<>(Arrays.asList(
            new Enemy("Orc Guerreiro", 50, 12, 4),
            new Enemy("Hobgoblin", 40, 15, 3),
            new Enemy("Lobo Atroz", 35, 18, 2),
            new Enemy("Aranha Gigante", 45, 14, 2),
            new Enemy("Bandido Veterano", 55, 13, 5),
            new Enemy("Zumbi Putrefato", 70, 10, 1)
    ));
    List<Enemy> tier3 = new ArrayList<>(Arrays.asList(
            new Enemy("Golem de Pedra", 120, 20, 15),
            new Enemy("Cavaleiro Negro", 90, 25, 12),
            new Enemy("Wyvern Novo", 80, 30, 8),
            new Enemy("Minotauro", 110, 28, 6),
            new Enemy("Espectro Sombrio", 60, 35, 5),
            new Enemy("Ogro Mutante", 150, 22, 4)
    ));

    public Enemy createRandomEnemy(int playerLevel){
        Random random = new Random();
        List<Enemy> selectedTier;

        if (playerLevel <= 5){
            selectedTier = tier1;
        } else if (playerLevel > 5 && playerLevel <= 15) {
            selectedTier = tier2;

        } else {
            selectedTier = tier3;
        }

        int index = selectedTier.size();
        Enemy template = selectedTier.get(index);

        return (new Enemy(template.getName(), template.getHp(), template.getDamage(), template.getDefense()));
    }
}
