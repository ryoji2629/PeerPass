package model;

import java.util.List;

import dao.GoalsDAO;

public class GetGoalListLogic {
	public List<Goal> execute(User user) {
		GoalsDAO dao = new GoalsDAO();
		List<Goal> goalList = dao.findAllGoals(user);
		return goalList;
		//	return dao.findAll();
	}
}
