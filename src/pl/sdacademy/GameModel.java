package pl.sdacademy;

public class GameModel {
    private Hero hero;
    private Enemy enemy;
    private State state;
    private String actionPrompt;

    public GameModel(Hero h, Enemy e, State state, String actionPrompt) {
        this.hero = h;
        this.enemy = e;
        this.state = state;
        this.actionPrompt = actionPrompt;
    }

    public Hero getHero() {
        return hero;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public State getState() {
        return state;
    }

    public String getActionPrompt() {
        return actionPrompt;
    }

}
