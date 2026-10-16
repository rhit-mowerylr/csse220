import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

/**
 * Class representing a Hound, drawn as a rectangular face with triangular ears.
 *
 * @author Luke Mowery
 * <br>
 * **************************************************************************************
 * REQUIRED HELP CITATION
 *         DONE: cite your help here or say "only used CSSE220 materials"
 *         Used CSSE220 materials and SRT Help
 * **************************************************************************************
 */
public class Hound {

    private static final int HEIGHT = 160;
    private static final int WIDTH = 110;

    private static final int EAR_HEIGHT = 160+20;
    private static final int EAR_WIDTH = -50;
    private static final Color EAR_COLOR = Color.BLACK;

    // Color of the hound's face
    private Color color;

    // Coordinates for the hound's position, as the top-left corner of the face
    private int x;
    private int y;

    public Hound(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void drawOn(Graphics2D g2) {
        // Move the origin of the graphics context to the fox's position
        g2.translate(x, y);

        // DONE: Construct a Polygon for the hound face, then fill it with the hound's color.;
        Rectangle2D face = new Rectangle2D.Double(0, 0, WIDTH, HEIGHT);
        g2.draw(face);
        g2.setColor(color);
        g2.fill(face);

        // Draw the hound ears
        int[] leftEarXHoundPoints = {0, 0, EAR_WIDTH};
        int[] leftEarYHoundPoints = {0, EAR_HEIGHT, EAR_HEIGHT-30};

        int[] rightEarXHoundPoints = {WIDTH, WIDTH, WIDTH-EAR_WIDTH};
        int[] rightEarYHoundPoints = {0, EAR_HEIGHT, EAR_HEIGHT-30};


        // DONE: Construct Polygons for the left and right ears, then fill them with EAR_COLOR.
        Polygon leftEar = new Polygon(leftEarXHoundPoints, leftEarYHoundPoints, 3);
        Polygon rightEar = new Polygon(rightEarXHoundPoints, rightEarYHoundPoints, 3);
        g2.draw(leftEar);
        g2.setColor(EAR_COLOR);
        g2.fill(leftEar);
        g2.draw(rightEar);
        g2.setColor(EAR_COLOR);
        g2.fill(rightEar);
        // Undo translation
        g2.translate(-x, -y);
    }
}

