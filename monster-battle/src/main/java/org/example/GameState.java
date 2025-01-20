package org.example;

public class GameState {
    // Volatile keyword ensures visibility of changes across threads
    private static volatile GameState instance;
    private int score;

    // Private constructor to prevent instantiation
    private GameState() {
        score = 0; // Initial score set to 0
    }

    // Double-checked locking to ensure thread safety
    public static GameState getInstance() {
        if (instance == null) {
            synchronized (GameState.class) {
                if (instance == null) {
                    instance = new GameState();
                }
            }
        }
        return instance;
    }

    // Getter for score
    public int getScore() {
        return score;
    }

    // Method to increase score with protection against negative amounts
    public void increaseScore(int amount) {
        if (amount < 0) {
            score = Math.max(0, score + amount); // Prevent score from going below zero
        } else {
            score += amount;
        }
    }

    // Method to reset score
    public void resetScore() {
        score = 0;
    }
}
