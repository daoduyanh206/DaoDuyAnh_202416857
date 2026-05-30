package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    protected JPanel formPanel;

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // 1. MenuBar dùng chung giống hệt ViewStore để chuyển hướng ngược lại
        cp.add(createMenuBar(), BorderLayout.NORTH);

        // 2. Panel trung tâm làm Form nhập dữ liệu
        formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        cp.add(formPanel, BorderLayout.CENTER);

        // 3. Nút Add gửi dữ liệu ở phía dưới cùng
        JButton addBtn = new JButton("Add Item to Store");
        addBtn.setFont(new Font(addBtn.getFont().getName(), Font.BOLD, 18));
        addBtn.addActionListener(e -> {
            addMediaToStore(); // Gọi hàm xử lý logic của từng lớp con
        });
        
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        southPanel.add(addBtn);
        cp.add(southPanel, BorderLayout.SOUTH);

        setTitle(title);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Menu Bar chuẩn của hệ thống AIMS giúp quay lại màn hình Kho hàng
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        
        addBook.addActionListener(e -> { new AddBookToStoreScreen(store, cart).setVisible(true); this.dispose(); });
        addCD.addActionListener(e -> { new AddCompactDiscToStoreScreen(store, cart).setVisible(true); this.dispose(); });
        addDVD.addActionListener(e -> { new AddDigitalVideoDiscToStoreScreen(store, cart).setVisible(true); this.dispose(); });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuItem viewStoreItem = new JMenuItem("View store");
        JMenuItem viewCartItem = new JMenuItem("View cart");

        viewStoreItem.addActionListener(e -> {
            new StoreScreen(store, cart).setVisible(true);
            this.dispose(); // Đóng màn hình nhập hiện tại để quay về store
        });

        viewCartItem.addActionListener(e -> {
            new CartScreen(cart).setVisible(true);
        });

        menu.add(viewStoreItem);
        menu.add(viewCartItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    // Các trường dữ liệu cơ bản dùng chung cho mọi Media
    protected JTextField addFormRow(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 16));
        JTextField textField = new JTextField();
        formPanel.add(label);
        formPanel.add(textField);
        return textField;
    }

    // Hàm trừu tượng ép các lớp con phải tự thực hiện logic thêm sản phẩm đặc trưng của mình
    protected abstract void addMediaToStore();
}