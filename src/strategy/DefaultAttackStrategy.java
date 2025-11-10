package strategy;

import entities.Weapon;
import entities.Zombie;
import java.util.Random;

public class DefaultAttackStrategy implements AttackStrategy {
    private Random random = new Random();

    @Override
    public boolean attack(Zombie zombie, Weapon weapon) {
        double chance = random.nextDouble();
        if (chance <= weapon.getAccuracy()) {
            zombie.takeDamage(weapon.getDamage());
            System.out.println("Ataque acertou! Zumbi perdeu " + weapon.getDamage() + " de vida.");
            return true;
        } else {
            System.out.println("Ataque errou!");
            return false;
        }
    }
}