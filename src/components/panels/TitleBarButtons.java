package components.panels;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import components.buttons.CloseButton;
import components.buttons.MaximizeButton;
import components.buttons.MinimizeButton;

public class TitleBarButtons extends JPanel{
    MinimizeButton minimizeButton;
    MaximizeButton maximizeButton;
    CloseButton closeButton;

    public TitleBarButtons() {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        setOpaque(false);

        minimizeButton = new MinimizeButton("_");
        maximizeButton = new MaximizeButton("▢");
        closeButton = new CloseButton("X");

        add(minimizeButton);
        add(maximizeButton);
        add(closeButton);
    }
}
