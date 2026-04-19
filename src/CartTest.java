public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart cart = new Cart();

        // Tạo các DVD và thêm vào giỏ
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Kiểm tra phương thức in
        cart.print();

        // Kiểm tra tìm kiếm theo ID
        System.out.println("\nSearch by ID 2:");
        cart.searchById(2);

        // Kiểm tra tìm kiếm theo Tiêu đề
        System.out.println("\nSearch by Title 'Star Wars':");
        cart.searchByTitle("Star Wars");

        System.out.println("\nSearch by Title 'Lion':");
        cart.searchByTitle("Lion");
    }

}