package components.labels;

import java.awt.Component;

import javax.swing.JLabel;

public class SerialNoLabel extends JLabel{
    public SerialNoLabel(String text) {
        super(text);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
