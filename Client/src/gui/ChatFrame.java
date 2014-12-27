package gui;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;

public class ChatFrame {
	
	private JFrame frmChat;

	public ChatFrame() {
		initialize();
		frmChat.setVisible(true);
	}

	private void initialize() {
		frmChat = new JFrame();
		frmChat.setTitle("Chat");
		frmChat.setBounds(800, 200, 450, 400);
		frmChat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnSend = new JButton("Send");
		
		JButton btnSmilies = new JButton("Smilies");
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmChat.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSmilies, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSend, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSend, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSmilies, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(10))
		);
		panel.setLayout(new GridLayout(2, 1, 10, 10));
		
		JEditorPane editorPane_message = new JEditorPane();
		panel.add(editorPane_message);
		
		JEditorPane editorPane_chat = new JEditorPane();
		panel.add(editorPane_chat);
		frmChat.getContentPane().setLayout(groupLayout);
	}
}
