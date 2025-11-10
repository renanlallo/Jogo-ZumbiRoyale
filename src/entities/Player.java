package entities;

import state.PlayerState;

public class Player {
    private int health;
    private PlayerState state;

    public Player() {
        this.health = 2;
        this.state = PlayerState.HEALTHY;
    }

    public int getHealth() {
        return health;
    }

    public PlayerState getState() {
        return state;
    }

    public void takeDamage() {
        health--;
        if (health == 1) {
            state = PlayerState.INJURED;
        } else if (health <= 0) {
            state = PlayerState.INFECTED;
        }
    }

    public boolean isAlive() {
        return state != PlayerState.INFECTED;
    }

    public void heal() {
        if (state == PlayerState.INJURED) {
            health++;
            state = PlayerState.HEALTHY;
        }
    }

    @Override
    public String toString() {
        return "Jogador [Vida: " + health + ", Estado: " + state + "]";
    }
}