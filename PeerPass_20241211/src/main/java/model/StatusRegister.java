package model;

import dao.GoalsDAO;

public class StatusRegister {
	public boolean execute(Goal goal) {
		GoalsDAO dao = new GoalsDAO();
		// メソッドの戻り値を確認
		int rowsUpdated = dao.editStatus(goal);
		if (rowsUpdated == 1) {
			return true; // 成功したかどうかを返す
		} else {
			return false;
		}
	}
}
