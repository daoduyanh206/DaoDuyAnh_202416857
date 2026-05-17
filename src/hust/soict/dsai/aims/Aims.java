package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Khởi tạo một vài dữ liệu mẫu cho Store để test
        initSampleData();
        
        int choice;
        while (true) {
            showMenu();
            choice = getUserChoice(0, 3);
            switch (choice) {
                case 1:
                    viewStoreLayout();
                    break;
                case 2:
                    updateStoreLayout();
                    break;
                case 3:
                    viewCartLayout();
                    break;
                case 0:
                    System.out.println("Thank you for using AIMS. Goodbye!");
                    System.exit(0);
            }
        }
    }

    // --- CÁC PHƯƠNG THỨC HIỂN THỊ MENU THEO TÀI LIỆU LAB ---
    
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // --- LOGIC XỬ LÝ ĐIỀU HƯỚNG CÁC TẦNG INTERFACE ---

    private static void viewStoreLayout() {
        while (true) {
            System.out.println("\n--- ITEMS IN STORE ---");
            int idx = 1;
            for (Media m : store.getItemsInStore()) {
                System.out.println(idx + ". " + m.toString());
                idx++;
            }
            if (store.getItemsInStore().isEmpty()) {
                System.out.println("[Store is empty]");
            }
            
            storeMenu();
            int choice = getUserChoice(0, 4);
            if (choice == 0) break; // Quay lại menu chính
            
            switch (choice) {
                case 1: // See details
                    handleMediaDetails();
                    break;
                case 2: // Add to cart
                    handleAddToCart();
                    break;
                case 3: // Play media
                    handlePlayMedia(store.getItemsInStore());
                    break;
                case 4: // See current cart
                    viewCartLayout();
                    break;
            }
        }
    }

    private static void handleMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media found = null;
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = m;
                break;
            }
        }
        if (found == null) {
            System.out.println("Media not found!");
            return;
        }
        System.out.println("\n[DETAILS]: " + found.toString());
        
        while (true) {
            mediaDetailsMenu();
            int choice = getUserChoice(0, 2);
            if (choice == 0) break;
            if (choice == 1) {
                cart.addMedia(found);
            } else if (choice == 2) {
                if (found instanceof Playable) {
                    ((Playable) found).play();
                } else {
                    System.out.println("This type of media cannot be played!");
                }
            }
        }
    }

    private static void handleAddToCart() {
        System.out.print("Enter the title of the media to add: ");
        String title = scanner.nextLine();
        Media found = null;
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = m;
                break;
            }
        }
        if (found != null) {
            cart.addMedia(found);
        } else {
            System.out.println("Media not found in store!");
        }
    }

    private static void handlePlayMedia(java.util.List<Media> list) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media found = null;
        for (Media m : list) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = m;
                break;
            }
        }
        if (found != null) {
            if (found instanceof Playable) {
                ((Playable) found).play();
            } else {
                System.out.println("This item cannot be played (Only CD and DVD support this feature).");
            }
        } else {
            System.out.println("Item not found!");
        }
    }

    private static void updateStoreLayout() {
        System.out.println("\n[Update Store Layout]");
        System.out.println("1. Add a media to Store");
        System.out.println("2. Remove a media from Store");
        System.out.println("0. Back");
        int choice = getUserChoice(0, 2);
        if (choice == 1) {
            System.out.println("Choose media type: 1. DVD | 2. Book | 3. CD");
            int type = getUserChoice(1, 3);
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String cat = scanner.nextLine();
            System.out.print("Enter cost: ");
            float cost = Float.parseFloat(scanner.nextLine());

            if (type == 1) {
                store.addMedia(new DigitalVideoDisc(title, cat, cost));
            } else if (type == 2) {
                store.addMedia(new Book(store.getItemsInStore().size() + 1, title, cat, cost));
            } else if (type == 3) {
                store.addMedia(new CompactDisc(store.getItemsInStore().size() + 1, title, cat, cost, "Unknown", "Unknown"));
            }
        } else if (choice == 2) {
            System.out.print("Enter the title of the media to remove: ");
            String title = scanner.nextLine();
            Media found = null;
            for (Media m : store.getItemsInStore()) {
                if (m.getTitle().equalsIgnoreCase(title)) {
                    found = m;
                }
            }
            if (found != null) store.removeMedia(found);
            else System.out.println("Item not found!");
        }
    }

    private static void viewCartLayout() {
        while (true) {
            System.out.println();
            cart.print();
            cartMenu();
            int choice = getUserChoice(0, 5);
            if (choice == 0) break;
            switch (choice) {
                case 1: // Filter
                    System.out.println("Filter by: 1. ID | 2. Title");
                    int fType = getUserChoice(1, 2);
                    if (fType == 1) {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        cart.searchById(id);
                    } else {
                        System.out.print("Enter keyword: ");
                        String kw = scanner.nextLine();
                        cart.searchByTitle(kw);
                    }
                    break;
                case 2: // Sort
                    System.out.println("Sort by: 1. Title | 2. Cost");
                    int sType = getUserChoice(1, 2);
                    if (sType == 1) cart.sortByTitle();
                    else cart.sortByCost();
                    break;
                case 3: // Remove
                    System.out.print("Enter title to remove from cart: ");
                    String tRem = scanner.nextLine();
                    // Tìm phần tử trong kho để lấy tham chiếu đối tượng chuẩn
                    Media mRem = null;
                    for (Media m : store.getItemsInStore()) {
                        if (m.getTitle().equalsIgnoreCase(tRem)) mRem = m;
                    }
                    if (mRem != null) cart.removeMedia(mRem);
                    break;
                case 4: // Play
                    // Pass danh sách đồ trong giỏ để kiểm tra phát nhạc
                    System.out.println("Play item in cart:");
                    System.out.print("Enter title: ");
                    String tPlay = scanner.nextLine();
                    Media mPlay = null;
                    for (Media m : store.getItemsInStore()) {
                        if (m.getTitle().equalsIgnoreCase(tPlay)) mPlay = m;
                    }
                    if (mPlay instanceof Playable) ((Playable) mPlay).play();
                    break;
                case 5: // Place Order
                    System.out.println("An order has been successfully created! Your cart is now empty.");
                    cart = new Cart(); // Reset giỏ hàng rỗng theo yêu cầu đề bài
                    break;
            }
        }
    }

    // --- HÀM TRỢ GIÚP TIỆN ÍCH ---

    private static int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Invalid choice. Please re-enter (" + min + "-" + max + "):");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid integer number:");
            }
        }
        return choice;
    }

    private static void initSampleData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        Book book = new Book(3, "Java Core", "Education", 15.00f);
        book.addAuthor("Cay Horstmann");
        store.addMedia(book);
    }
}