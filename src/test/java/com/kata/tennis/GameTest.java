package com.kata.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void decideAPointWinner() {
        //to do
    }

    @Test
    void gameOver() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game(player1, player2);
        player1.setPoints(4);
        player2.setPoints(2);
        Assertions.assertTrue(game.gameOver());

        player1.setPoints(5);
        player2.setPoints(6);
        Assertions.assertFalse(game.gameOver());
    }

    @Test
    void startGame() {
        //to do
    }
}