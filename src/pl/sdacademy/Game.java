package pl.sdacademy;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import static pl.sdacademy.ConsoleUtils.msgNoPotionInInventory;
import static pl.sdacademy.ConsoleUtils.msgPotionUsed;

public class Game {

    private static final Game instance = new Game();

    private Queue<String > messageQueue = new LinkedList<>();


    // score
    public static int enemiesCount = 0;
    private Game() {
        for(int i =0; i<=10; i++) {
            addMessageToQueue(" ");
        }
    }

    public static Game getInstance() {
        return instance;
    }

    public void start() {
        mainLoop();

        // wyswietl graczowi podsumowanie gry

        System.exit(0);
    }

    private void mainLoop() {
        boolean exitGame = false;

//        Hero hero = HeroBuilder.getInstance().buildHero();
        Hero hero = HeroBuilder.getInstance().buildHeroForTesting();

//        hero.printInfo();
//        promptForString("ENTER to continue");

        Map keyMap =  Map.of(
                "J","[J]ourney",
                "S","[S]hop",
                "F","[F]ight",
                "R","[R]un",
                "B","[B]uy"
        );

        ConsoleUtils.clearScreen();

        ConsoleUtils.promptForString("Press any key to start new Adventure!");

        String choice = "J";

        while (!exitGame) {

            // journey? shop?
            // j: fight / run?
            // f: fighting r: lose money -> journey
            // shop: buy / journey
            // [J] [S] [F] [R]

            if (choice.equals("S")) {
                //enter shop
                do {
                    choice = Gui.drawGameScreen(new GameModel(hero,null, State.SHOPPING, "[1]small HP [2]bigHP [3]smallMana [4]bigMana or [G]o back?"));

                    if (choice.equals("1") && hero.payCoins(5)) {
                        hero.addToInventory(1);
                        Game.getInstance().addMessageToQueue("Bought small HP potion");
                    } else if (choice.equals("2") && hero.payCoins(15)) {
                        hero.addToInventory(2);
                        Game.getInstance().addMessageToQueue("Bought big HP potion");
                    } else if (choice.equals("3") && hero.payCoins(10)) {
                        hero.addToInventory(3);
                        Game.getInstance().addMessageToQueue("Bought small MANA potion");
                    } else if (choice.equals("4") && hero.payCoins(20)) {
                        hero.addToInventory(4);
                        Game.getInstance().addMessageToQueue("Bought small MANA potion");
                    }
                } while (!choice.equals("G"));
            } else {
                // journey
                String[] enemyNames = {"Thug", "Ork", "Mage", "Skeleton", "Swordsmen", "Archer"};
                Enemy enemy = new Enemy(enemyNames[ThreadLocalRandom.current().nextInt(0, 5 + 1)], Sex.MALE, 30, 10, 10, 10, 10, 10);

                choice = Gui.drawGameScreen(new GameModel(hero,enemy, State.TRAVELING, "You were attacked by " + ConsoleUtils.c_red(enemy.name) + " [F]ight or [R]un?"));
                if (choice.equals("F")) {
                    // fight
                    do {
                        choice = Gui.drawGameScreen(new GameModel(hero,enemy, State.FIGHTING, "[A]xe | [S]word | [F]ire | [I]ce | [R]un" + hero.inventoryToString()));
                        if (choice.equals("R")) {
                            hero.runAway();
                            Gui.drawGameScreen(new GameModel(hero,enemy, State.TRAVELING, "You run away - press enter"));
                            break;
                        }

                        if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
                            switch (choice) {
                                case "1":
                                    if (hero.removeFromInventory(1)) {
                                        addMessageToQueue(msgPotionUsed("small HP"));
                                        hero.addHealth(5);
                                    } else {
                                        addMessageToQueue(msgNoPotionInInventory("small HP"));
                                    }
                                    break;
                                case "2":
                                    if (hero.removeFromInventory(2)) {
                                        addMessageToQueue(msgPotionUsed("big HP"));
                                        hero.addHealth(20);
                                    } else {
                                        addMessageToQueue(msgNoPotionInInventory("big HP"));
                                    }
                                    break;
                                case "3":
                                    if (hero.removeFromInventory(3)) {
                                        addMessageToQueue(msgPotionUsed("small MANA"));
                                        hero.addMana(5);
                                    } else {
                                        addMessageToQueue(msgNoPotionInInventory("small MANA"));
                                    }
                                    break;
                                case "4":
                                    if (hero.removeFromInventory(4)) {
                                        addMessageToQueue(msgPotionUsed("big MANA"));
                                        hero.addMana(10);
                                    } else {
                                        addMessageToQueue(msgNoPotionInInventory("big MANA"));
                                    }
                                    break;
                            }

                            continue;
                        }

                        hero.attack(choice.charAt(0), enemy);

                        if (enemy.isDead()) {
                            hero.addCoins(20);
                            Gui.drawGameScreen(new GameModel(hero,enemy, State.FIGHTING, enemy.name + " is dead - press enter"));
                            break;
                        }

                        Gui.drawGameScreen(new GameModel(hero,enemy, State.FIGHTING,"Enemy turn - press enter"));
                        enemy.attack(hero);
//                        Gui.drawGameScreen(new GameModel(hero,enemy, State.FIGHTING,"End of Enemy turn - press enter"));
                    }while(!choice.equals("R"));
                } else {
                    hero.runAway();
                    Gui.drawGameScreen(new GameModel(hero,enemy, State.TRAVELING, "You run away - press enter"));
                }
            }

            choice = ConsoleUtils.promptForString("[J]ourney | [S]hop | E[X]it game?");

            if("X".equals(choice)) {
                System.exit(1);
            }
        }
    }

    public void addMessageToQueue(String message) {
        if (messageQueue.size() >= 10) {
            messageQueue.poll();
        }

        messageQueue.add(message);
    }

    public Queue<String> getMessages() {
        return messageQueue;
    }
}
