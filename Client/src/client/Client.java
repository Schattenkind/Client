package client;

import gui.LoginFrame;

import java.util.Scanner;

import serverConnect.ServerConnection;

public class Client {

	private static ServerConnection server;

	public Client() {
		new LoginFrame();
	}

	public synchronized ServerConnection getServer() {
		return server;
	}

	public synchronized static void setServer(ServerConnection server) {
		Client.server = server;
	}

	public static void main(String[] args) {

		new Client();
		@SuppressWarnings("resource")
		Scanner userinput = new Scanner(System.in);
		while (true) {
			String message = userinput.nextLine();
			ServerConnection.getOut().setMessage(message);
			synchronized (ServerConnection.getOut()) {
				ServerConnection.getOut().notify();
			}
		}
	}
}
