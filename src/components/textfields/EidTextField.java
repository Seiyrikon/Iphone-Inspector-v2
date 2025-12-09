package components.textfields;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;

public class EidTextField extends JTextField {
    public EidTextField() {
        super(5);

        setAlignmentX(Component.LEFT_ALIGNMENT);

        int height = 40; // <-- your desired height

        setPreferredSize(new Dimension(150, height));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        setMinimumSize(new Dimension(50, height));
    }
}
