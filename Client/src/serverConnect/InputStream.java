package serverConnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

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

				System.out.println(incoming);
			}
		} catch (IOException e) {
			System.out.println("IOException:\n" + e.toString());
			e.printStackTrace();
		}

	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

}
