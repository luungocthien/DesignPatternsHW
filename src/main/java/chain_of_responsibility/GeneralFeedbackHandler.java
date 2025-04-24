package chain_of_responsibility;

public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Thank you for your feedback!");
            System.out.println("Feedback: \"" + message.getContent() + "\"");
        } else {
            super.handle(message);
        }
    }
}

