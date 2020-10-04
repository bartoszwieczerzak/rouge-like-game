package pl.sdacademy;

import static pl.sdacademy.ConsoleUtils.c_green;
import static pl.sdacademy.Sex.*;

public class GameCharacter {
    //statistics given by player
    protected String name;
    protected Sex sex;

    // physical stats
    protected int strength;
    protected int stamina;
    protected int dexterity;

    // mind stats
    protected int intelligence;
    protected int wisdom;
    protected int charisma;

    // base stats
    protected float baseDamage;
    protected float baseBlock;

    // derived stats
    protected float movementSpeed;
    protected float mana;
    protected float currentMana;
    protected float health;
    protected float currentHealth;

    protected int coins;
    protected Buff buffs = Buff.NONE;

    public GameCharacter(String name, Sex sex, int strength, int stamina, int dexterity, int intelligence, int wisdom, int charisma) {
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

        this.currentHealth = health;
        this.currentMana = mana;
    }

    public String getDisplayHp() {
        return currentHealth + "/" + health;
    }

    public String getDisplayMana() {
        return currentMana + "/" + mana;
    }

    public void printInfo() {
        System.out.println(
                "name: " + name +
                "\nsex: " + sex.name() +
                "\nhealth: " + health +
                "\nmana: " + mana +
                "\nstrength: " + strength +
                "\nstamina: " + stamina +
                "\ndexterity: " + dexterity +
                "\nintelligence: " + intelligence +
                "\nwisdom: " + wisdom +
                "\ncharisma: " + charisma +
                "\nbaseDamage: " + baseDamage +
                "\nbaseBlock: " + baseBlock +
                "\ncoins: " + coins +
                "\nmovementSpeed: " + movementSpeed +
                "\nbuffs: " + buffs +
                "\n"
        );
    }
}
