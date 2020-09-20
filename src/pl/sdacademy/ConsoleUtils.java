package pl.sdacademy;

import java.util.Scanner;

public class ConsoleUtils {
    public static boolean debugMode = false;


    public static final String C_RESET = "\u001B[0m";

    public static final String C_BLACK = "\u001B[30m";
    public static final String C_BLUE = "\u001B[34m";
    public static final String C_CYAN = "\u001B[36m";
    public static final String C_GREEN = "\u001B[32m";
    public static final String C_PURPLE = "\u001B[35m";
    public static final String C_RED = "\u001B[31m";
    public static final String C_WHITE = "\u001B[37m";
    public static final String C_YELLOW = "\u001B[33m";

    // Bold
    public static final String C_BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String C_BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String C_CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String C_GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String C_PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String C_RED_BOLD = "\033[1;31m";    // RED
    public static final String C_WHITE_BOLD = "\033[1;37m";  // WHITE
    public static final String C_YELLOW_BOLD = "\033[1;33m"; // YELLOW

    // Underline
    public static final String C_BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String C_BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String C_CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String C_GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String C_PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String C_RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String C_WHITE_UNDERLINED = "\033[4;37m";  // WHITE
    public static final String C_YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW

    public static final String C_BLACK_BACKGROUND = "\u001B[40m";
    public static final String C_BLUE_BACKGROUND = "\u001B[44m";
    public static final String C_CYAN_BACKGROUND = "\u001B[46m";
    public static final String C_GREEN_BACKGROUND = "\u001B[42m";
    public static final String C_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String C_RED_BACKGROUND = "\u001B[41m";
    public static final String C_WHITE_BACKGROUND = "\u001B[47m";
    public static final String C_YELLOW_BACKGROUND = "\u001B[43m";

    public static String c_purple(String message) {
        return C_PURPLE + message + C_RESET;
    }

    public static String c_red(String message) {
        return C_RED + message + C_RESET;
    }

    public static String promptForString(String prompt) {
        Scanner myObj = new Scanner(System.in);
        System.out.print(prompt);

        return myObj.nextLine();
    }

    public static int promptForInt(String prompt) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(prompt);

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Please provide correct number");
            } else {
                return scanner.nextInt();
            }
        } while(true);
    }

    public static void clearScreen() {
        // clear screen
        /*try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // just print 50 empty lines ...
        for (int i = 0; i< 50; i++) {
            System.out.println();
        }
    }

    public static void printDebug(String msg) {
        if (debugMode) {
            System.out.println("[DEBUG] " + msg);
        }
    }
}
