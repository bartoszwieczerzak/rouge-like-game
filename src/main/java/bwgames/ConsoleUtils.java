package bwgames;

import java.util.Formatter;
import java.util.Scanner;

public abstract class ConsoleUtils {
    public static boolean debugMode = false;
    public static boolean errorLoggingMode = true;


    public static final String C_RESET = "\u001B[0m";

    public static final String C_BLACK =  "\u001B[30m";
    public static final String C_RED =    "\u001B[31m";
    public static final String C_GREEN =  "\u001B[32m";
    public static final String C_YELLOW = "\u001B[33m";
    public static final String C_BLUE =   "\u001B[34m";
    public static final String C_PURPLE = "\u001B[35m";
    public static final String C_CYAN =   "\u001B[36m";
    public static final String C_WHITE =  "\u001B[37m";

    // Bold
    public static final String C_BLACK_BOLD =  "\033[1;30m";
    public static final String C_RED_BOLD =    "\033[1;31m";
    public static final String C_GREEN_BOLD =  "\033[1;32m";
    public static final String C_YELLOW_BOLD = "\033[1;33m";
    public static final String C_BLUE_BOLD =   "\033[1;34m";
    public static final String C_PURPLE_BOLD = "\033[1;35m";
    public static final String C_CYAN_BOLD =   "\033[1;36m";
    public static final String C_WHITE_BOLD =  "\033[1;37m";

    // Underline
    public static final String C_BLACK_UNDERLINED =  "\033[4;30m";
    public static final String C_RED_UNDERLINED =    "\033[4;31m";
    public static final String C_GREEN_UNDERLINED =  "\033[4;32m";
    public static final String C_YELLOW_UNDERLINED = "\033[4;33m";
    public static final String C_BLUE_UNDERLINED =   "\033[4;34m";
    public static final String C_PURPLE_UNDERLINED = "\033[4;35m";
    public static final String C_CYAN_UNDERLINED =   "\033[4;36m";
    public static final String C_WHITE_UNDERLINED =  "\033[4;37m";

    public static final String C_BLACK_BACKGROUND =  "\u001B[40m";
    public static final String C_RED_BACKGROUND =    "\u001B[41m";
    public static final String C_GREEN_BACKGROUND =  "\u001B[42m";
    public static final String C_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String C_BLUE_BACKGROUND =   "\u001B[44m";
    public static final String C_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String C_CYAN_BACKGROUND =   "\u001B[46m";
    public static final String C_WHITE_BACKGROUND =  "\u001B[47m";

    public static void testColors() {
        System.out.println(C_BLACK              + "C_BLACK"             + C_RESET);
        System.out.println(C_RED                + "C_RED"               + C_RESET);
        System.out.println(C_GREEN              + "C_GREEN"             + C_RESET);
        System.out.println(C_YELLOW             + "C_YELLOW"            + C_RESET);
        System.out.println(C_BLUE               + "C_BLUE"              + C_RESET);
        System.out.println(C_PURPLE             + "C_PURPLE"            + C_RESET);
        System.out.println(C_CYAN               + "C_CYAN"              + C_RESET);
        System.out.println(C_WHITE              + "C_WHITE"             + C_RESET);
        System.out.println(C_BLACK_BOLD         + "C_BLACK_BOLD"        + C_RESET);
        System.out.println(C_RED_BOLD           + "C_RED_BOLD"          + C_RESET);
        System.out.println(C_GREEN_BOLD         + "C_GREEN_BOLD"        + C_RESET);
        System.out.println(C_YELLOW_BOLD        + "C_YELLOW_BOLD"       + C_RESET);
        System.out.println(C_BLUE_BOLD          + "C_BLUE_BOLD"         + C_RESET);
        System.out.println(C_PURPLE_BOLD        + "C_PURPLE_BOLD"       + C_RESET);
        System.out.println(C_CYAN_BOLD          + "C_CYAN_BOLD"         + C_RESET);
        System.out.println(C_WHITE_BOLD         + "C_WHITE_BOLD"        + C_RESET);
        System.out.println(C_BLACK_UNDERLINED   + "C_BLACK_UNDERLINED"  + C_RESET);
        System.out.println(C_RED_UNDERLINED     + "C_RED_UNDERLINED"    + C_RESET);
        System.out.println(C_GREEN_UNDERLINED   + "C_GREEN_UNDERLINED"  + C_RESET);
        System.out.println(C_YELLOW_UNDERLINED  + "C_YELLOW_UNDERLINED" + C_RESET);
        System.out.println(C_BLUE_UNDERLINED    + "C_BLUE_UNDERLINED"   + C_RESET);
        System.out.println(C_PURPLE_UNDERLINED  + "C_PURPLE_UNDERLINED" + C_RESET);
        System.out.println(C_CYAN_UNDERLINED    + "C_CYAN_UNDERLINED"   + C_RESET);
        System.out.println(C_WHITE_UNDERLINED   + "C_WHITE_UNDERLINED"  + C_RESET);
        System.out.println(C_BLACK_BACKGROUND   + "C_BLACK_BACKGROUND"  + C_RESET);
        System.out.println(C_RED_BACKGROUND     + "C_RED_BACKGROUND"    + C_RESET);
        System.out.println(C_GREEN_BACKGROUND   + "C_GREEN_BACKGROUND"  + C_RESET);
        System.out.println(C_YELLOW_BACKGROUND  + "C_YELLOW_BACKGROUND" + C_RESET);
        System.out.println(C_BLUE_BACKGROUND    + "C_BLUE_BACKGROUND"   + C_RESET);
        System.out.println(C_PURPLE_BACKGROUND  + "C_PURPLE_BACKGROUND" + C_RESET);
        System.out.println(C_CYAN_BACKGROUND    + "C_CYAN_BACKGROUND"   + C_RESET);
        System.out.println(C_WHITE_BACKGROUND   + "C_WHITE_BACKGROUND"  + C_RESET);
    }

