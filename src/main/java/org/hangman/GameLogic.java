package org.hangman;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GameLogic {
    private final Scanner scan;
    private static final Puzzle[] DICTIONARY = {
            new Puzzle("animal","lion"),
            new Puzzle("animal","cat"),
            new Puzzle("fruit", "peach"),
            new Puzzle("fruit","apple"),
            new Puzzle("animal","tiger"),
            new Puzzle("computer peripheral","keyboard"),
            new Puzzle("programming language","python"),
            new Puzzle("city","amsterdam"),
            new Puzzle("country","france"),
            new Puzzle("colour","cyan")
    };
    public static final String[] HANGMAN_FIGURE = {
            "\033[0;31m _______\n|       |\n|\n|\n|\n|\n|\033[0m",
            "\033[0;31m _______\n|       |\n|       O\n|\n|\n|\n|\033[0m",
            "\033[0;31m _______\n|       |\n|       O\n|       |\n|\n|\n|\033[0m",
            "\033[0;31m _______\n|       |\n|       O\n|      /|\n|\n|\n|\033[0m",
            "\033[0;31m _______\n|       |\n|       O\n|      /|\\\n|\n|\n|\033[0m",
            "\033[0;31m _______\n|       |\n|       O\n|      /|\\\n|      /\n|\n|\033[0m",
            "\033[0;31m _______\n|       |\n|       O\n|      /|\\\n|      / \\\n|\n|\033[0m"
    };

    public GameLogic(){
        this.scan = new Scanner(System.in);
    }

    public Puzzle generatePuzzle() {
        return DICTIONARY[(int) (Math.random() * DICTIONARY.length)];
    }

    public boolean getReplyResponse() {
        String tmp;
        do {
            tmp = scan.nextLine();
            if ((!Pattern.compile("[a-zA-Z]{1}").matcher(tmp).matches())|| (tmp.charAt(0) != 'y' && tmp.charAt(0) != 'n' && tmp.charAt(0) != 'Y' && tmp.charAt(0) != 'N')) {
                System.out.println("Invalid input! Please enter 'y' or 'n': ");
            }
        } while (!Pattern.compile("[a-zA-Z]{1}").matcher(tmp).matches() || (tmp.charAt(0) != 'y' && tmp.charAt(0) != 'n' && tmp.charAt(0) != 'Y' && tmp.charAt(0) != 'N'));

        char letter = tmp.charAt(0);

        return letter == 'y' || letter == 'Y';
    }

    public char getLetter() {
        String tmp;
        do {
            tmp = scan.nextLine();
            if ((!Pattern.compile("[a-zA-Z]{1}").matcher(tmp).matches())) {
                System.out.println("Invalid input! Please enter a letter: ");
            }
        } while (!Pattern.compile("[a-zA-Z]{1}").matcher(tmp).matches());

        return tmp.toLowerCase().charAt(0);
    }

    public void closeScanner() {
        this.scan.close();
    }

    public void setInitialScreen() {
        clearScreen();
        printLogo();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
   private static void printLogo() {
        System.out.println(" ('-. .-.   ('-.         .-') _            _   .-')      ('-.         .-') _  ");
        System.out.println("( OO )  /  ( OO ).-.    ( OO ) )          ( '.( OO )_   ( OO ).-.    ( OO ) ) ");
        System.out.println(",--. ,--.  / . --. /,--./ ,--,'  ,----.    ,--.   ,--.) / . --. /,--./ ,--,'");
        System.out.println("|  | |  |  | \\-.  \\ |   \\ |  |\\ '  .-./-') |   `.'   |  | \\-.  \\ |   \\ |  |\\");
        System.out.println("|   .|  |.-'-'  |  ||    \\|  | )|  |_( O- )|         |.-'-'  |  ||    \\|  | )");
        System.out.println("|       | \\| |_.'  ||  .     |/ |  | .--, \\|  |'.'|  | \\| |_.'  ||  .     |/");
        System.out.println("|  .-.  |  |  .-.  ||  |\\    | (|  | '. (_/|  |   |  |  |  .-.  ||  |\\    |");
        System.out.println("|  | |  |  |  | |  ||  | \\   |  |  '--'  | |  |   |  |  |  | |  ||  | \\   |");
        System.out.println("`--' `--'  `--' `--'`--'  `--'   `------'  `--'   `--'  `--' `--'`--'  `--'");
    }
}
