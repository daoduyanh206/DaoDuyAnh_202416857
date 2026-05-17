package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>(); 
    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) { 
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' has been added.");
        } else {
            System.out.println("Author '" + authorName + "' already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) { 
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' has been removed.");
        } else {
            System.out.println("Author '" + authorName + "' is not in the list.");
        }
    }

    public List<String> getAuthors() {
        return authors;
    }
}