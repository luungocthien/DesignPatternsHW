package state;

public class Master extends CharacterState {
    public Master(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("You have reached the Master level. No further training is required.");
    }

    @Override
    public void meditate() {
        System.out.println("You have reached the Master level. No further meditation is required.");
    }

    @Override
    public void fight() {
        System.out.println("You have reached the Master level. No further fighting is required.");
    }

    @Override
    public void displayActions() {
        System.out.println("You have reached the Master level. No actions are available.");
    }
}