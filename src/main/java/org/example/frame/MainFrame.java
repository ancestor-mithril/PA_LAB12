package org.example.frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * se deseneaza panelurile necesare si sunt pozitionate.
     */
    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);
        add(controlPanel, BorderLayout.NORTH);
        add(designPanel, BorderLayout.CENTER);

        pack();
    }
}
