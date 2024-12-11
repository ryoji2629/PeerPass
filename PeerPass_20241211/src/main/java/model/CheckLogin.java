package model;

public class CheckLogin {
	private String error;

	public CheckLogin() {
		error = ""; // エラーメッセージ文頭のnullを消すため
	}

	public String checkAll(String mail, String pass, boolean result) {
		checkMail(mail);
		checkPass(pass);
		checkMatch(result);
		return error;
	}

	// 文字列を受け取って空かどうか判定するメソッド
	private void checkNull(String target, String targetName) {
		if (target == null || target.strip().isEmpty()) {
			error += targetName + "が入力されていません。<br>";
		}
	}

	// パスワードとメールアドレスが一致するか確認するメソッド
	private void checkMatch(boolean result) {
		if (error == "" && result == false) {
			error += "メールアドレスまたは、パスワードが正しくありません。<br>";
		}
	}

	private void checkMail(String name) {
		checkNull(name, "メールアドレス");
	}

	private void checkPass(String pass) {
		checkNull(pass, "パスワード");
	}

}
