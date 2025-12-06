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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

    IphoneModel iphone;

    public ScanButtonPanel(InformationContainerPanel infoContainer, DeviceService deviceService, IphoneModel iphone) {
        this.infoContainer = infoContainer;
        this.deviceService = deviceService;
        this.iphone = iphone;

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

        // if (device.output.isBlank() && device.error.isBlank()) {
        //     System.out.println("No Device Detected!");
        //     return;
        // }

        IphoneModel result = deviceService.extractInfo();

        // Helper method for spacing
        final int SPACING = 10;

        // --- EID ---
        IphoneInfoLabel eidLabel = new IphoneInfoLabel(Constants.EID.get().toString());
        eidLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(eidLabel);

        JTextField eidTextField = new JTextField(20);
        eidTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(eidTextField);

        infoContainer.add(Box.createVerticalStrut(SPACING));

        // --- COLOR ---
        IphoneInfoLabel colorLabel = new IphoneInfoLabel(Constants.COLOR_TYPE.get().toString());
        colorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(colorLabel);

        JComboBox<String> colorDropdown = new JComboBox<>(new String[] { "Red", "Black", "Blue" });
        colorDropdown.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(colorDropdown);

        infoContainer.add(Box.createVerticalStrut(SPACING));

        // --- STORAGE ---
        IphoneInfoLabel storageLabel = new IphoneInfoLabel(Constants.STORAGE_TYPE.get().toString());
        storageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(storageLabel);

        JComboBox<String> storageDropdown = new JComboBox<>(new String[] {
                "64 GB", "128 GB", "256 GB", "512 GB", "1 TB"
        });
        storageDropdown.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(storageDropdown);

        infoContainer.add(Box.createVerticalStrut(SPACING));

        // --- IMEI ---
        IphoneInfoLabel imeiLabel = new IphoneInfoLabel(Constants.IMEI.get().toString() + result.getImei());
        imeiLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(imeiLabel);

        // --- IMEI2 ---
        IphoneInfoLabel imei2Label = new IphoneInfoLabel(Constants.IMEI2.get().toString() + result.getImei2());
        imei2Label.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(imei2Label);

        // --- SERIAL NO ---
        IphoneInfoLabel serialNoLabel = new IphoneInfoLabel(
                Constants.SERIAL_NUMBER.get().toString() + result.getSerialNo());
        serialNoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(serialNoLabel);

        // --- MODEL NO ---
        IphoneInfoLabel modelNoLabel = new IphoneInfoLabel(
                Constants.MODEL_NUMBER.get().toString() + result.getModel() + result.getRegion());
        modelNoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(modelNoLabel);

        // --- PRODUCT NAME ---
        IphoneInfoLabel productNameLabel = new IphoneInfoLabel(
                Constants.PRODUCT_NAME.get().toString() + result.getProductName());
        productNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(productNameLabel);

        // --- PRODUCT TYPE ---
        IphoneInfoLabel productTypeLabel = new IphoneInfoLabel(
                Constants.PRODUCT_TYPE.get().toString() + result.getProductType());
        productTypeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoContainer.add(productTypeLabel);

        // --- PRODUCT VERSION ---
        IphoneInfoLabel productVersionLabel = new IphoneInfoLabel(
                Constants.PRODUCT_VERSION.get().toString() + result.getProductVersion());
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
