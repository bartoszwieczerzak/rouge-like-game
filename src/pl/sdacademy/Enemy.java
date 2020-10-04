package pl.sdacademy;

import java.util.concurrent.ThreadLocalRandom;

import static pl.sdacademy.ConsoleUtils.*;

public class Enemy  extends GameCharacter {

    private Guild guild = Guild.A;

    private boolean isDead = false;

    public boolean isDead() {
        return isDead;
    }

    public Enemy(String name, Sex sex, int strength, int stamina, int dexterity, int intelligence, int wisdom, int charisma) {
        super(name, sex, strength, stamina, dexterity, intelligence, wisdom, charisma);
        Game.getInstance().enemiesCount++;
    }

    public void applyDamage(float amount, float attackHitChance, Hero hero) {
        float random = ThreadLocalRandom.current().nextFloat();
        boolean isHit = attackHitChance > random * 100;

        System.out.println("[DEBUG] random: " + random + " attackChance: " + attackHitChance);

        if (isHit) {
            Game.getInstance().addMessageToQueue(msgDamage(hero.name, name, String.valueOf(amount)));
            currentHealth -= amount;

            // przypadek gdy wrog zginal
            if(currentHealth <= 0) {
                currentHealth = 0;

                isDead = true;
            }
        } else {
            Game.getInstance().addMessageToQueue("Enemy dodged attack!");
            Game.getInstance().addMessageToQueue(msgDamage(hero.name, name, "0"));
        }
    }

    public void attack(Hero hero) {
        byte randomAttackValue = (byte)ThreadLocalRandom.current().nextInt(0, 6 + 1);
        hero.applyDamage(randomAttackValue);

        Game.getInstance().addMessageToQueue(msgDamage(name, hero.name, String.valueOf(randomAttackValue)));
    }

    public void getRandomTaunt() {
        int random = ThreadLocalRandom.current().nextInt(0, 3 + 1);

        switch (random) {
            case 0:
                System.out.println("Bring it on!");
                break;
            case 1:
                System.out.println("I'll kill you!");
                break;
            case 2:
                System.out.println("Don't mess with me!");
                break;
            case 3:
                System.out.println("I feel your blood!");
                break;
            default:
                System.out.println("[ERROR] Taunt [" + random +"] does not exist");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
//    - metoda pozwalająca atakować bohatera
}
