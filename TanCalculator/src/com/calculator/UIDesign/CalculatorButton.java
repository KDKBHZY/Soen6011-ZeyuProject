package com.calculator.UIDesign;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonModel;
import javax.swing.JButton;
public class CalculatorButton extends JButton {
    public CalculatorButton(String string)
    {
        super(string);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        // set the rendering hints
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

        // set the border to null
        this.setBorder(null);

        // fill the background
        ButtonModel model = this.getModel();
        Color color;

        if (model.isArmed())
        {
            color = new Color(250, 250, 250);
        }
        else if (model.isRollover())
        {
            color = new Color(50, 50, 50);
        }
        else
        {
            color = new Color(82, 85, 87);
        }

        g2.setPaint(color);
        g2.fill(new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight()));

        // draw the string
        Font font = new Font("Arial Black", Font.BOLD, 30);
        g2.setFont(font);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(this.getText(), context);

        double x = (JButton.RIGHT == this.getHorizontalAlignment()) ?
                (this.getWidth() - bounds.getWidth() - 10) :
                ((this.getWidth() - bounds.getWidth()) / 2);
        double y = (this.getHeight() - bounds.getHeight()) / 2;

        double ascent = -bounds.getY();
        double baseY = y + ascent;

        if (model.isArmed())
        {
            color = new Color(253, 253, 253);
        }
        else
        {
            color = new Color(251, 251, 251);
        }

        g2.setPaint(color);
        g2.drawString(this.getText(), (int) x, (int) baseY);
    }
}
