package bwgames;

import java.util.ArrayList;
import java.util.List;

import static bwgames.GameMath.clampMax;
import static bwgames.GameMath.clampMin;

public class Hero extends GameCharacter {

    private List<Integer> inventory = new ArrayList<>();


    public Hero(String name, Sex sex, int strength, int stamina, int dexterity, int intelligence, int wisdom, int charisma) {
        super(name, sex, strength, stamina, dexterity, intelligence, wisdom, charisma);
    }

    public void applyDamage(byte amount) {
        currentHealth -= amount;

        if(currentHealth <= 0) {
            currentHealth = 0;

            Game.getInstance().addMessageToQueue(ConsoleUtils.msgDeath(name));
            ConsoleUtils.printDebug("PLAYER DIED - GAME OVER");
            ConsoleUtils.printDebug("YOU KILLED " + (Game.getInstance().enemiesCount - 1) + " enemies.");

            System.exit(0);
        }
    }

    public void addHealth(int amount) {
        currentHealth += amount;

        currentHealth = clampMax(currentHealth, health);
        Game.getInstance().addMessageToQueue(ConsoleUtils.msgHealed(""+amount));
    }

    public void addMana(int amount) {
        currentMana += amount;

        currentMana = clampMax(currentMana, mana);
        Game.getInstance().addMessageToQueue(ConsoleUtils.msgManaRestored(""+amount));
    }

    public void removeMana(int amount) {
        currentMana -= amount;

        currentMana = clampMin(currentMana, 0);
    }

    public void addCoins(int amount) {
        coins += amount;
        Game.getInstance().addMessageToQueue(ConsoleUtils.msgCoinsAdded("" + amount));
    }

    public boolean payCoins(int amount) {
        if (coins - amount < 0) {
            Game.getInstance().addMessageToQueue(ConsoleUtils.msgNoCoins());
            return false;
        }

        coins -= amount;
        Game.getInstance().addMessageToQueue(ConsoleUtils.msgCoinsRemoved("" + amount));

        return true;
    }

    public void addToInventory(int item) {
        inventory.add(item);
    }

    public boolean removeFromInventory(int item) {
        if (inventory.contains(item)) {
            inventory.remove(Integer.valueOf(item));
            return true;
        }

        return false;
    }


    public void attack(char attackType, Enemy enemy) {
        //attackType = 'S'; // Sword, Axe, Fire, Ice
        float attackValue = 0f;
        float hitChance = 0f;
        int manaCost = 0;

        switch (Character.toUpperCase(attackType)) {
            case 'S':
                attackValue = baseDamage * 0.2f;
                hitChance = dexterity * 3;
                break;
            case 'A':
                attackValue = baseDamage * 0.5f;
                hitChance = dexterity * 2;
                break;
            case 'F':
                if (currentMana < 3) {
                    Game.getInstance().addMessageToQueue("Not enough mana!");
                    return;
                }
                attackValue = baseDamage * 2;
                hitChance = intelligence * 5;
                manaCost = 3;
                break;

            case 'I':
                if (currentMana < 5) {
                    Game.getInstance().addMessageToQueue("Not enough mana!");
                    return;
                }
                attackValue = baseDamage * 3;
                hitChance = intelligence * 4;
                manaCost = 5;
                break;
        }

        removeMana(manaCost);

        enemy.applyDamage(attackValue, hitChance, this);
    }

    public void runAway() {
        int coinsPenalty = 10;

        String coinsLostMessage =  coinsPenalty > coins? "all" : "" + coinsPenalty;

        Game.getInstance().addMessageToQueue(ConsoleUtils.msgRunAway(coinsLostMessage));

        coins -= coinsPenalty;
        coins = clampMin(coins, 0);
    }

    public String inventoryToString() {
        String inventoryInfo = inventory.size() > 0 ? " or use\n" : "";
        inventoryInfo += inventory.contains(1) ? "[1] small HP (5) | " :"";
        inventoryInfo += inventory.contains(2) ? "[2] big HP (20) | " : "";
        inventoryInfo += inventory.contains(3) ? "[3] small MANA (5) | " : "";
        inventoryInfo += inventory.contains(4) ? "[4] big MANA (10)" : "";

        return inventoryInfo;
    }
}
