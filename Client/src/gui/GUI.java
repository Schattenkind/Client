package gui;

import javax.swing.JOptionPane;

public class GUI {

	public static void errorDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	public static void infoDialog(String title, String message) {

		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static String inputDialog(String title, String message) {
		String input = JOptionPane.showInputDialog(null, message, title,
				JOptionPane.QUESTION_MESSAGE);
		return input;
	}
}
