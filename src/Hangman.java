import java.util.Scanner;

public class Hangman {
    private final GameLogic logic;
    private final Player playerA;
    private final Player playerB;
    private Round currentRound;
    private int roundNumber;
    private int currentRoundNumber;

    public Hangman() {
        this.logic = new GameLogic();
        String nameA = logic.getUserName("A");
        String nameB = logic.getUserName("B");
        this.roundNumber = logic.getRoundNumber();

        this.playerA = new Player(nameA);
        this.playerB = new Player(nameB);

        this.currentRoundNumber = 1;
        this.currentRound = new Round(this.currentRoundNumber, this.playerA);
    }

    private boolean isGameOver() {
        return roundNumber == currentRoundNumber;
    }

    public void play() {
        this.logic.setInitialScreen();
        while (!isGameOver()) {
            currentRound.processRound();
            this.roundNumber++;
        }
        this.logic.closeScanner();
    }
}