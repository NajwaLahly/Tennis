package com.kata.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class PlayerTest {

    @Test
    void winsPoint() {
        Player player = new Player();
        ArrayList<Integer> scoresList = new ArrayList<>(Arrays.asList(0, 1, 2));
        player.setPoints(2);
        player.setScoreList(scoresList);
        player.winsPoint();
        Assertions.assertEquals(3, player.getPoints());
        Assertions.assertEquals(3, player.getScoreList().get(3));
    }

    @Test
    void losesPoint() {
        Player player = new Player();
        ArrayList<Integer> scoresList = new ArrayList<>(Arrays.asList(0, 1, 2));
        player.setPoints(2);
        player.setScoreList(scoresList);
        player.losesPoint();
        Assertions.assertEquals(2, player.getPoints());
        Assertions.assertEquals(2, player.getScoreList().get(3));
    }

    @Test
    void hasAdvantage() {
        Player player1 = new Player();
        Player player2 = new Player();

        //case 1: player 1 has advantage
        player1.setPoints(5);
        player2.setPoints(4);
        Assertions.assertTrue(player1.hasAdvantage(player2));

        //case 2: player 1 doesn't have advantage (more than one point score difference)
        player1.setPoints(4);
        player2.setPoints(2);
        Assertions.assertFalse(player1.hasAdvantage(player2));

        //case 2: player 1 doesn't have advantage (player 2 scored less than 3)
        player1.setPoints(4);
        player2.setPoints(2);
        Assertions.assertFalse(player1.hasAdvantage(player2));
    }

    @Test
    void winsGame() {
        Player player1 = new Player();
        Player player2 = new Player();

        //case 1: player1 wins the game
        player1.setPoints(7);
        player2.setPoints(5);
        Assertions.assertTrue(player1.winsGame(player2));

        //case 2: player1 doesn't win the game (he scored less than 4 points)
        player1.setPoints(3);
        player2.setPoints(2);
        Assertions.assertFalse(player1.winsGame(player2));

        //case 2: player1 doesn't win the game (the score difference < 2)
        player1.setPoints(5);
        player2.setPoints(4);
        Assertions.assertFalse(player1.winsGame(player2));
    }
}