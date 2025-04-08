package state;

public class GameCharacter {
    private String name;
    private int level;
    private int experiencePoints;
    private int healthPoints;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.state = new Novice(this);
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public void train() {
        state.train();
    }

    public void meditate() {
        state.meditate();
    }

    public void fight() {
        state.fight();
    }

    public void displayActions() {
        state.displayActions();
    }

    public void displayStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Experience Points: " + experiencePoints);
        System.out.println("Health Points: " + healthPoints);
        System.out.println("Current State: " + state.getClass().getSimpleName());
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
