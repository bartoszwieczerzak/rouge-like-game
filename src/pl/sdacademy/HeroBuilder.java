package pl.sdacademy;

import static pl.sdacademy.ConsoleUtils.*;
import static pl.sdacademy.Sex.*;


/**
 * Singleton class because only one hero builder can exist
 * @author Bartosz Wieczerzak
 * @version 1.0
 */
public class HeroBuilder {

    private static HeroBuilder Instance;

    private HeroBuilder() {
    }

    public static HeroBuilder getInstance() {
        if (Instance == null) {
            Instance = new HeroBuilder();
        }

        return Instance;
    }

    private static int skillPoints = 100;

    // delete me - ideally - use stub to pass as a parameter - in future reading player builds configs from files etc...
    public Hero buildHeroForTesting() {
        skillPoints = 0;
        // name, sex, strength, stamina, dexterity, intelligence, wisdom, charisma
        return new Hero("HERCULES", Sex.MALE, 95, 1, 1, 1, 1, 1);
    }

    public Hero buildHero() {
        System.out.println("skill points left: " + skillPoints);

        String name = promptForString("Enter character name> ");
        String sexInput = promptForString("Enter character sex [M]ale, [F]emale, [O]ther> ");
        String lowerCasesexInput = sexInput.toLowerCase();

        Sex sex;

        // Ustawia zmienną sex na MALE, FEMALE lub OTHER zaczytując z konsoloi
        switch (lowerCasesexInput) {
            case "m":
            case "ma":
            case "mal":
            case "male":
                printDebug("SELECTED MALE");
                sex = MALE;
                break;
            case "f":
            case "fe":
            case "fem":
            case "fema":
            case "femal":
            case "female":
                printDebug("SELECTED FEMALE");
                sex = FEMALE;
                break;
            case "o":
            case "ot":
            case "oth":
            case "othe":
            case "other":
            default:
                printDebug("SELECTED OTHER");
                sex = OTHER;
                break;
        }

        int strength = 0;
        int stamina = 0;
        int dexterity = 0;
        int intelligence = 0;
        int wisdom = 0;
        int charisma = 0;

        boolean exit = false;

        do {
            clearScreen();
            System.out.println("Skill points left: " + skillPoints + "\n" +
                    "[1] strength:     " + strength +     "\n" +
                    "[2] stamina:      " + stamina +      "\n" +
                    "[3] dexterity:    " + dexterity +    "\n" +
                    "[4] intelligence: " + intelligence + "\n" +
                    "[5] wisdom:       " + wisdom +       "\n" +
                    "[6] charisma:     " + charisma +     "\n\n" +
                    "[anything else] exit"
            );

            int choice = promptForInt("Please input a number> ");
            switch (choice) {
                case 1: strength = readSkillValueFor("strength", strength); break;
                case 2: stamina = readSkillValueFor("stamina", stamina); break;
                case 3: dexterity = readSkillValueFor("dexterity", dexterity); break;
                case 4: intelligence = readSkillValueFor("intelligence", intelligence); break;
                case 5: wisdom = readSkillValueFor("wisdom", wisdom); break;
                case 6: charisma = readSkillValueFor("charisma", charisma); break;
                default:
                    boolean allStatFieldsSet =
                                    strength     > 0 &&
                                    stamina      > 0 &&
                                    dexterity    > 0 &&
                                    intelligence > 0 &&
                                    wisdom       > 0 &&
                                    charisma     > 0;
                    if(skillPoints == 0 && allStatFieldsSet) {
                        exit = true;
                    } else {
                        promptForString("You have some points to set - remember that stats cannot be 0 \n PRESS ENTER TO CONTINUE!");
                    }
            }
        } while (!exit);

        return new Hero(name, sex, strength, stamina, dexterity, intelligence, wisdom, charisma);
    }

    public int readSkillValueFor(String fieldName, int currentFieldValue) {
        int value;
        int newSkillPointValue;

        do {
            value = promptForInt("Enter " + fieldName + " points> ");
            if (value < 0) {
                System.out.println("New value has to be >= 0 !");
            }

            newSkillPointValue = skillPoints - value + currentFieldValue;
            if (newSkillPointValue < 0) {
                System.out.println("Not enough skill points!\nOnly " + skillPoints + " skill points left");
            }
        } while (value < 0 || newSkillPointValue < 0);

        skillPoints = newSkillPointValue;
/*        System.out.println(fieldName + " set to " + value);
        System.out.println("skill points left: " + skillPoints);*/

        return value;
    }

    //String n = HeroBuilder.promptFor("enter character name");

}
