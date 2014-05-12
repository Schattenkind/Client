package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import serverConnect.ServerConnection;

public class LoginFrame implements ActionListener {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnRegisterHere;
	private JButton btnLogin;

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
		this.frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 400, 145);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(134, 11, 240, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(134, 42, 240, 20);
		frmLogin.getContentPane().add(passwordField);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 14, 89, 14);
		frmLogin.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 45, 89, 14);
		frmLogin.getContentPane().add(lblPassword);

		btnLogin = new JButton("Login!");
		btnLogin.setBounds(285, 73, 89, 23);
		frmLogin.getContentPane().add(btnLogin);
		btnLogin.addActionListener(this);

		btnRegisterHere = new JButton("Register here!");
		btnRegisterHere.setBounds(10, 73, 140, 23);
		frmLogin.getContentPane().add(btnRegisterHere);
		btnRegisterHere.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegisterHere) {
			new RegisterFrame();
		} else if (e.getSource() == btnLogin) {
			ServerConnection server = new ServerConnection("192.168.178.32",
					1234);
			int a = server.establishConnection();
			if (a == 0) {

			} else {
				GUI.errorDialog("Connection error!",
						"Server is not reachable!\nPlease check your internet connection.");
			}
		}
	}
}
