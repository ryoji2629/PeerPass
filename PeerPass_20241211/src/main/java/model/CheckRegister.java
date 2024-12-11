package model;

public class CheckRegister {
	private String error;

	public CheckRegister() {
		error = ""; // エラーメッセージ文頭のnullを消すため
	}

	public String checkAll(String mail, String pass, String name, boolean result) {
		checkMail(mail);
		chackName(name);
		checkPass(pass);
		checkExistence(result);

		return error;
	}

	// 文字列を受け取って空かどうか判定するメソッド
	private void checkNull(String target, String targetName) {
		if (target == null || target.strip().isEmpty()) {
			error += targetName + "が入力されていません。<br>";
		}
	}

	// メールアドレスが一意か判断するメソッド
	private void checkExistence(boolean result) {
		if (error == "" && result == false) {
			error += "すでにこのメールアドレスは登録されています。<br>";
		}
	}

	//最大文字数を超えていないかを判断するメソッド
	private void checkOver(String target, String targetName, int maxLength) {
		if (target != null && target.length() > maxLength) {
			error += targetName + "が最大文字数を超えています（最大 " + maxLength + " 文字）。<br>";
		}
	}

	private void checkMail(String mail) {
		checkNull(mail, "メールアドレス");
		checkOver(mail, "メールアドレス", 70);

		if (mail != null && !mail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			error += "メールアドレスの形式が正しくありません。<br>";
		}
	}

	private void chackName(String name) {
		checkNull(name, "ニックネーム");
		checkOver(name, "ニックネーム", 15);

	}

	private void checkPass(String pass) {
		checkNull(pass, "パスワード");
		checkOver(pass, "パスワード", 20);

		if (pass != null && pass.length() < 8) {
			error += "パスワードは8文字以上で入力してください。<br>";
		}
		if (pass != null && !pass.matches(".*[A-Z].*")) {
			error += "パスワードには少なくとも1つの大文字を含めてください。<br>";
		}
		if (pass != null && !pass.matches(".*[0-9].*")) {
			error += "パスワードには少なくとも1つの数字を含めてください。<br>";
		}
	}
}
