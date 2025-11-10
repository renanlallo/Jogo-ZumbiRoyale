package game;

import entities.Player;
import entities.Zombie;

public class GameManager {
    private static GameManager instance;
    private Player player;
    private Zombie zombie;
    private boolean gameOver;

    private GameManager() {
        this.player = new Player();
        this.zombie = new Zombie(100);
        this.gameOver = false;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public Zombie getZombie() {
        return zombie;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}