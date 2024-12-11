package model;

import java.util.List;

import dao.GoalsDAO;

public class GetMutterListLogic {
	public List<Goal> execute() {
		GoalsDAO dao = new GoalsDAO();
		List<Goal> mutterList = dao.findMutterList();
		return mutterList;
		//	return dao.findAll();
	}
}
