package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media; // Import lớp cha Media

public class Cart {
    // Thay thế mảng bằng ArrayList 
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>(); 
    // Thêm một Media bất kỳ vào giỏ hàng (Book, CD, hoặc DVD) 
    public void addMedia(Media media) { 
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to your cart.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is already in your cart.");
        }
    }

    // Xóa một Media khỏi giỏ hàng 
    public void removeMedia(Media media) { 
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed from your cart.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' was not found in your cart.");
        }
    }

    // Tính tổng giá tiền của tất cả mặt hàng trong giỏ [cite: 193]
    public float totalCost() { 
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // In danh sách giỏ hàng
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index + ". " + media.toString());
            index++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Tìm kiếm theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found match: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item with ID: " + id + " was found.");
        }
    }

    // Tìm kiếm theo Tiêu đề (Sử dụng trực tiếp getTitle())
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null && media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found match: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item with title: '" + title + "' was found.");
        }
    }
}