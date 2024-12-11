package model;

public class Goal {
	private int goalID;
	private String goal;
	private String registerDate;
	private int goalAttribute;
	private int userId;
	private String userName;

	public Goal(int goalID, String goal, String registerDate, int goalAttribute, int userID) {
		this.goalID = goalID;
		this.goal = goal;
		this.registerDate = registerDate;
		this.goalAttribute = goalAttribute;
		this.userId = userID;
	}

	public Goal(String goal, String registerDate, int goalAttribute, int userID) {
		this.goal = goal;
		this.registerDate = registerDate;
		this.goalAttribute = goalAttribute;
		this.userId = userID;
	}

	public Goal() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getGoalID() {
		return goalID;
	}

	public void setGoalID(int goalID) {
		this.goalID = goalID;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public int getGoalAttribute() {
		return goalAttribute;
	}

	public void setGoalAttribute(int goalAttribute) {
		this.goalAttribute = goalAttribute;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}