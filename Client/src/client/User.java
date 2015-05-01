package client;

import java.util.List;

import serverConnect.ServerConnection;

public class User {
	private double id;
	private String username;
	private String email;
	private String birthdate;
	private String name;
	private String surname;

	private List<User> friends;

	public User(String username) {
		this.username = username;
	}

	public void retrieveInformation() {
		ServerConnection.sendMessage("USERINFO;" + username);
	}

	public void setUserInfo(String[] info) {
		this.id = Double.valueOf(info[1]);
		this.username = info[2];
		this.email = info[3];
		this.birthdate = info[4];
		this.name = info[5];
		this.surname = info[6];

	}

	public void retrieveFriendList() {

	}

	public void sendFriendRequest(String username, String friend) {

	}

	// setter,getter

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void addFriend(User friend) {
		this.friends.add(friend);
	}

}
