package com.kata.tennis;

import java.util.Observable;
import java.util.Random;

/**
 * Represents a simulation of a simplified Tennis game (one game)
 *
 */
public class Game extends Observable{
    private Player player1;
    private Player player2;

    /**
     *
     * @param player1
     * @param player2
     */
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    /**
     * Decide who wins the point
     * @param probaPlayer1WinsPoint the probability of player 1 winning the point
     * @return
     */
    public Player decideAPointWinner(double probaPlayer1WinsPoint) {
        Random rng = new Random();
        Player winner = player1;
        if (rng.nextDouble() >= probaPlayer1WinsPoint) {
            winner = player2;
        }
        return winner;
    }

    /**
     * Decides if game is over, a player won
     *
     * @return boolean true if game is over
     */
    public boolean gameOver() {
        return player1.winsGame(player2) || player2.winsGame(player1);
    }

    /**
     * Returns the winner
     * @param player1
     * @param player2
     * @return the winner of the game
     */
    public Player getGameWinner(Player player1, Player player2) {
        if (player1.winsGame(player2)){
            return player1;
        }
        return player2;
    }


    /**
     * Game loop
     * @param probaPlayer1WinsPoint the probability of player 1 winning the point
     */
    public void startGame(double probaPlayer1WinsPoint) {
        while (!gameOver()) {
            Player winner = decideAPointWinner(probaPlayer1WinsPoint);
            winner.winsPoint();
            setChanged();
            notifyObservers(this);
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
