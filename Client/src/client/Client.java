package client;

import gui.GUI;
import gui.LoginFrame;
import serverConnect.ServerConnection;

public class Client {

	private static ServerConnection server;
	private static LoginFrame loginscreen;

	public Client() {
		Client.server = new ServerConnection("192.168.178.32",
				1234);
		int a = server.establishConnection();
		if (a == 0) {
			GUI.infoDialog("Success", "Connection to server established!");
		} else {
			GUI.errorDialog("Connection error!",
					"Server is not reachable!\nPlease check your internet connection.");
		}
		setLogin(new LoginFrame());
	}

	public static ServerConnection getServer() {
		return server;
	}

	public static void setServer(ServerConnection server) {
		Client.server = server;
	}
	
	public static LoginFrame getLogin() {
		return loginscreen;
	}

	public static void setLogin(LoginFrame login) {
		Client.loginscreen = login;
	}

	public static void sendLoginRequest(String username, String pw){
		ServerConnection.sendMessage("LOGIN;"+username+";"+pw);
	}

	public static void main(String[] args) {

		new Client();
	}
}
