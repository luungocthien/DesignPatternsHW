package proxy;

import java.util.Date;

public class DocumentProxy implements Document {
    private final RealDocument realDocument;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (AccessControlService.getInstance().isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }

    @Override
    public Date getCreationDate() {
        return realDocument.getCreationDate();
    }
}
