package client;

import java.util.Scanner;

import serverConnect.OutputStream;
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
		Client client = new Client();
		ServerConnection server = client.getServer();

		while (true) {
			String message = userinput.nextLine();
			server.getOut().setMessage(message);
			synchronized (server.getOut()) {
				server.getOut().notify();
			}
		}

	}
}
