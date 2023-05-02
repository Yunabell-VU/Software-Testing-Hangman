public class Hangman {
    private final GameLogic logic;
    private final Player playerA;
    private final Player playerB;
    private Player playerToStart;
    private Round currentRound;
    private int totalRoundNumber;
    private int currentRoundNumber;

    public Hangman() {
        this.logic = new GameLogic();
        this.logic.setInitialScreen();

        String nameA = logic.getUserName("A");
        String nameB = logic.getUserName("B");
        this.totalRoundNumber = logic.getRoundNumber();

        this.playerA = new Player(nameA);
        this.playerB = new Player(nameB);
        this.playerToStart = playerA;

        this.currentRoundNumber = 1;
        this.currentRound = new Round(this.currentRoundNumber, playerToStart, playerA, playerB);
    }

    private boolean isGameOver() {
        return totalRoundNumber < currentRoundNumber;
    }

    public void play() {
        while (!isGameOver()) {
            currentRound.processRound();
            this.currentRoundNumber++;
            playerToStart = playerToStart.equals(playerA)? playerB : playerA;
            currentRound = new Round(currentRoundNumber,playerToStart, playerA, playerB);
        }
        System.out.println("\033[0;31mCurrent Score: " + playerA.name + " - " + playerA.getScore() + " : " + playerB.name + " - " + playerB.getScore() + "\033[0m" );
        if(playerA.getScore() > playerB.getScore()) {
            System.out.println("Player " + playerA.name + " won the game!!" );
        } else if(playerA.getScore() == playerB.getScore()) {
            System.out.println("The game is a draw!");
        } else {
            System.out.println("Player " + playerB.name + " won the game!!" );
        }
        this.logic.closeScanner();
    }
}