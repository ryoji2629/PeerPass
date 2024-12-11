package model;

public class UserGoal {
	private int userID;
	private String today;

	public UserGoal(int userID, String today ) {
		this.userID = userID;
		this.today = today;
	}

	public int getUserID() {
		return userID;
	}

	public String getToday() {
		return today;
	}
}