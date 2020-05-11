package org.example.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1000, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    List<Component> componentList;

    /**
     * constructor in care se initializeaza frame-ul, se coloreaza o imagine in alb, se seteaza dimensiunea preferata,
     * se initializeaza lista de copii desenati si se seteaza layout-ul null
     * @param frame => frame-ul tata
     */
    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        componentList=new ArrayList<>();
        setLayout(null);
    }

    /**
     * metoda din laboratorul 6
     * creaza o imagine alba cu dimensiunile preferate
     */
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    /**
     * metoda din laboratorul 6
     * deseneaza imaginea alba
     * @param g => imaginea grafica
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    /**
     * getter
     * @return => lista de componente
     */
    public List<Component> getComponentList() {
        return componentList;
    }
}
