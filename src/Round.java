import java.util.Arrays;

public class Round {
    private final int roundNumber;
    private final String wordToGuess;
    private final String wordToGuessType;
    private final GameLogic logic;
    private static final int CHANCES = 6;
    private int numberOfGuesses;
    private char[] guessedWord;
    private Player currentPlayer;
    private Player playerA;
    private Player playerB;
    public boolean roundOver;

    public Round(int roundNumber, Player currentPlayer, Player playerA, Player playerB){
        this.roundOver = false;
        this.roundNumber = roundNumber;
        this.currentPlayer = currentPlayer;
        this.playerA = playerA;
        this.playerB = playerB;
        this.numberOfGuesses = 0;

        this.logic = new GameLogic();
        Puzzle puzzle = logic.generatePuzzle();
        this.wordToGuessType = puzzle.type;
        this.wordToGuess = puzzle.word;

        this.guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');
    }

    private void setStepDisplay() {
        logic.clearScreen();
        System.out.println("Current round number: " + roundNumber);
        System.out.println("Current guess: " + String.valueOf(guessedWord));
        System.out.println("You still have : " + (CHANCES - numberOfGuesses) + " chances.");
        System.out.println(this.logic.HANGMAN_FIGURE[numberOfGuesses]);
        System.out.print(currentPlayer.name +  ", please Enter a guess (Hint: " + wordToGuessType + ") : ");
    }
    public void processRound() {
        while(!roundOver){
            setStepDisplay();
            char guess = logic.getLetter();
            processStep(guess);
            System.out.println("\033[0;31mCurrent Score: " + playerA.name + " - " + playerA.getScore() + " : " + playerB.name + " - " + playerB.getScore() + "\033[0m" );
        }
    }

    private void processStep(char guess) {
        boolean hit = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord[i] = guess;
                hit = true;
            }
        }
        if (!hit) {
            currentPlayer = currentPlayer.equals(playerA)? playerB : playerA;
            numberOfGuesses++;
            System.out.println("\033[0;31mIncorrect Guess!\033[0m");
            if(numberOfGuesses == CHANCES) {
                System.out.println("\033[0;31mRound Over! No Player won for Round  " + roundNumber + "\033[0m");
                roundOver = true;
            }
        } else if (String.valueOf(guessedWord).equals(wordToGuess)) {
            System.out.println("\033[0;32mPlayer " + currentPlayer.name + " won Round " + roundNumber + ". The word is " + wordToGuess + "\033[0m");
            currentPlayer.setScore(currentPlayer.getScore() + 1);
            roundOver = true;
        }
    }
}
