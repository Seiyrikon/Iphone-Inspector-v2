package components.labels;

import java.awt.Component;

import javax.swing.JLabel;

public class ImeiLabel extends JLabel{
    public ImeiLabel(String text) {
        super(text);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
