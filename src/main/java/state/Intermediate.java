package state;

public class Intermediate extends CharacterState {
    public Intermediate(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Gained 15 experience points.");
        character.setExperiencePoints(character.getExperiencePoints() + 15);
        if (character.getExperiencePoints() >= 100) {
            System.out.println("Leveling up to Expert!");
            character.setState(new Expert(character));
            character.setLevel(3);
        }
    }

    @Override
    public void meditate() {
        System.out.println("Meditating... Gained 20 health points.");
        character.setHealthPoints(character.getHealthPoints() + 20);
    }

    @Override
    public void fight() {
        System.out.println("Fighting is not available at Intermediate level.");
    }

    @Override
    public void displayActions() {
        System.out.println("Select an action:");
        System.out.println("1: Train");
        System.out.println("2: Meditate");
    }
}