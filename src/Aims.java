public class Aims {
    public static void main(String[] args){
        Cart cart = new Cart();

        // Sử dụng Constructor đầy đủ tham số
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        // Sử dụng Constructor 4 tham số
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("George Lucas", "Science Fiction", "Star Wars", 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        // Sử dụng Constructor 3 tham số (Lưu ý thứ tự bạn đã viết: category, title, cost)
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost is: " + cart.totalCost());
    }
}