package state;

public class Expert extends CharacterState {
    public Expert(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Gained 20 experience points.");
        character.setExperiencePoints(character.getExperiencePoints() + 20);
        if (character.getExperiencePoints() >= 200) {
            System.out.println("Leveling up to Master!");
            character.setState(new Master(character));
            character.setLevel(4);
        }
    }

    @Override
    public void meditate() {
        System.out.println("Meditating... Gained 25 health points.");
        character.setHealthPoints(character.getHealthPoints() + 25);
    }

    @Override
    public void fight() {
        System.out.println("Fighting... Lost 10 health points but gained 30 experience points.");
        character.setHealthPoints(character.getHealthPoints() - 10);
        character.setExperiencePoints(character.getExperiencePoints() + 30);
        if (character.getExperiencePoints() >= 200) {
            System.out.println("Leveling up to Master!");
            character.setState(new Master(character));
            character.setLevel(4);
        }
    }

    @Override
    public void displayActions() {
        System.out.println("Select an action:");
        System.out.println("1: Train");
        System.out.println("2: Meditate");
        System.out.println("3: Fight");
    }
}