package components.labels;

import java.awt.Component;

import javax.swing.JLabel;

public class ProductVersionLabel extends JLabel{
    public ProductVersionLabel(String text) {
        super(text);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
