package com.kata.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void decideAPointWinner() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Game game = new Game(player1, player2);

        //case 1: player 1 wins the point for sure
        Assertions.assertEquals(player1, game.decideAPointWinner(1));

        //case 1: player 2 wins the point for sure
        Assertions.assertEquals(player2, game.decideAPointWinner(0));
    }

    @Test
    void gameOver() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Game game = new Game(player1, player2);

        //case 1: Game is Over player 1 won
        player1.setPoints(4);
        player2.setPoints(2);
        Assertions.assertTrue(game.gameOver());

        //case 2: Game isn't Over yet
        player1.setPoints(5);
        player2.setPoints(6);
        Assertions.assertFalse(game.gameOver());
    }

    @Test
    void startGame() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Game game1 = new Game(player1, player2);

        //case 1: Player 1 wins the game for sure
        game1.startGame(1);
        Assertions.assertTrue(player1.winsGame(player2));
        Assertions.assertEquals(0, player2.getPoints());
        Assertions.assertEquals(4, player1.getPoints());

        //case 1: Player 2 wins the game for sure
        Player player3 = new Player("A");
        Player player4 = new Player("B");
        Game game2 = new Game(player3, player4);
        game2.startGame(0.0);
        Assertions.assertTrue(player4.winsGame(player3));
        Assertions.assertEquals(0, player3.getPoints());
        Assertions.assertEquals(4, player4.getPoints());
    }

    @Test
    void getGameWinner() {
        //case 1: Player 1 wins the game for sure
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Game game1 = new Game(player1, player2);
        game1.startGame(1);
        Assertions.assertEquals(player1, game1.getGameWinner(player1, player2));

        //case 1: Player 2 wins the game for sure
        Player player3 = new Player("A");
        Player player4 = new Player("B");
        Game game2 = new Game(player3, player4);
        game2.startGame(0.0);
        Assertions.assertEquals(player4, game1.getGameWinner(player3, player4));
    }
}