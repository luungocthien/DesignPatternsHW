package chain_of_responsibility;

public abstract class FeedbackHandler {
    private FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Message message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No handler available for this type of message.");
        }
    }
}

