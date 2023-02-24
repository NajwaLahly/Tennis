package com.kata.tennis;

import java.sql.SQLOutput;
import java.util.Random;

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
    public Player[] decideAPointWinner(double probaPlayer1WinsPoint) {
        Random ramdom = new Random();
        Player[] winnerLoser = new Player[]{player1, player2};
        if (ramdom.nextDouble() >= probaPlayer1WinsPoint) {
            winnerLoser[0] = player2;
            winnerLoser[1] = player1;
        }
        return winnerLoser;
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
     * Game loop
     */
    public void startGame(double probaPlayer1WinsPoint) {
        while (!gameOver()) {
            Player[] winnerLoser = decideAPointWinner(probaPlayer1WinsPoint);
            Player winner = winnerLoser[0];
            Player loser = winnerLoser[1];
            winner.winsPoint();
            loser.losesPoint();
        }
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
