public class Aims {
    public static void main(String[] args){
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The line king","Animation","Rogger Aller",87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star wars","Science fiction","George Lucas",87, 24.05f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation","Aladin",18.99f);
        cart.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost is: ");
        System.out.println(cart.totalCost());

        cart.removeDigitalVideoDisc(dvd2);

        System.out.println("Total cost is: ");
        System.out.println(cart.totalCost());

        cart.removeDigitalVideoDisc(dvd2);
    }

}
