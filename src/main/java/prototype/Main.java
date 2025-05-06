package prototype;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Recommendation> recommendations = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                \nBook Recommendation System
                1. View Recommendations
                2. Create New Recommendation
                3. Clone Existing Recommendation
                4. Modify a Recommendation
                5. Exit
                """);

            switch (scanner.nextLine()) {
                case "1" -> viewRecommendations();
                case "2" -> createRecommendation();
                case "3" -> cloneRecommendation();
                case "4" -> modifyRecommendation();
                case "5" -> exit = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void viewRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
            return;
        }
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("[" + i + "]\n" + recommendations.get(i));
        }
    }

    private static void createRecommendation() {
        System.out.print("Enter target audience: ");
        String audience = scanner.nextLine();
        Recommendation rec = new Recommendation(audience);
        addBooksToRecommendation(rec);
        recommendations.add(rec);
        System.out.println("New recommendation added.");
    }

    private static void cloneRecommendation() {
        viewRecommendations();
        System.out.print("Enter index of recommendation to clone: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Recommendation clone = recommendations.get(index).clone();
        System.out.print("Enter new target audience (or press Enter to keep as '" + clone.getTargetAudience() + "'): ");
        String newAudience = scanner.nextLine();
        if (!newAudience.isEmpty()) {
            clone.setTargetAudience(newAudience);
        }
        addBooksToRecommendation(clone);
        recommendations.add(clone);
        System.out.println("Recommendation cloned and modified.");
    }

    private static void modifyRecommendation() {
        viewRecommendations();
        System.out.print("Enter index of recommendation to modify: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Recommendation rec = recommendations.get(index);
        System.out.println("1. Add Book\n2. Remove Book\n3. Change Audience");
        switch (scanner.nextLine()) {
            case "1" -> addBooksToRecommendation(rec);
            case "2" -> {
                rec.getBooks().forEach(System.out::println);
                System.out.print("Enter book index to remove: ");
                int bookIndex = Integer.parseInt(scanner.nextLine());
                rec.removeBook(bookIndex);
            }
            case "3" -> {
                System.out.print("Enter new target audience: ");
                rec.setTargetAudience(scanner.nextLine());
            }
        }
        System.out.println("Modification complete.");
    }

    private static void addBooksToRecommendation(Recommendation rec) {
        while (true) {
            System.out.print("Add a book? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) break;

            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Publication Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            rec.addBook(new Book(title, author, genre, year));
        }
    }
}

