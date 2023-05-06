package org.hangman;

public class Hangman {
    private final GameLogic logic;
    private boolean gameover;

    public Hangman() {
        this.logic = new GameLogic();
        this.logic.setInitialScreen();
        this.gameover = false;
    }

    public void play() {
        while (!gameover) {
            Round round = new Round();
            round.processRound();
            System.out.println("Do you want to replay the game? Please enter y/n: ");
            gameover = !logic.getReplyResponse();
        }
        this.logic.closeScanner();
    }
}