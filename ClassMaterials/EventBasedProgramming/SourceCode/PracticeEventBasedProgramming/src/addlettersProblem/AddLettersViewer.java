package addlettersProblem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddLettersViewer {

	public static void main(String[] args) {
		new AddLettersViewer();
	}
	
	public AddLettersViewer() {	
		JFrame frame = new JFrame();

		// put your new JButtons, JLabels, etc here

		JLabel textOutput = new JLabel("> ");
		JButton a = new JButton("Add A");
		JButton b = new JButton("Add B");
		JButton c = new JButton("Add C");


		JPanel panel = new JPanel();
		panel.add(a, BorderLayout.WEST);
		panel.add(b);
		panel.add(c, BorderLayout.EAST);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(a);
		buttonPanel.add(b);
		buttonPanel.add(c);
		panel.add(buttonPanel);

		a.addActionListener(new AddListener(textOutput, "A"));
		b.addActionListener(new AddListener(textOutput, "B"));
		c.addActionListener(new AddListener(textOutput, "C"));

		frame.add(textOutput, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
