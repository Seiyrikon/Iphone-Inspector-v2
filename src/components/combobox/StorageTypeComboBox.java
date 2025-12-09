package components.combobox;

import java.awt.Component;

import javax.swing.JComboBox;

public class StorageTypeComboBox extends JComboBox<String>{
    public StorageTypeComboBox(String[] storageTypes) {
        super(storageTypes);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
