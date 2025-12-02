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

import components.labels.ScanButtonIconLabel;
import components.labels.ScanButtonTextLabel;
import model.IphoneModel;
import services.device.DeviceService;
import utils.CommandExecutor;
import utils.CommandResult;

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

        // CommandResult result = deviceService.detect();
        IphoneModel result = deviceService.extractInfo();
        // result.output = "Hello";

        if (result == null) {
            JLabel label = new JLabel("No device connected");
            infoContainer.add(label);
        }

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
        JLabel imeiLabel = new JLabel(result.getImei());
        imeiLabel.setForeground(Color.BLACK);
        imeiLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(imeiLabel);

        JLabel imei2Label = new JLabel(result.getImei2());
        imei2Label.setForeground(Color.BLACK);
        imei2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(imei2Label);

        JLabel serialNoLabel = new JLabel(result.getSerialNo());
        serialNoLabel.setForeground(Color.BLACK);
        serialNoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(serialNoLabel);

        JLabel modelNoLabel = new JLabel("Model Number: " + result.getModel() + result.getRegion());
        modelNoLabel.setForeground(Color.BLACK);
        modelNoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(modelNoLabel);

        JLabel productNameLabel = new JLabel(result.getProductName());
        productNameLabel.setForeground(Color.BLACK);
        productNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(productNameLabel);

        JLabel productTypeLabel = new JLabel(result.getProductType());
        productTypeLabel.setForeground(Color.BLACK);
        productTypeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(productTypeLabel);

        JLabel productVersionLabel = new JLabel(result.getProductVersion());
        productVersionLabel.setForeground(Color.BLACK);
        productVersionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
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
