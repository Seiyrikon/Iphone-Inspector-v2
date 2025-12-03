package components.panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.labels.IphoneInfoLabel;
import components.labels.ScanButtonIconLabel;
import components.labels.ScanButtonTextLabel;
import model.IphoneModel;
import services.device.DeviceService;
import utils.CommandExecutor;
import utils.CommandResult;
import utils.Constants;

public class ScanButtonPanel extends JPanel {
    ScanButtonIconLabel iconLabel;
    ScanButtonTextLabel textLabel;

    private boolean pressed = false;
    private Color normalColor = new Color(56, 57, 58);
    private Color hoverColor = new Color(240, 240, 240);

    private InformationContainerPanel infoContainer;
    private DeviceService deviceService;

    public ScanButtonPanel(InformationContainerPanel infoContainer, DeviceService deviceService) {
        this.infoContainer = infoContainer;
        this.deviceService = deviceService;

        setOpaque(false);
        setBackground(normalColor);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        iconLabel = new ScanButtonIconLabel();
        textLabel = new ScanButtonTextLabel();

        add(Box.createHorizontalGlue());
        add(iconLabel);
        add(Box.createHorizontalStrut(10));
        add(textLabel);
        add(Box.createHorizontalGlue());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
                textLabel.setForeground(new Color(56, 57, 58));
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
                textLabel.setForeground(Color.WHITE);
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pressed = false;
                System.out.println("Scan Button clicked!");
                generateInfo();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                repaint();
            }
        });

    }

    private void generateInfo() {
        infoContainer.removeAll();
        infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));

        CommandResult device = deviceService.detect();

        if(device.output.isBlank() && device.error.isBlank()) {
            System.out.println("No Device Detected!");
            return;
        }

        IphoneModel result = deviceService.extractInfo();
        // result.output = "Hello";

        // if (result.output != null) {
        //     JLabel label = new JLabel(result.output);
        //     infoContainer.add(label);
        // } else {

        //     for (int i = 1; i <= 5; i++) {
        //         JLabel label = new JLabel("Generated Info " + i);
        //         label.setForeground(Color.BLACK);
        //         label.setAlignmentX(Component.LEFT_ALIGNMENT);
        //         infoContainer.add(label);
        //     }

        // }
        IphoneInfoLabel imeiLabel = new IphoneInfoLabel(Constants.IMEI.get().toString() + result.getImei());
        infoContainer.add(imeiLabel);

        IphoneInfoLabel imei2Label = new IphoneInfoLabel(Constants.IMEI2.get().toString() + result.getImei2());
        infoContainer.add(imei2Label);

        IphoneInfoLabel serialNoLabel = new IphoneInfoLabel(Constants.SERIAL_NUMBER.get().toString() + result.getSerialNo());
        infoContainer.add(serialNoLabel);

        IphoneInfoLabel modelNoLabel = new IphoneInfoLabel(Constants.MODEL_NUMBER.get().toString() + result.getModel() + result.getRegion());
        infoContainer.add(modelNoLabel);

        IphoneInfoLabel productNameLabel = new IphoneInfoLabel(Constants.PRODUCT_NAME.get().toString() + result.getProductName());
        infoContainer.add(productNameLabel);

        IphoneInfoLabel productTypeLabel = new IphoneInfoLabel(Constants.PRODUCT_TYPE.get().toString() + result.getProductType());
        infoContainer.add(productTypeLabel);

        IphoneInfoLabel productVersionLabel = new IphoneInfoLabel(Constants.PRODUCT_VERSION.get().toString() + result.getProductVersion());
        infoContainer.add(productVersionLabel);

        infoContainer.revalidate();
        infoContainer.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int offset = pressed ? 2 : 0;

        g2.setColor(getBackground());
        g2.fillRoundRect(offset, offset, getWidth() - 6, getHeight() - 6, 20, 20);

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(offset, offset, getWidth() - 6, getHeight() - 6, 20, 20);

        g2.dispose();
        super.paintComponent(g);
    }
}
