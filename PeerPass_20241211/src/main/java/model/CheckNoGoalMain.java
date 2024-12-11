package model;

public class CheckNoGoalMain {

	private String error;

	public CheckNoGoalMain() {
		error = ""; // エラーメッセージ文頭のnullを消すため
	}

	public String checkAll(String goal) {
		checkGoal(goal);
		return error;
	}

	// 文字列を受け取って空かどうか判定するメソッド
	private void checkNull(String target, String targetName) {
		if (target == null || target.strip().isEmpty()) {
			error += targetName + "が入力されていません。<br>";
		}
	}

	//最大文字数を超えていないかを判断するメソッド
	private void checkOver(String target, String targetName, int maxLength) {
		if (target != null && target.length() > maxLength) {
			error += targetName + "が最大文字数を超えています（最大 " + maxLength + " 文字）。<br>";
		}
	}

	private void checkGoal(String goal) {
		checkNull(goal, "目標内容");
		checkOver(goal, "目標内容", 30);
	}

}
