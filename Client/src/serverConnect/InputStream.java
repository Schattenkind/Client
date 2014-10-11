package serverConnect;

import gui.GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import client.Client;

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
				GUI.infoDialog("Success", "Login was correct!");
			} else {
				GUI.infoDialog("Failure",
						"Login was incorrect, please try again!");
			}
		} else if (command.equals("PING")) {

		}
	}
}
