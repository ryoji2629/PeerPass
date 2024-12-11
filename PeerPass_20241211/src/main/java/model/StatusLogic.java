package model;

import dao.GoalsDAO;

public class StatusLogic {

	public int execute(UserGoal useGoal) {
		GoalsDAO dao = new GoalsDAO();
		int ct = dao.statusCheck(useGoal);
		return ct;
	}
}

