package components.combobox;

import java.awt.Component;

import javax.swing.JComboBox;

public class ColorTypeComboBox extends JComboBox<String>{
    public ColorTypeComboBox(String[] colorTypes) {
        super(colorTypes);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
