package com.kata.tennis;

/**
 * Represents a simulation of a simplified Tennis game (one game)
 */
public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Decides who wins a point
     */
    public void decideAPointWinner() {
        //to complete : proba?
    }

    /**
     * Decides if game is over, a player won
     * @return boolean true if game is over
     */
    public boolean gameOver() {
        return player1.winsGame(player2) || player2.winsGame(player1);
    }

    /**
     * Game loop
     */
    public void startGame() {
        //to do
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

}
