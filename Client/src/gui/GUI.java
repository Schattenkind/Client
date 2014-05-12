package gui;

import javax.swing.JOptionPane;

public class GUI {

	public static void errorDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, 0);
	}

	public static void infoDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, 1);
	}
}
