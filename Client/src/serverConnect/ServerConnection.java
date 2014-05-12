package serverConnect;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConnection {

	public final static int UnknownHostException = 1;
	public final static int IOException = 2;
	private static InputStream in;
	private static OutputStream out;
	private static Socket server;
	private String ip;
	private int port;

	public ServerConnection(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public int establishConnection() {

		try {
			ServerConnection.server = new Socket(ip, port);

			ServerConnection.setIn(new InputStream());
			new Thread(ServerConnection.getIn()).start();
			ServerConnection.setOut(new OutputStream());
			new Thread(ServerConnection.getOut()).start();

		} catch (UnknownHostException e) {
			System.out.println("UnkownHostException:\n" + e.toString());
			e.printStackTrace();
			return UnknownHostException;
		} catch (IOException e) {
			System.out.println("IOException:\n" + e.toString());
			e.printStackTrace();
			return IOException;
		}
		return 0;
	}

	public static InputStream getIn() {
		return in;
	}

	public static void setIn(InputStream in) {
		ServerConnection.in = in;
	}

	public static OutputStream getOut() {
		return out;
	}

	public static void setOut(OutputStream out) {
		ServerConnection.out = out;
	}

	public static Socket getServer() {
		return server;
	}

	public static void setServer(Socket server) {
		ServerConnection.server = server;
	}
}