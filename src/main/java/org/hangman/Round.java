package org.hangman;

import java.util.Arrays;

public class Round {
    private final String wordToGuess;
    private final String wordToGuessType;
    private final GameLogic logic;
    private static final int CHANCES = 6;
    private int numberOfGuesses;
    private final char[] guessedWord;
    public boolean roundOver;

    public Round(){
        this.roundOver = false;
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
        System.out.println("Current guess: " + String.valueOf(guessedWord));
        System.out.println("You still have : " + (CHANCES - numberOfGuesses) + " chances.");
        System.out.println(logic.HANGMAN_FIGURE[numberOfGuesses]);
        System.out.print("Please Enter a guess (Hint: " + wordToGuessType + ") : ");
    }
    public void processRound() {
        while(!roundOver){
            setStepDisplay();
            char guess = logic.getLetter();
            processStep(guess);
        }
    }

    private void processStep(char guess) {
        boolean hit = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess && guessedWord[i] != guess) {
                guessedWord[i] = guess;
                hit = true;
            }
        }
        if (!hit) {
            numberOfGuesses++;
            System.out.println("\033[0;31mIncorrect Guess!\033[0m");
            if(numberOfGuesses == CHANCES) {
                System.out.println(logic.HANGMAN_FIGURE[numberOfGuesses]);
                System.out.println("\033[0;31mYou lost the game. The correct word is:  " + wordToGuess + "\033[0m");
                roundOver = true;
            }
        } else if (String.valueOf(guessedWord).equals(wordToGuess)) {
            System.out.println("\033[0;32mYou won the game! " + "\033[0m");
            roundOver = true;
        }
    }
}
