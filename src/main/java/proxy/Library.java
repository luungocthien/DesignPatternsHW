package proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Document> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, Date creationDate, String content) {
        documents.put(id, new RealDocument(id, creationDate, content));
    }

    public void addProtectedDocument(String id, Date creationDate, String content) {
        RealDocument realDocument = new RealDocument(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        documents.put(id, proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}