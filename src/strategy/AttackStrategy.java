package strategy;

import entities.Weapon;
import entities.Zombie;

public interface AttackStrategy {
    boolean attack(Zombie zombie, Weapon weapon);
}