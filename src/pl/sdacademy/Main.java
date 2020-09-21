package pl.sdacademy;

import static pl.sdacademy.ConsoleUtils.*;

public class Main {
    public static void main(String[] args) {

        printDebug("debug test message off");
        debugMode = true;
        printDebug("debug test message on");
        printError("error test message");


        Game.getInstance().start();
    }
}
