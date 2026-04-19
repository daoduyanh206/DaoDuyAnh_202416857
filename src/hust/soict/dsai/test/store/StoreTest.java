package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        // Kiểm tra thêm DVD
        store.addDVD(dvd1);
        store.addDVD(dvd2);

        // Kiểm tra xóa DVD
        store.removeDVD(dvd1);
        store.removeDVD(dvd1); // Thử xóa lại đĩa đã xóa
    }
}