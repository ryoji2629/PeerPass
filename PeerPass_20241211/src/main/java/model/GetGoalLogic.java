package model;

import dao.GoalsDAO;

public class GetGoalLogic {
	public Goal execute(UserGoal userGoal) {
		GoalsDAO dao = new GoalsDAO();
		Goal goal = dao.findGoal(userGoal);
		return goal;
		//	return dao.findAll();
	}
}
