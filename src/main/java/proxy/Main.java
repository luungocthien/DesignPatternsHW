package proxy;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService accessControlService = AccessControlService.getInstance();

        // Add documents to the library
        library.addUnprotectedDocument("doc1", new Date(), "Unprotected content");
        library.addProtectedDocument("doc2", new Date(), "Protected content");

        // Allow access to the protected document for a specific user
        accessControlService.allowAccess("doc2", "user1");

        // Create users
        User user1 = new User("user1");
        User user2 = new User("user2");

        // Access documents
        try {
            System.out.println("User1 accessing doc1: " + library.getDocument("doc1").getContent(user1));
            System.out.println("User1 accessing doc2: " + library.getDocument("doc2").getContent(user1));
            System.out.println("User2 accessing doc2: " + library.getDocument("doc2").getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}