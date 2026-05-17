package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args){
        Cart cart = new Cart();

        // 1. Sử dụng Constructor đầy đủ tham số
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1); 

        // 2. Sử dụng Constructor 4 tham số (Sửa lại thứ tự tham số: title, category, director, cost)
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f);
        cart.addMedia(dvd2); 

        // 3. Sử dụng Constructor 3 tham số (title, category, cost)
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3); 

        // In ra tổng tiền và danh sách để kiểm tra thử
        System.out.println("Total cost is: " + cart.totalCost());
        System.out.println("\n--- Current Cart State ---");
        cart.print();
    }
}