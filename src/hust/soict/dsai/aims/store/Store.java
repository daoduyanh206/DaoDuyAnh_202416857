package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    // Chuyển sang sử dụng ArrayList<Media> 
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Thêm mặt hàng vào kho 
    public void addMedia(Media media) { 
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' already exists in the store.");
        }
    }

    // Xóa mặt hàng khỏi kho [cite: 196]
    public void removeMedia(Media media) { 
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' was not found in the store.");
        }
    }
    
    // Getter hỗ trợ xem toàn bộ kho hàng sau này
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}