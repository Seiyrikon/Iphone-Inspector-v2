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

import components.combobox.ColorTypeComboBox;
import components.combobox.StorageTypeComboBox;
import components.labels.Imei2Label;
import components.labels.ImeiLabel;
import components.labels.IphoneInfoLabel;
import components.labels.ModelNoLabel;
import components.labels.ProductNameLabel;
import components.labels.ProductTypeLabel;
import components.labels.ProductVersionLabel;
import components.labels.ScanButtonIconLabel;
import components.labels.ScanButtonTextLabel;
import components.labels.SerialNoLabel;
import components.textfields.EidTextField;
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
    ColorTypeComboBox colorDropdown = null;

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

        //checks if there is a device currently connected
        // if (device.output.isBlank() && device.error.isBlank()) {
        //     System.out.println("No Device Detected!");
        //     return;
        // }

        IphoneModel result = deviceService.extractInfo();

        // Helper method for spacing
        final int SPACING = 10;

        // --- EID ---
        CommonGroupPanel eidPanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.EID.get()), new EidTextField());
        infoContainer.add(eidPanel);
        
        if(Constants.IPHONE_8.get().equals(result.getProductType()) 
            || Constants.IPHONE_8_PLUS.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone8And8PlusColors());
        } else if(Constants.IPHONE_X.get().equals(result.getProductType()) 
            || Constants.IPHONE_XS.get().equals(result.getProductType()) 
            || Constants.IPHONE_XS_MAX.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphoneXAndXsAndXsMaxColors());
        } else if(Constants.IPHONE_XR.get().equals(result.getProductType())) {
            colorDropdown = new ColorTypeComboBox(result.getIphoneXrColors());
        } else if(Constants.IPHONE_11.get().equals(result.getProductType())) {
            colorDropdown = new ColorTypeComboBox(result.getIphone11Colors());
        } else if(Constants.IPHONE_11_PRO.get().equals(result.getProductType()) 
            || Constants.IPHONE_11_PRO_MAX.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone11ProAnd11ProMaxColors());
        } else if(Constants.IPHONE_12.get().equals(result.getProductType()) 
            || Constants.IPHONE_12_MINI.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone12And12MiniColors());
        } else if(Constants.IPHONE_12_PRO.get().equals(result.getProductType()) 
            || Constants.IPHONE_12_PRO_MAX.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone12ProAnd12ProMaxColors());
        } else if(Constants.IPHONE_13.get().equals(result.getProductType()) 
            || Constants.IPHONE_13_MINI.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone13Ad13MiniColors());
        } else if(Constants.IPHONE_13_PRO.get().equals(result.getProductType()) 
            || Constants.IPHONE_13_PRO_MAX.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone13ProAnd13ProMaxColors());
        } else if(Constants.IPHONE_SE.get().equals(result.getProductType())) {
            colorDropdown = new ColorTypeComboBox(result.getIphoneSeColors());
        } else if(Constants.IPHONE_14.get().equals(result.getProductType()) 
            || Constants.IPHONE_14_PLUS.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone14And14PlusColors());
        } else if(Constants.IPHONE_14_PRO.get().equals(result.getProductType()) 
            || Constants.IPHONE_14_PRO_MAX.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone14ProAnd14ProMaxColors());
        } else if(Constants.IPHONE_15.get().equals(result.getProductType()) 
            || Constants.IPHONE_15_PLUS.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone15And15PlusColors());
        } else if(Constants.IPHONE_15_PRO.get().equals(result.getProductType()) 
            || Constants.IPHONE_15_PRO_MAX.get().equals(result.getProductType())) {
                colorDropdown = new ColorTypeComboBox(result.getIphone15ProAnd15ProMaxColors());
        }

        // --- COLOR TYPE ---
        CommonGroupPanel colorPanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.COLOR_TYPE.get()), colorDropdown);
        infoContainer.add(colorPanel);

        // --- STORAGE TYPE ---
        CommonGroupPanel storageTypePanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.STORAGE_TYPE.get()), new StorageTypeComboBox(result.getStorageTypes()));
        infoContainer.add(storageTypePanel);

        // --- IMEI ---
        CommonGroupPanel imeiPanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.IMEI.get()), new ImeiLabel(result.getImei()));
        infoContainer.add(imeiPanel);

        // --- IMEI2 ---
        CommonGroupPanel imei2Panel = new CommonGroupPanel(new IphoneInfoLabel(Constants.IMEI2.get()), new Imei2Label(result.getImei2()));
        infoContainer.add(imei2Panel);

        // --- SERIAL NO ---
        CommonGroupPanel serialNoPanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.SERIAL_NUMBER.get()), new SerialNoLabel(result.getSerialNo()));
        infoContainer.add(serialNoPanel);

        // --- MODEL NO ---
        CommonGroupPanel modelNoPanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.MODEL_NUMBER.get()), new ModelNoLabel(result.getModel()));
        infoContainer.add(modelNoPanel);

        // --- PRODUCT NAME ---
        CommonGroupPanel productNamePanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.PRODUCT_NAME.get()), new ProductNameLabel(result.getProductName()));
        infoContainer.add(productNamePanel);

        // --- PRODUCT TYPE ---
        CommonGroupPanel productTypePanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.PRODUCT_TYPE.get()), new ProductTypeLabel(result.getProductType()));
        infoContainer.add(productTypePanel);

        // --- PRODUCT VERSION ---
        CommonGroupPanel productVersionPanel = new CommonGroupPanel(new IphoneInfoLabel(Constants.PRODUCT_VERSION.get()), new ProductVersionLabel(result.getProductVersion()));
        infoContainer.add(productVersionPanel);

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