    public static final String _5_MARK = ">>>5|";
    public static final String _10_MARK = ">>>>>>>10|";
    public static final String _20_MARK = ">>>>>>>10|>>>>>>>20|";
    public static final String _40_MARK = ">>>>>>>>>|>>>>>>>20|>>>>>>>>>|>>>>>>>40|";
    public static final String _80_MARK = ">>>>>>>>>|>>>>>>>20|>>>>>>>>>|>>>>>>>40|>>>>>>>>>|>>>>>>>60|>>>>>>>>>|>>>>>>>80|";
    public static final String _160_MARK = ">>>>>>>>>|>>>>>>>20|>>>>>>>>>|>>>>>>>40|>>>>>>>>>|>>>>>>>60|>>>>>>>>>|>>>>>>>80|>>>>>>>>>|>>>>>>100|>>>>>>>>>|>>>>>>120|>>>>>>>>>|>>>>>>140|>>>>>>>>>|>>>>>>160|";

    public static String toStrNormalize(int value, int len) {
        return toStrNormalize(String.valueOf(value), len);
    }

    public static String toStrNormalize(float value, int len) {
        return toStrNormalize(String.valueOf(value), len);
    }

    public static String toStrNormalize(String value, int len) {
        // add spaces on the right to fit min len length

        if (value.length() > len) {
            value = value.substring(0,len-3);
            value += "...";
        }
        int x = len - value.length();
//        printDebug("SHOUD BE: " + x);
        for (int i=0; i < x; i++) {
            value += " ";
        }

        return value;
    }
    public static void testConsoleDrawSize() {
        int rows = 40;
        int cols = 160;
        System.out.println(_160_MARK);
        for (int i = 1; i <= rows; i++) {
            System.out.println(i);
        }

        for (int i = 1; i <= cols; i++) {
            System.out.print(i%10);
        }
        System.out.println();
        System.out.println(_160_MARK);
    }
    public static String msgDamage(String nameSrc, String nameDest, String amount) {
        return c_purple(nameSrc) + " deal " + c_red(amount) +" dmg to " + c_purple(nameDest) ;
    }

    public static String msgDamage(String nameSrc, String nameDest, String amount, String weapon) {
        return msgDamage(nameSrc, nameDest, amount) + " with " + c_red(weapon);
    }

    public static String msgDeath(String name) {
        return c_red(name) + " died";
    }

    public static String msgCoinsAdded(String amount) {
        return c_yellow(amount) + " coins added";
    }

    public static String msgHealed(String amount) {
        return "Healed " + c_red(amount) + " HP";
    }

    public static String msgManaRestored(String amount) {
        return "Restored " + c_blue(amount) + " MANA";
    }

    public static String msgCoinsRemoved(String amount) {
        return c_yellow(amount) + " coins removed";
    }
    public static String msgNoCoins() {
        return c_yellow("Not enough") + " coins";
    }

    public static String msgBuffUsed(String buffName) {
        return c_blue(buffName) + " buff used";
    }

    public static String msgPotionUsed(String potionName) {
        return c_blue(potionName) + " potion used";
    }

    public static String msgNoPotionInInventory(String potionName) {
        return "No " + c_blue(potionName) + " potion in inventory!";
    }

    public static String msgNewEncounter(String enemyName) {
        return "New enemy <" + c_red(enemyName) + "> encounter!";
    }

    public static String msgRunAway(String coinsAmount) {
        return "Coward running away! Lost " + c_red(coinsAmount) + " coins on the way!";
    }

    public static String c_purple(String message) {
        return C_PURPLE + message + C_RESET;
    }

    public static String  c_red(String message) {
        return C_RED + message + C_RESET;
    }

    public static String c_blue(String message) {
        return C_BLUE + message + C_RESET;
    }

    public static String c_yellow(String message) {
        return C_YELLOW + message + C_RESET;
    }

    public static String c_green(String message) {
        return C_GREEN + message + C_RESET;
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
        Formatter f = new Formatter();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i< 50; i++) {
            f.format("\n");
        }
        System.out.print(f);
    }

    public static void printDebug(String msg) {
        if (debugMode) {
            System.out.println(c_green("[DEBUG] " + msg));
        }
    }

    public static void printError(String msg) {
        if (errorLoggingMode) {
            System.out.println(c_red("[ERROR] " + msg));
        }
    }
}
