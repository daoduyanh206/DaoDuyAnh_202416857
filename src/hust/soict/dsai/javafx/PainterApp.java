package hust.soict.dsai.javafx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PainterApp extends JFrame {
    private JPanel drawingAreaPanel;
    private JRadioButton penRadioButton;
    private JRadioButton eraserRadioButton;

    public PainterApp() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(8, 8));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel toolsPanel = new JPanel();
        toolsPanel.setBorder(BorderFactory.createTitledBorder("Tools"));
        toolsPanel.setLayout(new BoxLayout(toolsPanel, BoxLayout.Y_AXIS));

        penRadioButton = new JRadioButton("Pen", true);
        eraserRadioButton = new JRadioButton("Eraser", false);

        ButtonGroup group = new ButtonGroup();
        group.add(penRadioButton);
        group.add(eraserRadioButton);

        toolsPanel.add(penRadioButton);
        toolsPanel.add(eraserRadioButton);
        leftPanel.add(toolsPanel);
        leftPanel.add(Box.createVerticalStrut(8));

        JButton clearButton = new JButton("Clear");
        clearButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, clearButton.getMinimumSize().height));
        clearButton.addActionListener(e -> drawingAreaPanel.repaint());
        leftPanel.add(clearButton);
        cp.add(leftPanel, BorderLayout.WEST);

        drawingAreaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        drawingAreaPanel.setBackground(Color.WHITE);

        drawingAreaPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                Graphics g = drawingAreaPanel.getGraphics();
                if (penRadioButton.isSelected()) {
                    g.setColor(Color.BLACK);
                    g.fillOval(event.getX(), event.getY(), 8, 8);
                } else if (eraserRadioButton.isSelected()) {
                    g.setColor(Color.WHITE);
                    g.fillOval(event.getX(), event.getY(), 24, 24);
                }
                g.dispose();
            }
        });
        cp.add(drawingAreaPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Painter Application");
        setSize(640, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PainterApp());
    }
}