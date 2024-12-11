package model;

import dao.GoalsDAO;

public class GoalLogic	 {
	public boolean execute(Goal goals) {
		GoalsDAO dao = new GoalsDAO();
      	if (isValidGoal(goals)) {
      		// createメソッドの戻り値を確認
      		boolean isSuccess = dao.create(goals);
      		return isSuccess; // 成功したかどうかを返す
      	}else {
      		return false;
      	}
    }
	
	// Goalオブジェクトにバリデーションを行うメソッド
	private boolean isValidGoal(Goal goals) {
		if (goals == null) {
            return false;
        }
		
		//フィールドがnullや空文字でないかをチェック
		if (goals.getGoal() == null || goals.getGoal().strip().isEmpty()) {
		    return false;
		}
		return true;
		
	}
}