package serverConnect;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class OutputStream implements Runnable {

	private BufferedWriter out;
	private Socket serverSocket;
	private String message;

	public OutputStream() {
		this.serverSocket = ServerConnection.getServer();
		try {
			setOut(new BufferedWriter(new OutputStreamWriter(
					serverSocket.getOutputStream())));
		} catch (IOException e) {
			System.out.println("IOException:\n" + e.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				synchronized (this) {
					this.wait();
					out.write(message);
					out.newLine();
					out.flush();
				}
			}

		} catch (IOException e) {
			System.out.println("IOException:\n" + e.toString());
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException:\n" + e.toString());
			e.printStackTrace();
		}
	}

	public BufferedWriter getOut() {
		return out;
	}

	public void setOut(BufferedWriter out) {
		this.out = out;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void addUser(String surname, String name, String birthdate,
			String email, String nickname, String pw) {
		ServerConnection.sendMessage("NEWUSER;" + pw + ";" + nickname + ";"
				+ email + ";" + birthdate + ";" + name + ";" + surname);

	}

	public void getFriends(String user) {
		ServerConnection.sendMessage("FRIENDLIST;" + user);
	}
}
