package components.panels;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.combobox.ColorTypeComboBox;
import components.combobox.StorageTypeComboBox;
import components.labels.Imei2Label;
import components.labels.ImeiLabel;
import components.labels.IphoneInfoLabel;
import components.labels.ModelNoLabel;
import components.labels.ProductNameLabel;
import components.labels.ProductTypeLabel;
import components.labels.ProductVersionLabel;
import components.labels.SerialNoLabel;
import components.textfields.EidTextField;

import java.awt.Color;
import java.awt.Component;

public class CommonGroupPanel extends JPanel {

    Color backgroundColor = new Color(210, 210, 210);

    public CommonGroupPanel(JLabel label, EidTextField component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(73));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(JLabel label, ColorTypeComboBox component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(62));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(JLabel label, StorageTypeComboBox component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(48));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(IphoneInfoLabel label, ImeiLabel component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(35));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(IphoneInfoLabel label, Imei2Label component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(62));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(IphoneInfoLabel label, SerialNoLabel component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(21));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(IphoneInfoLabel label, ModelNoLabel component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(9));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(IphoneInfoLabel label, ProductNameLabel component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(10));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(IphoneInfoLabel label, ProductTypeLabel component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);
        add(Box.createHorizontalStrut(16));
        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public CommonGroupPanel(IphoneInfoLabel label, ProductVersionLabel component) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(backgroundColor);

        add(label);

        add(component);

        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
