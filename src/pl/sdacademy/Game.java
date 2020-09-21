package pl.sdacademy;

public class Game {

    private static final Game instance = new Game();

    private Game() {
    }

    public static Game getInstance() {
        return instance;
    }

    public void start() {

        mainLoop();

        // wyswietl graczowi podsumowanie gry

        // TU APLIKACJA SIE ZAKONCZY
        System.exit(0);
    }

    private void mainLoop() {
        boolean exitGame = false;

//        Hero hero = HeroBuilder.getInstance().buildHero();
        Hero hero = HeroBuilder.getInstance().buildHeroForTesting();

        hero.printInfo();

        while (!exitGame) {

            Enemy e = new Enemy("Thug");

            while(!e.isDead()) {
                hero.attack('A', e);
                e.attack(hero);
            }
            exitGame = true;
        }
    }
}
