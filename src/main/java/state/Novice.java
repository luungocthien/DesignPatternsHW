package state;

public class Novice extends CharacterState {
    public Novice(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Gained 10 experience points.");
        character.setExperiencePoints(character.getExperiencePoints() + 10);
        if (character.getExperiencePoints() >= 50) {
            System.out.println("Leveling up to Intermediate!");
            character.setState(new Intermediate(character));
            character.setLevel(2);
        }
    }

    @Override
    public void meditate() {
        System.out.println("Meditation is not available at Novice level.");
    }

    @Override
    public void fight() {
        System.out.println("Fighting is not available at Novice level.");
    }

    @Override
    public void displayActions() {
        System.out.println("Select an action:");
        System.out.println("1: Train");
    }
}