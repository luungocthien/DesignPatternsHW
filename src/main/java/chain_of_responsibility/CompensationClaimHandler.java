package chain_of_responsibility;

public class CompensationClaimHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("CompensationClaimHandler: Reviewing compensation claim...");
            System.out.println("Claim processed for: " + message.getSenderEmail());
        } else {
            super.handle(message);
        }
    }
}

