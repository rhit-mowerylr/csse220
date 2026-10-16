package liveCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MyComponent extends JComponent {

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        drawTranslateRotate(g);
        drawSimplesquare(g);
        drawUsingColors(g);
        drawSomeText(g);
    }

    private void drawTranslateRotate(Graphics g){
        Graphics2D g2d= (Graphics2D) g;
        Rectangle2D rect= new Rectangle2D.Double(150, 300, 150, 40);
        g2d.fill(rect);
        int xOffset = 200;
        int yOffset=0;
        g2d.translate(xOffset, yOffset);
        g2d.fill(rect);
        g2d.rotate(30*Math.PI/100);
        g2d.fill(rect);

        g2d.rotate(-30*Math.PI/100);
        g2d.translate(xOffset, yOffset);
        for (int angleDegrees=0; angleDegrees <=180; angleDegrees+=30){
            Line2D line = new Line2D.Double(0,0, 100, 0);
            g2d.rotate(30*Math.PI/100);
            g2d.draw(line);

        }
    }


    private void drawSomeText(Graphics g){
        String message = "Are you ready for a good time?";
        Graphics2D g2d= (Graphics2D) g;
        Font orginalFont=g2d.getFont();
        g2d.setFont(new Font("Wingdings", Font.PLAIN, 24));
        g2d.setFont(orginalFont);
        g2d.drawString(message, 200, 450);

    }

    private void drawUsingColors(Graphics g){
        Graphics2D g2d= (Graphics2D)g;
        Color colorBlue= new Color(0, 176,255);
        g2d.setColor(colorBlue);
        Rectangle2D blueRect= new Rectangle2D.Double(100,100,50,50);
        g2d.fill(blueRect);
        g2d.setColor(new Color(125, 6, 6));
        Ellipse2D redCircle= new Ellipse2D.Double(300,100,75,75);
        g2d.fill(redCircle);
    }

    private void drawSimplesquare(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        int width=20;
        int x=5;
        int y=5;
        Rectangle2D rect= new Rectangle2D.Double(x, y, width, width);
        g2d.draw(rect);
    }

}
