package gui;

import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;

class RoundPanelBorder extends AbstractBorder {
    Color color = new Color(0, 0, 0);
    int radius;

    RoundPanelBorder(int radius) {
        this.radius = radius;
    }

    void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(radius / 2));
        g2d.setColor(Color.darkGray);
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        super.paintBorder(c, g, x, y, width, height);
    }
}