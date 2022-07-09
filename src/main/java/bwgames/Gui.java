package bwgames;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import static bwgames.ConsoleUtils.*;

public class Gui {

    public static String drawGameScreen(GameModel model) {
        Hero hero = model.getHero();
        Enemy enemy = model.getEnemy();
        String currentActionPrompt = model.getActionPrompt();
        State gameState = model.getState();

        ConsoleUtils.clearScreen();
        Formatter f = new Formatter();
//        StringBuffer sb = new StringBuffer();

        f.format("%-1s", ConsoleUtils.c_red("WELCOME TO ANSI DUNGEON CRAWLER GAME\n"));

        f.format(ConsoleUtils._160_MARK + "\n");

        String formatPattern = "%-99s%s%n";
        int tableSize = 14;

        List<String> rightShop = new ArrayList<>();

        rightShop.add(ConsoleUtils.c_blue("+__________ SHOP __________+"                             ));
        rightShop.add(ConsoleUtils.c_blue("|--------- POTIONS --------|"                                       ));
        rightShop.add(ConsoleUtils.c_blue("| [1] small HP   : " + ConsoleUtils.toStrNormalize("5", tableSize-6) + "|"));
        rightShop.add(ConsoleUtils.c_blue("| [2] big HP     : " + ConsoleUtils.toStrNormalize("15", tableSize-6) + "|"));
        rightShop.add(ConsoleUtils.c_blue("| [3] small MANA : " + ConsoleUtils.toStrNormalize("10", tableSize-6) + "|"));
        rightShop.add(ConsoleUtils.c_blue("| [4] big MANA   : " + ConsoleUtils.toStrNormalize("20", tableSize-6) + "|"));
        rightShop.add(ConsoleUtils.c_blue("|______ MELEE WEAPONS _____|"));
        rightShop.add(ConsoleUtils.c_blue("| sword 1  : " + ConsoleUtils.toStrNormalize("100", tableSize) + "|"));
        rightShop.add(ConsoleUtils.c_blue("| sword 2  : " + ConsoleUtils.toStrNormalize("110", tableSize) + "|"));
        rightShop.add(ConsoleUtils.c_blue("| sword 3  : " + ConsoleUtils.toStrNormalize("120", tableSize) + "|"));
        rightShop.add(ConsoleUtils.c_blue("| axe 1    : " + ConsoleUtils.toStrNormalize("180", tableSize) + "|"));
        rightShop.add(ConsoleUtils.c_blue("| axe 2    : " + ConsoleUtils.toStrNormalize("250", tableSize) + "|"));
        rightShop.add(ConsoleUtils.c_blue("| -        : " + ConsoleUtils.toStrNormalize("-",   tableSize) + "|"));
        rightShop.add(ConsoleUtils.c_blue("|______ MAGIC SCROLLS _____|"                                 ));
        rightShop.add(ConsoleUtils.c_blue("| fire     : " + ConsoleUtils.toStrNormalize("30",tableSize) +   "|"));
        rightShop.add(ConsoleUtils.c_blue("| ice      : " + ConsoleUtils.toStrNormalize("35",tableSize) +   "|"));
        rightShop.add(ConsoleUtils.c_blue("| lighting : " + ConsoleUtils.toStrNormalize("40",tableSize) +   "|"));
        rightShop.add(ConsoleUtils.c_blue("| healing  : " + ConsoleUtils.toStrNormalize("20",tableSize) +   "|"));
        rightShop.add(ConsoleUtils.c_blue("| -        : " + ConsoleUtils.toStrNormalize("-", tableSize) +   "|"));
        rightShop.add(ConsoleUtils.c_blue("+__________________________+"                                   ));

        List<String> right = new ArrayList<>();

        if (enemy != null) {
            right.add(ConsoleUtils.c_red("+_______________________+"                                           ));
            right.add(ConsoleUtils.c_red("|----- ENEMY STATS -----|"                                           ));
            right.add(ConsoleUtils.c_red("| name  : " + ConsoleUtils.toStrNormalize(enemy.name,             tableSize) + "|"));
            right.add(ConsoleUtils.c_red("| sex   : " + toStrNormalize(enemy.sex.name(),       tableSize) + "|"));
            right.add(ConsoleUtils.c_red("| health: " + ConsoleUtils.toStrNormalize(enemy.getDisplayHp(),   tableSize) + "|"));
            right.add(ConsoleUtils.c_red("| mana  : " + ConsoleUtils.toStrNormalize(enemy.getDisplayMana(), tableSize) + "|"));
            right.add(ConsoleUtils.c_red("|________ STATS ________|"                                           ));
            right.add(ConsoleUtils.c_red("| str   : " + ConsoleUtils.toStrNormalize(enemy.strength,    tableSize) +      "|"));
            right.add(ConsoleUtils.c_red("| stam  : " + ConsoleUtils.toStrNormalize(enemy.stamina,     tableSize) +      "|"));
            right.add(ConsoleUtils.c_red("| dex   : " + ConsoleUtils.toStrNormalize(enemy.dexterity,   tableSize) +      "|"));
            right.add(ConsoleUtils.c_red("| int   : " + ConsoleUtils.toStrNormalize(enemy.intelligence,tableSize) +      "|"));
            right.add(ConsoleUtils.c_red("| wisd  : " + ConsoleUtils.toStrNormalize(enemy.wisdom,      tableSize) +      "|"));
            right.add(ConsoleUtils.c_red("| char  : " + ConsoleUtils.toStrNormalize(enemy.charisma,    tableSize) +      "|"));
            right.add(ConsoleUtils.c_red("|_____ FIGHT STATS _____|"                                          ));
            right.add(ConsoleUtils.c_red("| dmg   : " + ConsoleUtils.toStrNormalize(enemy.baseDamage,   tableSize) +     "|"));
            right.add(ConsoleUtils.c_red("| block : " + ConsoleUtils.toStrNormalize(enemy.baseBlock,    tableSize) +     "|"));
            right.add(ConsoleUtils.c_red("| coins : " + ConsoleUtils.toStrNormalize(enemy.coins,        tableSize) +     "|"));
            right.add(ConsoleUtils.c_red("| speed : " + ConsoleUtils.toStrNormalize(enemy.movementSpeed,tableSize) +     "|"));
            right.add(ConsoleUtils.c_red("| buff  : " + ConsoleUtils.toStrNormalize(enemy.buffs.name(), tableSize) +     "|"));
            right.add(ConsoleUtils.c_red("+_______________________+"                                           ));
        }

        List<String> left = new ArrayList<>();
        left.add(ConsoleUtils.c_purple("+_______________________+"                                          ));
        left.add(ConsoleUtils.c_purple("|----- HERO STATS ------|"                                          ));
        left.add(ConsoleUtils.c_purple("| name  : " + ConsoleUtils.toStrNormalize(hero.name,             tableSize) + "|"));
        left.add(ConsoleUtils.c_purple("| sex   : " + toStrNormalize(hero.sex.name(),       tableSize) + "|"));
        left.add(ConsoleUtils.c_purple("| health: " + ConsoleUtils.toStrNormalize(hero.getDisplayHp(),   tableSize) + "|"));
        left.add(ConsoleUtils.c_purple("| mana  : " + ConsoleUtils.toStrNormalize(hero.getDisplayMana(), tableSize) + "|"));
        left.add(ConsoleUtils.c_purple("|________ STATS ________|"                                          ));
        left.add(ConsoleUtils.c_purple("| str   : " + ConsoleUtils.toStrNormalize(hero.strength,    tableSize)      + "|"));
        left.add(ConsoleUtils.c_purple("| stam  : " + ConsoleUtils.toStrNormalize(hero.stamina,     tableSize)      + "|"));
        left.add(ConsoleUtils.c_purple("| dex   : " + ConsoleUtils.toStrNormalize(hero.dexterity,   tableSize)      + "|"));
        left.add(ConsoleUtils.c_purple("| int   : " + ConsoleUtils.toStrNormalize(hero.intelligence,tableSize)      + "|"));
        left.add(ConsoleUtils.c_purple("| wisd  : " + ConsoleUtils.toStrNormalize(hero.wisdom,      tableSize)      + "|"));
        left.add(ConsoleUtils.c_purple("| char  : " + ConsoleUtils.toStrNormalize(hero.charisma,    tableSize)      + "|"));
        left.add(ConsoleUtils.c_purple("|_____ FIGHT STATS _____|"                                          ));
        left.add(ConsoleUtils.c_purple("| dmg   : " + ConsoleUtils.toStrNormalize(hero.baseDamage,   tableSize)     + "|"));
        left.add(ConsoleUtils.c_purple("| block : " + ConsoleUtils.toStrNormalize(hero.baseBlock,    tableSize)     + "|"));
        left.add(ConsoleUtils.c_purple("| coins : " + ConsoleUtils.toStrNormalize(hero.coins,        tableSize)     + "|"));
        left.add(ConsoleUtils.c_purple("| speed : " + ConsoleUtils.toStrNormalize(hero.movementSpeed,tableSize)     + "|"));
        left.add(ConsoleUtils.c_purple("| buff  : " + ConsoleUtils.toStrNormalize(hero.buffs.name(), tableSize)     + "|"));
        left.add(ConsoleUtils.c_purple("+_______________________+"                                          ));

        if(left.size() != right.size() && gameState.equals(State.FIGHTING)) {
            ConsoleUtils.printError("Tables on left and right are not equal size!");
        }

        List<String> secondList = gameState.equals(State.SHOPPING) ? rightShop : right;
        int i = 0;
        for(String v : left) {
            f.format(formatPattern, v,secondList.get(i++));
        }

        f.format("%n%113s%n", ConsoleUtils.c_green("Events history"));
        for (String v : Game.getInstance().getMessages()) {
            int sLength = v.length();
            int justify = 0 + sLength;
            f.format("%92s %"+justify+"s%n","->", v);
        }

        f.format("STATUS: " + ConsoleUtils.c_red(gameState.name()) + "\n");
        f.format("STATS:     HEALTH %-20s MANA %-20s COINS %-20s%n", ConsoleUtils.c_red(hero.currentHealth+" / "+hero.health), ConsoleUtils.c_blue(hero.currentMana + " / " + hero.mana), ConsoleUtils.c_yellow("" + hero.coins));


        // write out screen content
        System.out.print(f);

        return ConsoleUtils.promptForString(currentActionPrompt);
    }
}
