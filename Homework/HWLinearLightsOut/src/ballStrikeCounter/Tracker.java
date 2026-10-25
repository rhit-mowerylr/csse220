package ballStrikeCounter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *  A Tracker is the main application that demos a Baseball state tracker.
 * 
 * 
 *************************************************************************************** 
 *         REQUIRED HELP CITATION
 * 
 *         DONE: cite your help here or say "only used CSSE220 materials"
 *         "only used CSSE220 Materials"
 *************************************************************************************** 
 *         DONE: List each team member's name and email username here.
 *
 * @author First Student - Luke Mowery mowerylr@rose-hulman.edu
 * @author Second Student - Will Gebelein gebeleinwj@rose-hulman.edu
 *************************************************************************************** 
 */

public class Tracker {
	public int numBalls=0;
	public int numStrikes=0;

	private JLabel label = new JLabel();

	// Call this to update the text on the label.
	public void updateLabel(int numBalls, int numStrikes) {
		this.label.setText("<html>Balls: " + numBalls + "<br />Strikes: " + numStrikes + "</HTML>");

	}

	public static void main(String[] args) {
		new Tracker();
	}

	public Tracker() {


		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.add(label, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		// DONE: Add buttons and listeners to make things work.
		JButton addball = new JButton("Ball");
		addball.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//passes in the number from the dropdown list
				numBalls+=1;
				if (numBalls==4){
					numBalls=0;
					numStrikes=0;
				}
				updateLabel(numBalls,numStrikes);
			}
		});
		panel.add(addball);

		JButton addStrike = new JButton("Strike");
		addStrike.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//passes in the number from the dropdown list
				numStrikes+=1;
				if (numStrikes==3){
					numBalls=0;
					numStrikes=0;
				}
				updateLabel(numBalls, numStrikes);
			}
		});
		panel.add(addStrike);




		// The following line is given to show you how to use the given method:
		updateLabel(0, 0);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
