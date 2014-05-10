package client;

import java.util.Scanner;

import serverConnect.ServerConnection;

public class Client {

	private ServerConnection server;

	public Client() {
		setServer(new ServerConnection("192.168.178.32", 1234));
	}

	public synchronized ServerConnection getServer() {
		return server;
	}

	public synchronized void setServer(ServerConnection server) {
		this.server = server;
	}

	public static void main(String[] args) {

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
