import java.util.Scanner;

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
            "\033[0;31m _______\n|       |\n|       O\n|      /|\\\n|      / \\\n|\n|\033[0m"
    };

    public GameLogic(){
        this.scan = new Scanner(System.in);
    };

    public Puzzle generatePuzzle() {
        return DICTIONARY[(int) (Math.random() * DICTIONARY.length)];
    }

    // TODO: Add input validation
    public String getUserName(String player) {
        System.out.println("Enter the name of Player " + player + " :");
        String name = this.scan.nextLine();
        System.out.println("You have set Player " + player + " : " + name);
        return name;
    }

    public void closeScanner() {
        this.scan.close();
    }

    // TODO: Add input validation
    public int getRoundNumber() {
        System.out.println("Enter the number of rounds you want to play: ");
        int number = this.scan.nextInt();
        System.out.println("You have set number of rounds to: " + number);
        return number;
    }

    // TODO: Add input validation
    public char getLetter() {
        char letter = scan.nextLine().charAt(0);
        return letter;
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
