package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import client.Client;

public class FriendListFrame implements ActionListener {

	private JFrame frmFriendList;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnOptions;
	private JMenuItem mntmAddFriend;
	private JMenuItem mntmEditProfile;

	public FriendListFrame() {
		initialize();
		frmFriendList.setVisible(true);
	}

	private void initialize() {
		frmFriendList = new JFrame();
		frmFriendList.setTitle("Client");
		frmFriendList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFriendList.setBounds(800, 200, 350, 600);

		menuBar = new JMenuBar();
		frmFriendList.setJMenuBar(menuBar);

		mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);

		mntmAddFriend = new JMenuItem("Add Friend");
		mntmAddFriend.addActionListener(this);
		mnOptions.add(mntmAddFriend);

		mntmEditProfile = new JMenuItem("Edit Profile");
		mntmEditProfile.addActionListener(this);
		mnOptions.add(mntmEditProfile);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frmFriendList.setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAddFriend) {
			GUI.inputDialog("Add Friend", "Enter the username: ");
		} else if (e.getSource() == mntmEditProfile) {
			new UserInfoFrame();
		}

	}

}
