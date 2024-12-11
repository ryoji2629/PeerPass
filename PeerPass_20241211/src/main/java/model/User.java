package model;

public class User {
	private int userID;
	private String name;
	private String mail;
	private String pass;

	public User() {
		this.mail = null;
		this.pass = null;
		this.userID = Integer.MIN_VALUE;
		this.name = null;
	}

	public User(int userID, String name, String mail, String pass) {
		this.mail = mail;
		this.pass = pass;
		this.userID = userID;
		this.name = name;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
