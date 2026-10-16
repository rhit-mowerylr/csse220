import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Draws a Hound and a Fox, via the HouComponent and Hound Cclasses.
 *
 * @author Luke Mowery
 */

public class HoundViewer {

    public static final Dimension Hound_VIEWER_SIZE = new Dimension(600, 800);

    /**
     * Constructs and displays the JFrame which displays Hound and Fox objects via a
     * FoxComponent object.
     *
     * @param args
     *            Command-line arguments, ignored here.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(Hound_VIEWER_SIZE);
        frame.setTitle("I see a hound and a fox!");

        frame.add(new HoundComponent());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
