/**
 * Runs the Linear Lights Out application.
 *
 ***************************************************************************************
 *         REQUIRED HELP CITATION
 *         Utilized the Copilot LLM.
 ***************************************************************************************
 * @author Will Gebelein - gebelewj
 * @author Luke Mowery - mowerylr
 ***************************************************************************************
 */
package linearLightsOut;
import java.awt.*;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LinearMain {

	private JFrame frame;
	private JButton[] buttonArray;
	private JButton newGameButton;
	private JButton quitButton;
	private JButton customStartButton;//phase two
	private Random rand;

	public LinearMain(int nButtons) {
		this.rand = new Random();

		frame = new JFrame("Linear Lights Out!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JPanel gamePanel = new JPanel(new GridLayout(1, nButtons, 5, 5));
		buttonArray = new JButton[nButtons];

		for (int i = 0; i < nButtons; i++) {
			JButton button = new JButton();
			buttonArray[i] = button;

			int index = i;

			button.addActionListener(e -> {
				toggle(index);

				if (index > 0) {
					toggle(index - 1);
				}

				if (index < buttonArray.length - 1) {
					toggle(index + 1);
				}

				checkForWin();
			});

			gamePanel.add(button);
		}

		JPanel controlPanel = new JPanel();

		newGameButton = new JButton("New Game");
		quitButton = new JButton("Quit");

		newGameButton.addActionListener(e -> startNewGame());

		quitButton.addActionListener(e -> System.exit(0));

		controlPanel.add(newGameButton);
		controlPanel.add(quitButton);

		frame.add(gamePanel, BorderLayout.CENTER);
		frame.add(controlPanel, BorderLayout.SOUTH);
		customStartButton = new JButton("Custom Start");

		customStartButton.addActionListener(e -> customStart());

		controlPanel.add(newGameButton);
		controlPanel.add(customStartButton);
		controlPanel.add(quitButton);

		startNewGame();

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void toggle(int index) {
		if (buttonArray[index].getText().equals("X")) {
			buttonArray[index].setText("O");
		} else {
			buttonArray[index].setText("X");
		}
	}
	private void customStart() {

		String config = JOptionPane.showInputDialog(
				frame,
				"Enter " + buttonArray.length
						+ " values using X and O.\nExample: XOXOOX");

		if (config == null) {
			return;
		}

		config = config.trim().toUpperCase();

		if (config.length() != buttonArray.length) {
			JOptionPane.showMessageDialog(
					frame,
					"You must enter exactly "
							+ buttonArray.length + " characters.");
			return;
		}

		for (int i = 0; i < config.length(); i++) {

			char c = config.charAt(i);

			if (c != 'X' && c != 'O') {
				JOptionPane.showMessageDialog(
						frame,
						"Only X and O are allowed.");
				return;
			}

			buttonArray[i].setText(String.valueOf(c));
		}

		checkForWin();
	}
	private void startNewGame() {
		frame.setTitle("Linear Lights Out!");

		for (JButton button : buttonArray) {
			if (rand.nextBoolean()) {
				button.setText("X");
			} else {
				button.setText("O");
			}
		}
	}

	private void checkForWin() {
		String first = buttonArray[0].getText();

		for (JButton button : buttonArray) {
			if (!button.getText().equals(first)) {
				return;
			}
		}

		frame.setTitle("We have a winner!");
		JOptionPane.showMessageDialog(frame,
				"Congratulations! You won!");
	}

	public static void main(String[] args) {

		String nButtonsString =
				JOptionPane.showInputDialog(
						"How many buttons would you like?");

		int nButtons = Integer.parseInt(nButtonsString);

		if (nButtons < 3) {
			nButtons = 3;
		}

		new LinearMain(nButtons);
	}
}
