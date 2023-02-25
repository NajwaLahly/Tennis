package com.kata.tennis;

import java.util.Observable;
import java.util.Observer;

public class ScoreDisplayer implements Observer {

    /**
     * Update score displayer
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Game) {
            Game game = (Game) arg;
            Player player1 = game.getPlayer1();
            Player player2 = game.getPlayer2();
            if(game.gameOver()) {
                System.out.println("The winner is : " + game.getGameWinner(player1, player2).getName());
            } else {
                System.out.println(player1.getName() + " : " + pointsToTennisScores(player1, player2) + "   ||   " +
                        player2.getName() + " : "  + pointsToTennisScores(player2, player1));
            }
        }
    }

    /**
     * converts points to real Tennis scores
     * @param player
     * @param otherPlayer
     * @return
     */
    public String pointsToTennisScores(Player player, Player otherPlayer) {
        int points = player.getPoints();
        switch (points) {
            case 0:
                return "love";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                if (player.hasAdvantage(otherPlayer)) {
                    return "A";
                } else if (player.winsGame(otherPlayer)) {
                    return "winner";
                }
                return "40";
        }
    }
}
