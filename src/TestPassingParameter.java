public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc lionKing = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc starWars = new DigitalVideoDisc("Star Wars");

        swap(lionKing, starWars);
        System.out.println("lion king title: " + lionKing.getTitle());
        System.out.println("star wars title: " + starWars.getTitle());

        changeTitle(lionKing, starWars.getTitle());
        System.out.println("lion king title: " + lionKing.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}