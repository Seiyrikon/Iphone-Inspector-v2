package components.labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class AppTitle extends JLabel{
    public AppTitle(String title) {
        super(title);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
}
