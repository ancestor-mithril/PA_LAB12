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

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        componentList=new ArrayList<>();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    /**
     * Appends the specified component to the end of this container.
     * This is a convenience method for {@link #addImpl}.
     * <p>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param comp the component to be added
     * @return the component argument
     * @throws NullPointerException if {@code comp} is {@code null}
     * @see #addImpl
     * @see #invalidate
     * @see #validate
     * @see JComponent#revalidate()
     */
    @Override
    public Component add(Component comp) {
        componentList.add(comp);
        //System.out.println(componentList);
        int absoluteHeight=componentList.size()/10;
        int absoluteWidth=componentList.size()%10;
        comp.setBounds(10+absoluteWidth*100, 10+absoluteHeight*50, 80, 40);
        return super.add(comp);
    }
}
