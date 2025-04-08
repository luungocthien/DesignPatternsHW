package state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter character = new GameCharacter("Hero");

        while (character.getLevel() < 4) {
            character.displayStatus();
            character.displayActions();
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    character.train();
                    break;
                case 2:
                    character.meditate();
                    break;
                case 3:
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid action.");
            }
            System.out.println();
        }

        System.out.println("Congratulations! You have reached the Master level.");
        scanner.close();
    }
}