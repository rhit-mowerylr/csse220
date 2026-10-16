package simulationObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.*;

import java.awt.geom.Ellipse2D;
import javax.swing.*;
import java.util.Random;

public class ChargedParticle extends Particle {
    Random r = new Random();
    Color c1 = new Color( r.nextInt(255),  r.nextInt(255),  r.nextInt(255) );
    Color c2 = new Color( r.nextInt(255),  r.nextInt(255),  r.nextInt(255) );
    Color c3 = new Color( r.nextInt(255),  r.nextInt(255),  r.nextInt(255) );

    private int width=10;
    private int ring_height= 4*10;
    private int ring_width=4*10;
    private int height= 10;

    public ChargedParticle(int x, int y){
        super(x,y);
        this.setColor(c1);

    }


    public void drawOn(Graphics2D g) {
        super.drawOn(g);
        g.setColor(c2);
        g.drawOval(centerX-width/2, centerY-ring_height/2, width, ring_height);
        g.setColor(c3);
        g.drawOval( centerX-ring_width/2, centerY-height/2, ring_width, height);

    }

    public void bounce(SimulationObject other) {
        super.bounce(other);
        super.setColor(new Color(r.nextInt(255),  r.nextInt(255),  r.nextInt(255)));
        c2= new Color(r.nextInt(255),  r.nextInt(255),  r.nextInt(255));
        c3= new Color(r.nextInt(255),  r.nextInt(255),  r.nextInt(255));

    }
}
