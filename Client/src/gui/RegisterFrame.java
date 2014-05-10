package gui;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterFrame implements ActionListener {

	private JFrame frmRegister;
	private JTextField textField_surname;
	private JTextField textField_name;
	private JTextField textField_birthdate;
	private JTextField textField_eMail;
	private JTextField textField_nickName;
	private JButton btnCancel;
	private JButton btnRegister;

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
		frmRegister.setBounds(100, 100, 450, 200);
		frmRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegister.setResizable(false);
		frmRegister.getContentPane().setLayout(new GridLayout(6, 2, 10, 10));

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

		}

	}

}
