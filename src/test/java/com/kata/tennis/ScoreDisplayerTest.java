package com.kata.tennis;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Observable;

import static org.junit.Assert.assertEquals;

class ScoreDisplayerTest {

    @Test
    void updateCaseNoWinnerYet() {
        ScoreDisplayer scoreDisplayer = new ScoreDisplayer();
        Observable o = new Observable();
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        player1.setPoints(2);
        player2.setPoints(1);
        Game game = new Game(player1, player2);
        game.addObserver(scoreDisplayer);
        // Redirect console output to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        scoreDisplayer.update(o, game);
        String consoleOutput = outputStream.toString();
        // Reset console output
        System.setOut(System.out);
        String expectedOutput = "A : 30   ||   B : 15";
        assertEquals(expectedOutput, consoleOutput.trim());
    }
    @Test
    void updateCasePlayer1Wins() {
        ScoreDisplayer scoreDisplayer = new ScoreDisplayer();
        Observable o = new Observable();
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        player1.setPoints(6);
        player2.setPoints(4);
        Game game = new Game(player1, player2);
        // Redirect console output to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        scoreDisplayer.update(o, game);
        String consoleOutput2 = outputStream.toString();
        // Reset console output
        System.setOut(System.out);
        String expectedOutput = "The winner is: A";
        assertEquals(expectedOutput, consoleOutput2.trim());
    }

    @Test
    void pointsToTennisScores() {
        ScoreDisplayer scoreDisplayer = new ScoreDisplayer();
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Game game = new Game(player1, player2);

        //case1
        game.getPlayer1().setPoints(2);
        game.getPlayer2().setPoints(1);
        assertEquals("30", scoreDisplayer.pointsToTennisScores(player1, player2));
        assertEquals("15", scoreDisplayer.pointsToTennisScores(player2, player1));

        //case2
        game.getPlayer1().setPoints(0);
        game.getPlayer2().setPoints(4);
        assertEquals("love", scoreDisplayer.pointsToTennisScores(player1, player2));
        assertEquals("40", scoreDisplayer.pointsToTennisScores(player2, player1));

        //case3 player1 has advantage
        game.getPlayer1().setPoints(5);
        game.getPlayer2().setPoints(4);
        assertEquals("A", scoreDisplayer.pointsToTennisScores(player1, player2));
        assertEquals("40", scoreDisplayer.pointsToTennisScores(player2, player1));

        //case4 player1 wins the game
        game.getPlayer1().setPoints(6);
        game.getPlayer2().setPoints(4);
        assertEquals("40", scoreDisplayer.pointsToTennisScores(player1, player2));
        assertEquals("40", scoreDisplayer.pointsToTennisScores(player2, player1));
    }
}