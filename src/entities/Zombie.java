package entities;

public class Zombie {
    private int health;

    public Zombie(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Zumbi [Vida: " + health + "]";
    }
}