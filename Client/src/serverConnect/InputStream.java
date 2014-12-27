package serverConnect;

import gui.FriendListFrame;
import gui.GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import client.Client;
import client.User;

public class InputStream implements Runnable {

	private BufferedReader in;
	private Socket serverSocket;

	public InputStream() {
		this.serverSocket = ServerConnection.getServer();
	}

	@Override
	public void run() {
		try {
			setIn(new BufferedReader(new InputStreamReader(
					serverSocket.getInputStream())));
			while (true) {
				String incoming = in.readLine();

				processInput(incoming);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	private void processInput(String incoming) {
		String[] split = incoming.split(";");
		String command = split[0].toUpperCase();
		if (command.equals("MESSAGE")) {

		} else if (command.equals("LOGIN")) {
			if (split[1].equals("TRUE")) {
				Client.getLogin().getFrame().dispose();
				Client.setUser(new User(split[2]));
				Client.getUser().retrieveInformation();
				Client.getUser().retrieveFriendList();
				new FriendListFrame();
			} else {
				GUI.infoDialog("Failure",
						"Login was incorrect, please try again!");
			}
		} else if (command.equals("PING")) {

		} else if (command.equals("NEWUSER")) {
			if (split[1].equals("TRUE")) {
				GUI.infoDialog("Success", "Registration was successfull!");
				Client.getLogin().register.getFrmRegister().dispose();
			} else if (split[1].equals("EXISTS")) {
				GUI.infoDialog("Username already in use!",
						"Username already in use! Please choose a different one!");
			} else if (split[1].equals("DATE")) {
				GUI.infoDialog("Invalid date",
						"You have entered a invalid date!");
			} else {
				GUI.errorDialog("FAILED",
						"Failed to register please make sure you filled in everything!");
			}

		} else if (command.equals("USERINFO")) {
			
		}
	}
}
