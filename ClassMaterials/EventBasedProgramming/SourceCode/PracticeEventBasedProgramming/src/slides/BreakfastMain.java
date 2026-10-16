package slides;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class demonstrates ActionListeners.
 * 
 * @author Curt Clifton. Created Oct 7, 2008.
 */
public class BreakfastMain {

	/**
	 * Starts the program.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		// Note that it's a little complicated to create inner classes
		// if you're in a static function.  To avoid a bit of this 
		// complexity, we're initializing an instance of a class.
		BreakfastMain main = new BreakfastMain();
		main.createWindows();
	}
	
	
	public void createWindows() {
		/*
		 * TODO: Use JOptionPane to get description of porridge flavor; update
		 * inner classes to use the String.
		 */
		JFrame frame = new JFrame();
		frame.setTitle("Breakfast for Goldilocks");

		JPanel panel =new JPanel();
		JButton eatButton = new JButton("Eat Porridge");
		panel.add(eatButton);
		frame.add(panel);
		// TODO: add an ActionListener using an external class
		ActionListener papaBear = new PapaBearListener();
		eatButton.addActionListener(papaBear);

		// TODO: add an ActionListener using an inner class
		class MamaBearListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ouch, too hot");
			}
		}

		ActionListener mamaBear= new MamaBearListener();
		eatButton.addActionListener(mamaBear);

		// TODO: add an ActionListener using an anonymous class

		eatButton.addActionListener(new ActionListener(){
			// inside thesese outer curly braces.
			// we define an anoymous unamed ActionLsistener
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("Yum, just right");
			}
		});

		/*
		 * CONSIDER: pack() sets the size of the frame based on what we've put
		 * in it:
		 */
		frame.pack();
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	


}
