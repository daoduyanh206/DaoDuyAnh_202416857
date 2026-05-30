package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        initSampleData();
        javax.swing.SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }

    private static void initSampleData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        
        Book book = new Book(3, "Java Core", "Education", 15.00f);
        book.addAuthor("Cay Horstmann");
        store.addMedia(book);

        CompactDisc cd = new CompactDisc(4, "Space Jam", "Soundtrack", 18.99f, "Various Artists", "Warner Bros");
        cd.addTrack(new Track("Fly Like an Eagle", 255));
        cd.addTrack(new Track("I Believe I Can Fly", 320));
        store.addMedia(cd);

        // Trường hợp thử nghiệm lỗi để kiểm thử cửa sổ PlayerException
        store.addMedia(new DigitalVideoDisc("DVD Non-length Error", "Test", "None", 0, 0.00f));
    }
}