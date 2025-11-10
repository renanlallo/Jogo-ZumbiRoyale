package factory;

import entities.Zombie;

public class ZombieFactory {

    public static Zombie createZombie() {
        return new Zombie(100);
    }
}