package pl.sdacademy;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import static pl.sdacademy.ConsoleUtils.*;

public class Gui {

    public static String drawGameScreen(GameModel model) {
        Hero hero = model.getHero();
        Enemy enemy = model.getEnemy();
        String currentActionPrompt = model.getActionPrompt();
        State gameState = model.getState();

        clearScreen();
        Formatter f = new Formatter();
//        StringBuffer sb = new StringBuffer();

        f.format("%-1s", c_red("WELCOME TO ANSI DUNGEON CRAWLER GAME\n"));

        f.format(_160_MARK + "\n");

        String formatPattern = "%-99s%s%n";
        int tableSize = 14;

        List<String> rightShop = new ArrayList<>();

        rightShop.add(c_blue("+__________ SHOP __________+"                             ));
        rightShop.add(c_blue("|--------- POTIONS --------|"                                       ));
        rightShop.add(c_blue("| [1] small HP   : " + toStrNormalize("5", tableSize-6) + "|"));
        rightShop.add(c_blue("| [2] big HP     : " + toStrNormalize("15", tableSize-6) + "|"));
        rightShop.add(c_blue("| [3] small MANA : " + toStrNormalize("10", tableSize-6) + "|"));
        rightShop.add(c_blue("| [4] big MANA   : " + toStrNormalize("20", tableSize-6) + "|"));
        rightShop.add(c_blue("|______ MELEE WEAPONS _____|"));
        rightShop.add(c_blue("| sword 1  : " + toStrNormalize("100", tableSize) + "|"));
        rightShop.add(c_blue("| sword 2  : " + toStrNormalize("110", tableSize) + "|"));
        rightShop.add(c_blue("| sword 3  : " + toStrNormalize("120", tableSize) + "|"));
        rightShop.add(c_blue("| axe 1    : " + toStrNormalize("180", tableSize) + "|"));
        rightShop.add(c_blue("| axe 2    : " + toStrNormalize("250", tableSize) + "|"));
        rightShop.add(c_blue("| -        : " + toStrNormalize("-",   tableSize) + "|"));
        rightShop.add(c_blue("|______ MAGIC SCROLLS _____|"                                 ));
        rightShop.add(c_blue("| fire     : " + toStrNormalize("30",tableSize) +   "|"));
        rightShop.add(c_blue("| ice      : " + toStrNormalize("35",tableSize) +   "|"));
        rightShop.add(c_blue("| lighting : " + toStrNormalize("40",tableSize) +   "|"));
        rightShop.add(c_blue("| healing  : " + toStrNormalize("20",tableSize) +   "|"));
        rightShop.add(c_blue("| -        : " + toStrNormalize("-", tableSize) +   "|"));
        rightShop.add(c_blue("+__________________________+"                                   ));

        List<String> right = new ArrayList<>();

        if (enemy != null) {
            right.add(c_red("+_______________________+"                                           ));
            right.add(c_red("|----- ENEMY STATS -----|"                                           ));
            right.add(c_red("| name  : " + toStrNormalize(enemy.name,             tableSize) + "|"));
            right.add(c_red("| sex   : " + toStrNormalize(enemy.sex.name(),       tableSize) + "|"));
            right.add(c_red("| health: " + toStrNormalize(enemy.getDisplayHp(),   tableSize) + "|"));
            right.add(c_red("| mana  : " + toStrNormalize(enemy.getDisplayMana(), tableSize) + "|"));
            right.add(c_red("|________ STATS ________|"                                           ));
            right.add(c_red("| str   : " + toStrNormalize(enemy.strength,    tableSize) +      "|"));
            right.add(c_red("| stam  : " + toStrNormalize(enemy.stamina,     tableSize) +      "|"));
            right.add(c_red("| dex   : " + toStrNormalize(enemy.dexterity,   tableSize) +      "|"));
            right.add(c_red("| int   : " + toStrNormalize(enemy.intelligence,tableSize) +      "|"));
            right.add(c_red("| wisd  : " + toStrNormalize(enemy.wisdom,      tableSize) +      "|"));
            right.add(c_red("| char  : " + toStrNormalize(enemy.charisma,    tableSize) +      "|"));
            right.add(c_red("|_____ FIGHT STATS _____|"                                          ));
            right.add(c_red("| dmg   : " + toStrNormalize(enemy.baseDamage,   tableSize) +     "|"));
            right.add(c_red("| block : " + toStrNormalize(enemy.baseBlock,    tableSize) +     "|"));
            right.add(c_red("| coins : " + toStrNormalize(enemy.coins,        tableSize) +     "|"));
            right.add(c_red("| speed : " + toStrNormalize(enemy.movementSpeed,tableSize) +     "|"));
            right.add(c_red("| buff  : " + toStrNormalize(enemy.buffs.name(), tableSize) +     "|"));
            right.add(c_red("+_______________________+"                                           ));
        }

        List<String> left = new ArrayList<>();
        left.add(c_purple("+_______________________+"                                          ));
        left.add(c_purple("|----- HERO STATS ------|"                                          ));
        left.add(c_purple("| name  : " + toStrNormalize(hero.name,             tableSize) + "|"));
        left.add(c_purple("| sex   : " + toStrNormalize(hero.sex.name(),       tableSize) + "|"));
        left.add(c_purple("| health: " + toStrNormalize(hero.getDisplayHp(),   tableSize) + "|"));
        left.add(c_purple("| mana  : " + toStrNormalize(hero.getDisplayMana(), tableSize) + "|"));
        left.add(c_purple("|________ STATS ________|"                                          ));
        left.add(c_purple("| str   : " + toStrNormalize(hero.strength,    tableSize)      + "|"));
        left.add(c_purple("| stam  : " + toStrNormalize(hero.stamina,     tableSize)      + "|"));
        left.add(c_purple("| dex   : " + toStrNormalize(hero.dexterity,   tableSize)      + "|"));
        left.add(c_purple("| int   : " + toStrNormalize(hero.intelligence,tableSize)      + "|"));
        left.add(c_purple("| wisd  : " + toStrNormalize(hero.wisdom,      tableSize)      + "|"));
        left.add(c_purple("| char  : " + toStrNormalize(hero.charisma,    tableSize)      + "|"));
        left.add(c_purple("|_____ FIGHT STATS _____|"                                          ));
        left.add(c_purple("| dmg   : " + toStrNormalize(hero.baseDamage,   tableSize)     + "|"));
        left.add(c_purple("| block : " + toStrNormalize(hero.baseBlock,    tableSize)     + "|"));
        left.add(c_purple("| coins : " + toStrNormalize(hero.coins,        tableSize)     + "|"));
        left.add(c_purple("| speed : " + toStrNormalize(hero.movementSpeed,tableSize)     + "|"));
        left.add(c_purple("| buff  : " + toStrNormalize(hero.buffs.name(), tableSize)     + "|"));
        left.add(c_purple("+_______________________+"                                          ));

        if(left.size() != right.size() && gameState.equals(State.FIGHTING)) {
            printError("Tables on left and right are not equal size!");
        }

        List<String> secondList = gameState.equals(State.SHOPPING) ? rightShop : right;
        int i = 0;
        for(String v : left) {
            f.format(formatPattern, v,secondList.get(i++));
        }

        f.format("%n%113s%n", c_green("Events history"));
        for (String v : Game.getInstance().getMessages()) {
            int sLength = v.length();
            int justify = 0 + sLength;
            f.format("%92s %"+justify+"s%n","->", v);
        }

        f.format("STATUS: " + c_red(gameState.name()) + "\n");
        f.format("STATS:     HEALTH %-20s MANA %-20s COINS %-20s%n", c_red(hero.currentHealth+" / "+hero.health), c_blue(hero.currentMana + " / " + hero.mana), c_yellow("" + hero.coins));


        // write out screen content
        System.out.print(f);

        return ConsoleUtils.promptForString(currentActionPrompt);
    }
}
