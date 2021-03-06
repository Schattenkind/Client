package gui;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import serverConnect.ServerConnection;

import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class RegisterFrame implements ActionListener {

	private JFrame frmRegister;
	private JTextField textField_surname;
	private JTextField textField_name;
	private JTextField textField_eMail;
	private JTextField textField_nickName;
	private JButton btnCancel;
	private JButton btnRegister;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JPasswordField passwordField_1;
	private JLabel lblConfirmPassword;
	private JPanel panel;
	private JComboBox<String> comboDay;
	private JComboBox<String> comboMonth;
	private JComboBox<String> comboYear;

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
		// set listbox values for birth date
		int amountOfYears = 50;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		String[] years = new String[amountOfYears];
		for (int i = 0; i < amountOfYears; i++) {
			int year = currentYear - amountOfYears + i;
			years[i] = Integer.toString(year);
		}
		String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12" };

		String[] days = new String[31];
		for (int i = 0; i < 31; i++) {
			days[i] = Integer.toString(i + 1);
		}

		frmRegister = new JFrame();
		frmRegister.setTitle("Register");
		frmRegister.setBounds(800, 200, 450, 360);
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

		JLabel lblBirthdate = new JLabel("Birth date:");
		frmRegister.getContentPane().add(lblBirthdate);

		panel = new JPanel();
		frmRegister.getContentPane().add(panel);

		comboDay = new JComboBox(days);
		comboDay.setMaximumRowCount(31);
		panel.add(comboDay);

		comboMonth = new JComboBox(months);
		comboMonth.setMaximumRowCount(12);
		panel.add(comboMonth);

		comboYear = new JComboBox(years);
		comboYear.setMaximumRowCount(amountOfYears);
		panel.add(comboYear);

		JLabel lblEmail = new JLabel("Email:");
		frmRegister.getContentPane().add(lblEmail);

		textField_eMail = new JTextField();
		frmRegister.getContentPane().add(textField_eMail);
		textField_eMail.setColumns(10);

		JLabel lblNickname = new JLabel("Username:");
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
			String birthdate = comboYear.getSelectedItem() + "-"
					+ comboMonth.getSelectedItem() + "-"
					+ comboDay.getSelectedItem();
			if (checkCorrectness()) {
				ServerConnection.getOut().addUser(textField_surname.getText(),
						textField_name.getText(), birthdate,
						textField_eMail.getText(),
						textField_nickName.getText(),
						new String(passwordField.getPassword()));
			} else {
				GUI.infoDialog("Password", "Password does not match!");
			}
		}

	}

	// TODO
	private boolean checkCorrectness() {
		if (new String(passwordField.getPassword()).equals(new String(
				passwordField_1.getPassword()))) {
			return true;
		}
		return false;
	}

	public JFrame getFrmRegister() {
		return frmRegister;
	}

	public void setFrmRegister(JFrame frmRegister) {
		this.frmRegister = frmRegister;
	}

}
