package components.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class CloseButton extends JButton {
    public CloseButton(String title) {
        super(title);
        addActionListener(e -> System.exit(0));

        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);

        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(true);

        setPreferredSize(new Dimension(45, 30));

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                setBackground(Color.RED);
            }

            public void mouseExited(MouseEvent evt) {
                setBackground(Color.DARK_GRAY);
            }
        });
    }
}
