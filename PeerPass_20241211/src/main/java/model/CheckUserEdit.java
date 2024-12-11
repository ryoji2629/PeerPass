package model;

public class CheckUserEdit {
	private String error;

	public CheckUserEdit() {
		error = ""; // エラーメッセージ文頭のnullを消すため
	}

	public String checkAll(String pastEmail, String pastPass, String newMail, String newPass, boolean result) {
		checkPastEmail(pastEmail);
		checkPastPass(pastPass);
		checkNewEmail(newMail);
		checkNewPass(newPass);
		checkMatch(result);

		return error;
	}

	// 文字列を受け取って空かどうか判定するメソッド
	private void checkNull(String target, String targetName) {
		if (target == null || target.strip().isEmpty()) {
			error += targetName + "が入力されていません。<br>";
		}
	}

	// 現在のパスワードとメールアドレスが一致するか確認するメソッド
	private void checkMatch(boolean result) {
		if (error == "" && result == false) {
			error += "現在のメールアドレスまたは、パスワードが正しくありません。<br>";
		}
	}

	//最大文字数を超えていないかを判断するメソッド
	private void checkOver(String target, String targetName, int maxLength) {
		if (target != null && target.length() > maxLength) {
			error += targetName + "が最大文字数を超えています（最大 " + maxLength + " 文字）。<br>";
		}
	}

	private void checkPastEmail(String pastEmail) {
		checkNull(pastEmail, "現在のメールアドレス");
		checkOver(pastEmail, "現在のメールアドレス", 70);
	}

	private void checkPastPass(String pastPass) {
		checkNull(pastPass, "現在のパスワード");
	}

	private void checkNewEmail(String newEmail) {
		checkNull(newEmail, "新しいメールアドレス");
		checkOver(newEmail, "新しいメールアドレス", 70);

		if (newEmail != null && !newEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			error += "新しいメールアドレスの形式が正しくありません。<br>";
		}
	}

	private void checkNewPass(String newPass) {
		checkNull(newPass, "新しいパスワード");

		if (newPass != null && newPass.length() < 8) {
			error += "新しいパスワードは8文字以上で入力してください。<br>";
		}
		if (newPass != null && !newPass.matches(".*[A-Z].*")) {
			error += "新しいパスワードには少なくとも1つの大文字を含めてください。<br>";
		}
		if (newPass != null && !newPass.matches(".*[0-9].*")) {
			error += "新しいパスワードには少なくとも1つの数字を含めてください。<br>";
		}
	}

}
