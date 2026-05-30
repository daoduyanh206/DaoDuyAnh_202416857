package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;

public class MediaStore extends JPanel {
    public MediaStore(Media media, Cart cart) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("Add to cart");
        addToCartBtn.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(null, "Added " + media.getTitle() + " to cart.");
        });
        container.add(addToCartBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JOptionPane.showMessageDialog(null, "Playing: " + media.getTitle(), "Media Player", JOptionPane.INFORMATION_MESSAGE);
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Illegal Media Length", JOptionPane.ERROR_MESSAGE);
                }
            });
            container.add(playBtn);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}