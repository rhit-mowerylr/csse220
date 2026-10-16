import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * Draws a Hound and Fox on a graphics area.
 *
 * @author Ian Ludden, adapted from HousesComponent by Matt Boutell
 */
public class HoundComponent extends JComponent {

    /**
     * Draws Hound and Fox objects to the screen.
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2 = (Graphics2D) graphics;
        Rectangle2D face = new Rectangle2D.Double(0, 0, 600, 800);
        graphics2.draw(face);
        graphics2.setColor(Color.CYAN);
        graphics2.fill(face);

        Color foxOrange = new Color(195, 88, 23);
        Color HoundBrown =new Color(124, 71, 0);// C35817 in hex
        Hound Hound1 = new Hound(150, 150, HoundBrown);
        Hound1.drawOn(graphics2);

        // There are also many built-in colors in the Color class.
        Fox fox2 = new Fox(300, 400, foxOrange);
        fox2.drawOn(graphics2);

    }
}

