package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "AIMS - Add Digital Video Disc (DVD) to Store");
        
        tfTitle = addFormRow("Title:");
        tfCategory = addFormRow("Category:");
        tfCost = addFormRow("Cost ($):");
        tfDirector = addFormRow("Director:");
        tfLength = addFormRow("Length (minutes):");
    }

    @Override
    protected void addMediaToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        
        JOptionPane.showMessageDialog(this, "Successfully added DVD: " + title + " to store!");
        new StoreScreen(store, cart).setVisible(true);
        this.dispose();
    }
}