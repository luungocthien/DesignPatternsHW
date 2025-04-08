package template_method;

import java.util.Random;

public class DiceGame extends Game {
    private int[] scores;
    private int numberOfPlayers;
    private int winningScore = 20;
    private int winner = -1;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        scores = new int[numberOfPlayers];
        System.out.println("Starting Dice Game with " + numberOfPlayers + " players.");
    }

    @Override
    public boolean endOfGame() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (scores[i] >= winningScore) {
                winner = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = random.nextInt(6) + 1;
        scores[player] += roll;
        System.out.println("Player " + player + " rolled a " + roll + ". Total score: " + scores[player]);
    }

    @Override
    public void displayWinner() {
        System.out.println("Player " + winner + " wins with " + scores[winner] + " points!");
    }
}

