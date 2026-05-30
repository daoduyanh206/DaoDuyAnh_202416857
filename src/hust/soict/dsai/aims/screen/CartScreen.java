package hust.soict.dsai.aims.screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException;

public class CartScreen extends JFrame {
    private Cart cart;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel totalCostLabel;
    private JButton playBtn, removeBtn;
    private JTextField tfFilter;
    private JRadioButton radioBtnFilterId, radioBtnFilterTitle;

    public CartScreen(Cart cart) {
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // 1. Khung Phía Bắc: Tiêu đề và Thanh công cụ Lọc (Filter Bar)
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("CART");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        title.setBorder(BorderFactory.createEmptyBorder(10, 20, 50, 10));
        north.add(title);

        // THANH BỘ LỌC (FILTER BAR) - Đáp ứng chuẩn Mục 5.3 của Lab 5
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
        filterPanel.add(new JLabel("Filter: "));
        
        tfFilter = new JTextField(15);
        filterPanel.add(tfFilter);

        radioBtnFilterId = new JRadioButton("By ID", true);
        radioBtnFilterTitle = new JRadioButton("By Title", false);
        ButtonGroup filterGroup = new ButtonGroup();
        filterGroup.add(radioBtnFilterId);
        filterGroup.add(radioBtnFilterTitle);
        filterPanel.add(radioBtnFilterId);
        filterPanel.add(radioBtnFilterTitle);
        
        north.add(filterPanel);
        cp.add(north, BorderLayout.NORTH);

        // 2. Khung Ở Giữa: Bảng hiển thị danh sách sản phẩm
        String[] columnNames = {"Title", "Category", "Cost"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        
        updateTableData(""); // Hiển thị toàn bộ dữ liệu ban đầu

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JPanel tableControlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        playBtn = new JButton("Play");
        removeBtn = new JButton("Remove");
        playBtn.setEnabled(false); 
        removeBtn.setEnabled(false);

        tableControlPanel.add(playBtn);
        tableControlPanel.add(removeBtn);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(tableControlPanel, BorderLayout.SOUTH);
        cp.add(centerPanel, BorderLayout.CENTER);

        // LẮNG NGHE SỰ KIỆN GÕ CHỮ TRÊN Ô FILTER (Tìm kiếm thời gian thực)
        tfFilter.addActionListener(e -> performFilter());
        // Hoặc kích hoạt lọc ngay khi người dùng nhấn chuyển đổi Radio Button
        radioBtnFilterId.addActionListener(e -> performFilter());
        radioBtnFilterTitle.addActionListener(e -> performFilter());

        // Kiểm soát trạng thái bật tắt nút Play/Remove khi chọn hàng
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                removeBtn.setEnabled(true);
                String selectedTitle = (String) table.getValueAt(row, 0);
                Media selectedMedia = null;
                for (Media m : cart.getItemsOrdered()) {
                    if (m.getTitle().equals(selectedTitle)) {
                        selectedMedia = m;
                        break;
                    }
                }
                playBtn.setEnabled(selectedMedia instanceof Playable);
            } else {
                playBtn.setEnabled(false);
                removeBtn.setEnabled(false);
            }
        });

        // Xử lý nút Xóa sản phẩm
        removeBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String selectedTitle = (String) table.getValueAt(row, 0);
                Media selectedMedia = null;
                for (Media m : cart.getItemsOrdered()) {
                    if (m.getTitle().equals(selectedTitle)) {
                        selectedMedia = m;
                        break;
                    }
                }
                if (selectedMedia != null) {
                    cart.removeMedia(selectedMedia);
                    performFilter(); // Vẽ lại bảng theo bộ lọc hiện tại
                    updateTotalCost();
                    JOptionPane.showMessageDialog(null, "Đã xóa '" + selectedMedia.getTitle() + "' khỏi giỏ hàng.");
                }
            }
        });

        // Xử lý nút Phát nhạc
        playBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String selectedTitle = (String) table.getValueAt(row, 0);
                for (Media m : cart.getItemsOrdered()) {
                    if (m.getTitle().equals(selectedTitle) && m instanceof Playable) {
                        try {
                            ((Playable) m).play();
                            JOptionPane.showMessageDialog(null, "Đang phát: " + m.getTitle(), "AIMS Player", JOptionPane.INFORMATION_MESSAGE);
                        } catch (PlayerException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi Thời Lượng", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        // 3. Khung Phía Đông: Tính tiền tổng và Đặt hàng
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 10, 40));

        JPanel costRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel totalLabel = new JLabel("Total: ");
        totalLabel.setFont(new Font(totalLabel.getFont().getName(), Font.PLAIN, 24));
        totalCostLabel = new JLabel("0.00 $");
        totalCostLabel.setFont(new Font(totalCostLabel.getFont().getName(), Font.PLAIN, 24));
        totalCostLabel.setForeground(Color.CYAN);
        costRow.add(totalLabel);
        costRow.add(totalCostLabel);
        rightPanel.add(costRow);
        rightPanel.add(Box.createVerticalStrut(20));

        JButton placeOrderBtn = new JButton("Place order");
        placeOrderBtn.setFont(new Font(placeOrderBtn.getFont().getName(), Font.PLAIN, 24));
        placeOrderBtn.setBackground(Color.RED);
        placeOrderBtn.setForeground(Color.WHITE);
        placeOrderBtn.setOpaque(true);
        placeOrderBtn.setBorderPainted(false);
        placeOrderBtn.setAlignmentX(CENTER_ALIGNMENT);
        
        placeOrderBtn.addActionListener(e -> {
            if (cart.getItemsOrdered().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giỏ hàng rỗng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Đơn hàng đã được khởi tạo thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                while(!cart.getItemsOrdered().isEmpty()) {
                    cart.removeMedia(cart.getItemsOrdered().get(0));
                }
                performFilter();
                updateTotalCost();
            }
        });
        
        rightPanel.add(placeOrderBtn);
        cp.add(rightPanel, BorderLayout.EAST);

        updateTotalCost();

        setTitle("Giỏ hàng cá nhân (Cart Screen)");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void performFilter() {
        updateTableData(tfFilter.getText().trim().toLowerCase());
    }

    private void updateTableData(String query) {
        tableModel.setRowCount(0);
        for (Media m : cart.getItemsOrdered()) {
            boolean matches = false;
            if (query.isEmpty()) {
                matches = true;
            } else if (radioBtnFilterId.isSelected()) {
                matches = String.valueOf(m.getId()).toLowerCase().contains(query);
            } else if (radioBtnFilterTitle.isSelected()) {
                matches = m.getTitle().toLowerCase().contains(query);
            }
            
            if (matches) {
                Object[] row = {m.getTitle(), m.getCategory(), String.format("%.2f $", m.getCost())};
                tableModel.addRow(row);
            }
        }
    }

    private void updateTotalCost() {
        totalCostLabel.setText(String.format("%.2f $", cart.totalCost()));
    }
}