package components.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import components.buttons.ScanButton;

public class SideBar extends JPanel{
    ScanButton scanButton;
    public SideBar() {
        setPreferredSize(new Dimension(200, 600));
        setLayout(null);
        setBackground(Color.BLACK);

        scanButton = new ScanButton("Scan");
        add(scanButton);
    }
}
