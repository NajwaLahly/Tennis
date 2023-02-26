package com.kata.tennis;

import static com.kata.tennis.Constants.*;

/**
 * Represents a player
 */
public class Player {
    private String name;

    /**
     * number of points scored by the player
     */
    private int points = 0;

    /**
      * @param name name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Adds a point to the score whenever the player wins a game
     * Add the new score to the score list
     */
    public void winsPoint() {
        points++;
    }

    /**
     * @param otherPlayer
     * @return boolean true if the player wins an advantage
     */
    public boolean hasAdvantage(Player otherPlayer) {
        return (getPoints() >= MIN_POINTS_FOR_DEUCE) && (otherPlayer.getPoints() >= MIN_POINTS_FOR_DEUCE) && (getPoints() - otherPlayer.getPoints()) == POINT_DIFF_ADV;
    }

    /**
     * @param otherPlayer
     * @return boolean true if the player wins the game
     */
    public boolean winsGame(Player otherPlayer) {
        return (getPoints() >= MIN_POINTS_FOR_ADV) && (getPoints() - otherPlayer.getPoints() >= MIN_POINT_DIFF_TO_WIN);
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

