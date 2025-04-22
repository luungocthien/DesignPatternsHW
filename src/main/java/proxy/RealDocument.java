package proxy;

import java.util.Date;

public class RealDocument implements Document {
    private final String id;
    private final Date creationDate;
    private final String content;

    public RealDocument(String id, Date creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }
}