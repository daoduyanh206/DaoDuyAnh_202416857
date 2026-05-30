package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfArtist, tfDirector;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "AIMS - Add Compact Disc (CD) to Store");
        
        tfTitle = addFormRow("Title:");
        tfCategory = addFormRow("Category:");
        tfCost = addFormRow("Cost ($):");
        tfArtist = addFormRow("Artist:");
        tfDirector = addFormRow("Director:");
    }

    @Override
    protected void addMediaToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();
        String director = tfDirector.getText();

       CompactDisc cd = new CompactDisc(store.getItemsInStore().size() + 1, title, category, cost, artist, director);
        
        // TỰ ĐỘNG NẠP BÀI HÁT MẪU ĐỂ CD CÓ THỜI LƯỢNG > 0
        cd.addTrack(new hust.soict.dsai.aims.media.Track("Bonus Track 1", 200)); // Thời lượng 200 giây
        cd.addTrack(new hust.soict.dsai.aims.media.Track("Bonus Track 2", 180)); // Thời lượng 180 giây
        
        store.addMedia(cd);
        
        JOptionPane.showMessageDialog(this, "Successfully added CD: " + title + " to store!");
        new StoreScreen(store, cart).setVisible(true);
        this.dispose();
    }
}