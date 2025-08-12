/***
 * athour :gholamreza maleki
 * date:3/15/2024
 * TETRIS GAME
 */


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        cls();
        System.out.println("\n");
        System.out.println("\u001B[33m\t\t\t\t\t\t\tTETRIS GAME :)\u001B");

        Screen screen = new Screen();
        Scanner scanner = new Scanner(System.in);

        helpgame(scanner);
        setup();
        Timer timer = new Timer();
        timer.start();

        while (!gameOver) {

            screen.score();
            screen.drawScreen();

            screen.printScore();
            char ch = scanner.next().charAt(0);
            if (ch == 'w' || ch == 'W') {
                screen.mover(ch);
                screen.mover(ch);

            }
            screen.mover(ch);
            screen.moveDown();
            screen.floor();
            boolean bool = screen.gameOverChecker();
            char answer;
            if (bool) {
                System.out.println("the game was finished,do you want to play again(y/n)");
                answer = scanner.next().charAt(0);
                if (answer == 'n') {
                    gameOver = true;

                }
                if (answer == 'y') {
                    screen.setCounter(0);
                    screen.setScore(0);
                }
            }

            if (screen.restartGame()) {
                screen.setCounter(0);
            }

            cls();

            int minutes = timer.getTime();
            System.out.println("Time played: " + minutes + " minutes");

        }


    }

    public static boolean gameOver;

    public static void setup() {

        gameOver = false;
    }

    //this methode cls my screen
    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

            // Now your console is cleared
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    //this methode prints the help rules for users
    public static void helpgame(Scanner scanner) {
        String playerName;
        System.out.println(" pplease enter your name");
        playerName = scanner.next();
        System.out.println("\nHi " + playerName);
        System.out.println("This is a tetris game");
        System.out.println("\n");

        System.out.println("\t\t\t\tto go right use d");
        System.out.println("\t\t\t\tto go left use a");
        System.out.println("\t\t\t\tto go down use s");
        System.out.println("\t\t\t\tto rotate your shape use w (you can rotate your shape before the start and after that)");
        System.out.println("\n\n\n\n");
        System.out.println("enter a charactor to start the game");
        scanner.next().charAt(0);
    }


}