package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        FeedbackHandler handlerChain;

        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        // Set up the chain
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalHandler);

        handlerChain = compensationHandler;

        // Example messages
        Message msg1 = new Message(MessageType.COMPENSATION_CLAIM, "I want a refund for a broken item.", "user1@example.com");
        Message msg2 = new Message(MessageType.CONTACT_REQUEST, "Please call me back about my order.", "user2@example.com");
        Message msg3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add dark mode to the app.", "user3@example.com");
        Message msg4 = new Message(MessageType.GENERAL_FEEDBACK, "Great service, thanks!", "user4@example.com");

        // Process messages
        handlerChain.handle(msg1);
        System.out.println("-----");
        handlerChain.handle(msg2);
        System.out.println("-----");
        handlerChain.handle(msg3);
        System.out.println("-----");
        handlerChain.handle(msg4);
    }
}

