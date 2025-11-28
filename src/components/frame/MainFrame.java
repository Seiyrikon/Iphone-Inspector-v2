package components.frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import components.panels.BodyContainerPanel;
import components.panels.MainPanel;
import components.panels.SideBarPanel;
import components.panels.TitleBarPanel;

public class MainFrame extends JFrame {
    TitleBarPanel titleBar;
    SideBarPanel sideBar;
    BodyContainerPanel bodyContainer;
    MainPanel mainPanel;

    public MainFrame() {
        setUndecorated(true);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));

        mainPanel = new MainPanel();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        titleBar = new TitleBarPanel();
        sideBar = new SideBarPanel();
        bodyContainer = new BodyContainerPanel();

        setContentPane(mainPanel);

        mainPanel.add(titleBar, BorderLayout.NORTH);
        mainPanel.add(sideBar, BorderLayout.WEST);
        mainPanel.add(bodyContainer, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
