package bwgames;

public class Main {
    public static void main(String[] args) {
//        printDebug("debug test message off");
        ConsoleUtils.debugMode = true;
//        printDebug("debug test message on");
//        printError("error test message");

        Debug.log("GAME STARTING");
        Game.getInstance().start();
    }
}
