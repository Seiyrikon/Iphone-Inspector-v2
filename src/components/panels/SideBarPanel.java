package components.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import services.device.DeviceService;

public class SideBarPanel extends JPanel{
    ScanButtonPanel scanButton;
    GenerateButtonPanel generateButton;
    PrintButtonPanel printButton;

    public SideBarPanel(InformationContainerPanel infoContainer, DeviceService deviceService) {
        setPreferredSize(new Dimension(200, 600));
        setLayout(null);
        // setBackground(Color.RED);
        setBackground(new Color(20, 21, 22));

        scanButton = new ScanButtonPanel(infoContainer, deviceService);
        scanButton.setBounds(10, 20, 180, 50);
        add(scanButton);

        generateButton = new GenerateButtonPanel();
        generateButton.setBounds(10, 100, 180, 50);
        add(generateButton);

        printButton = new PrintButtonPanel();
        printButton.setBounds(10, 180, 180, 50);
        add(printButton);
    }
}
