package components.labels;

import java.awt.Component;

import javax.swing.JLabel;

public class ProductNameLabel extends JLabel{
    public ProductNameLabel(String text) {
        super(text);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
