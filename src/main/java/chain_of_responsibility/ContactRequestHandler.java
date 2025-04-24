package chain_of_responsibility;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Forwarding contact request to support team.");
            System.out.println("Contact request from: " + message.getSenderEmail());
        } else {
            super.handle(message);
        }
    }
}

