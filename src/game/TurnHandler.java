package game;

import entities.Player;
import entities.Weapon;
import entities.Zombie;
import strategy.AttackStrategy;
import strategy.DefaultAttackStrategy;

import java.util.Random;

public class TurnHandler {
    private GameManager gameManager = GameManager.getInstance();
    private AttackStrategy attackStrategy = new DefaultAttackStrategy();
    private Random random = new Random();
    private double zombieCounterChance = 0.5;

    public void attack(Weapon weapon) {
        Zombie zombie = gameManager.getZombie();
        Player player = gameManager.getPlayer();

        boolean hit = attackStrategy.attack(zombie, weapon);

        if (hit) {
            System.out.println("Você acertou o ataque!");
            if (random.nextDouble() <= zombieCounterChance) {
                System.out.println("Zumbi tentou contra-atacar...");
                applyZombieAttack(player);
            } else {
                System.out.println("Zumbi errou o ataque!");
            }
        } else {
            System.out.println("Você errou! Zumbi contra-ataca com certeza!");
            applyZombieAttack(player);
        }

        zombieCounterChance = 0.5;
        checkGameStatus();
    }

    public void flee() {
        System.out.println("Você fugiu! Chance de contra-ataque do zumbi reduzida no próximo turno.");
        zombieCounterChance = 0.2;
    }

    public void heal() {
        Player player = gameManager.getPlayer();
        if (player.getState().name().equals("INJURED")) {
            double chance = random.nextDouble();
            if (chance <= 0.6) {
                player.heal();
                System.out.println("Cura bem-sucedida! Você está saudável novamente.");
            } else {
                System.out.println("Cura falhou!");
            }
        } else {
            System.out.println("Você não precisa se curar agora.");
        }

        if (random.nextDouble() <= zombieCounterChance) {
            System.out.println("Zumbi tentou te atacar enquanto você se curava...");
            applyZombieAttack(player);
        } else {
            System.out.println("Zumbi errou o ataque!");
        }

        checkGameStatus();
    }

    private void applyZombieAttack(Player player) {
        player.takeDamage();
        System.out.println("Zumbi te acertou! Seu estado agora é: " + player.getState());
        if (player.getState().name().equals("INJURED")) {
            System.out.println("Cuidado! Se tomar mais um golpe, ficará infectado e perderá o jogo!");
        }
    }

    private void checkGameStatus() {
        Player player = gameManager.getPlayer();
        Zombie zombie = gameManager.getZombie();

        if (!player.isAlive()) {
            System.out.println("Você foi infectado! Fim de jogo.");
            gameManager.setGameOver(true);
        } else if (!zombie.isAlive()) {
            System.out.println("Zumbi derrotado! Você venceu!");
            gameManager.setGameOver(true);
        }
    }
}