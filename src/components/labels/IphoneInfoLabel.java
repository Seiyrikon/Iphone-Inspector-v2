package components.labels;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

public class IphoneInfoLabel extends JLabel{
    public IphoneInfoLabel(String text) {
        super(text);

        setForeground(Color.BLACK);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
