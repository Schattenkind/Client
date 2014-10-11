package gui;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import serverConnect.ServerConnection;
import javax.swing.JPasswordField;

public class RegisterFrame implements ActionListener {

	private JFrame frmRegister;
	private JTextField textField_surname;
	private JTextField textField_name;
	private JTextField textField_birthdate;
	private JTextField textField_eMail;
	private JTextField textField_nickName;
	private JButton btnCancel;
	private JButton btnRegister;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JPasswordField passwordField_1;
	private JLabel lblConfirmPassword;

	/**
	 * Create the application.
	 */
	public RegisterFrame() {
		initialize();
		frmRegister.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setTitle("Register");
		frmRegister.setBounds(100, 100, 450, 300);
		frmRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegister.setResizable(false);
		frmRegister.getContentPane().setLayout(new GridLayout(8, 2, 10, 10));

		JLabel lblSurname = new JLabel("Surname:");
		frmRegister.getContentPane().add(lblSurname);

		textField_surname = new JTextField();
		frmRegister.getContentPane().add(textField_surname);
		textField_surname.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		frmRegister.getContentPane().add(lblName);

		textField_name = new JTextField();
		frmRegister.getContentPane().add(textField_name);
		textField_name.setColumns(10);

		JLabel lblBirthdate = new JLabel("Birthdate: (TT/MM/JJJJ)");
		frmRegister.getContentPane().add(lblBirthdate);

		textField_birthdate = new JTextField();
		frmRegister.getContentPane().add(textField_birthdate);
		textField_birthdate.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		frmRegister.getContentPane().add(lblEmail);

		textField_eMail = new JTextField();
		frmRegister.getContentPane().add(textField_eMail);
		textField_eMail.setColumns(10);

		JLabel lblNickname = new JLabel("Nickname:");
		frmRegister.getContentPane().add(lblNickname);

		textField_nickName = new JTextField();
		frmRegister.getContentPane().add(textField_nickName);
		textField_nickName.setColumns(10);

		lblPassword = new JLabel("Password:");
		frmRegister.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		frmRegister.getContentPane().add(passwordField);

		lblConfirmPassword = new JLabel("Confirm Password:");
		frmRegister.getContentPane().add(lblConfirmPassword);

		passwordField_1 = new JPasswordField();
		frmRegister.getContentPane().add(passwordField_1);

		btnCancel = new JButton("Cancel");
		frmRegister.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);

		btnRegister = new JButton("Register!");
		frmRegister.getContentPane().add(btnRegister);
		btnRegister.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			this.frmRegister.dispose();

		} else if (e.getSource() == btnRegister) {
			if (checkCorrectness()) {
				ServerConnection.getOut().addUser(textField_surname.getText(),
						textField_name.getText(),
						textField_birthdate.getText(),
						textField_eMail.getText(),
						textField_nickName.getText(), "1234");
			}
		}

	}

	private boolean checkCorrectness() {
		if (new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))){
			return true;
		}
		return false;
	}

}
