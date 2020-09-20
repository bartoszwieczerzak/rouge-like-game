package pl.sdacademy;

import java.util.Date;

import static pl.sdacademy.ConsoleUtils.*;
import static pl.sdacademy.Sex.*;

public class Hero {

    //statistics given by player
    private String name;
    private Sex sex;

    // phisical stats
    private int strength;
    private int stamina;
    private int dexterity;

    // mind stats
    private int intelligence;
    private int wisdom;
    private int charisma;

    // base stats
    private float baseDamage;
    private float baseBlock;

    // derived stats
    private float movementSpeed;
    private float mana;
    private float health;

    private int coins;
    private Buff buffs = null;

    public Hero(String name, Sex sex, int strength, int stamina, int dexterity, int intelligence, int wisdom, int charisma) {
        //enemy = new Enemy("HERO_ENEMY");
        int maleBonus = sex == MALE ? 10 : 0;
        int femaleBonus = sex == FEMALE ? 10 : 0;
        int otherBonus = sex == OTHER ? 10 : 0;

        this.name = name;
        this.sex = sex;
        this.strength = strength + maleBonus;
        this.stamina = stamina + maleBonus;
        this.dexterity = dexterity + femaleBonus;
        this.intelligence = intelligence + femaleBonus;
        this.wisdom = wisdom + otherBonus;
        this.charisma = charisma + otherBonus;

        this.baseDamage = strength * 0.1f;
        this.baseBlock = dexterity * 0.1f;
        this.movementSpeed = stamina * 0.1f;

        this.health = strength * 0.5f + stamina * 0.2f + dexterity * 0.1f;
        this.mana = intelligence * 0.5f + wisdom + stamina * 0.1f;

        this.coins = 0;
    }

    public void printInfo() {
        System.out.println("===== HERO STATS =====\n" +
                "name: " + name +
                "\nsex: " + sex.name() +
                "\nhealth: " + health +
                "\nmana: " + mana +
                "\n====STATS====" +
                "\nstrength: " + strength +
                "\nstamina: " + stamina +
                "\ndexterity: " + dexterity +
                "\nintelligence: " + intelligence +
                "\nwisdom: " + wisdom +
                "\ncharisma: " + charisma +
                "\n====FIGHTS====" +
                "\nbaseDamage: " + baseDamage +
                "\nbaseBlock: " + baseBlock +
                "\ncoins: " + coins +
                "\nmovementSpeed: " + movementSpeed +
                "\nbuffs: " + buffs +
                "\n"
        );
    }

    public void applyDamage(byte amount) {
        System.out.println("Dealing " + c_red(String.valueOf(amount)) + " damage to " + name);
        health -= amount;

        if(health < 0) {
            health = 0;

            printDebug("GRACZ ZGINAL - KONIEC GRY");
            System.out.println("Hero: " + name + " is dead!");
            System.exit(0);
        }
    }

    public void attack(char attackType, Enemy enemy) {
        //attackType = 'S'; // Sword, Axe, Fire, Ice
        float attackValue = 0f;
        float hitChance = 0f;
        float manaCost = 0f;

        switch (Character.toUpperCase(attackType)) {
            case 'S':
                attackValue = baseDamage * 2;
                hitChance = dexterity * 2;
                break;
            case 'A':
                attackValue = baseDamage * 5;
                hitChance = dexterity;
                break;
            case 'F':
                attackValue = baseDamage * 10;
                hitChance = intelligence * 5;
                manaCost = 25;
                break;

            case 'I':
                attackValue = baseDamage * 2;
                hitChance = intelligence * 4;
                manaCost = 10;
                break;
        }

        mana -= manaCost;
        enemy.applyDamage((byte) attackValue, hitChance);
    }

    public void setName(String name) {
        this.name = name;
    }

    private Enemy enemy;

    public Enemy getThing() {
        Date d = new Date();
        return enemy;
    }
}
