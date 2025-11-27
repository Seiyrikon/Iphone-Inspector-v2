package components.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MinimizeButton extends JButton {
    public MinimizeButton(String title) {
        super(title);

        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);

        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(true);

        setPreferredSize(new Dimension(45, 30));

        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                setOpaque(true);
                setBackground(Color.GRAY);
            }

            public void mouseExited(MouseEvent evt) {
                setBackground(new Color(56, 57, 58));
            }
        });

        addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (frame != null) {
                frame.setState(JFrame.ICONIFIED);
            }
        });
    }
}
