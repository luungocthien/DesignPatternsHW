package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    @Override
    public Recommendation clone() {
        Recommendation copy = new Recommendation(this.targetAudience);
        for (Book book : this.books) {
            copy.addBook(book.clone());
        }
        return copy;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target Audience: " + targetAudience + "\n");
        for (int i = 0; i < books.size(); i++) {
            sb.append("[").append(i).append("] ").append(books.get(i)).append("\n");
        }
        return sb.toString();
    }
}

