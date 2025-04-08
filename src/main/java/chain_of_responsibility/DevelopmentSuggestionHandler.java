package chain_of_responsibility;

public class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("DevelopmentSuggestionHandler: Logging suggestion for product team.");
            System.out.println("Suggestion: \"" + message.getContent() + "\"");
        } else {
            super.handle(message);
        }
    }
}

