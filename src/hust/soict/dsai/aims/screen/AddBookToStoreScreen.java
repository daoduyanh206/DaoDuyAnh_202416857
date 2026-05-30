package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "AIMS - Add Book to Store");
        
        tfTitle = addFormRow("Title:");
        tfCategory = addFormRow("Category:");
        tfCost = addFormRow("Cost ($):");
        tfAuthors = addFormRow("Authors (comma separated):");
    }

    @Override
    protected void addMediaToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        
        Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);
        String[] authors = tfAuthors.getText().split(",");
        for (String author : authors) {
            if (!author.trim().isEmpty()) book.addAuthor(author.trim());
        }
        
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Successfully added Book: " + title + " to store!");
        new StoreScreen(store, cart).setVisible(true);
        this.dispose();
    }
}