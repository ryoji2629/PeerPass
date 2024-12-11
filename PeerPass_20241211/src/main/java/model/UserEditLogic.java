package model;

import dao.UsersDAO;

//セッションのuserにあるメールとパスワードとフォーム
public class UserEditLogic {
	public boolean loginInfoCheck(User user, User loginUser) {
		boolean result = false;
		if (user.getMail().equals(loginUser.getMail()) && user.getPass().equals(loginUser.getPass())) {
			result = true;
		}
		return result;
	}

	public boolean execute(User user, User newUser) {
		UsersDAO dao = new UsersDAO();
		//userバリデーション
		if (isValidUserEdit(user, newUser)) {
			int rowsUpdated = dao.edit(user, newUser);
			if (rowsUpdated == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Userオブジェクトにバリデーションを行うメソッド
	private boolean isValidUserEdit(User user, User newUser) {
		if (user == null || newUser == null) {
			return false;
		}
		// 各フィールドがnullや空文字でないかをチェック
		if (user.getMail() == null || user.getMail().strip().isEmpty()) {
			return false;
		}
		if (user.getPass() == null || user.getPass().strip().isEmpty()) {
			return false;
		}
		if (newUser.getMail() == null || user.getMail().strip().isEmpty()) {
			return false;
		}
		if (newUser.getPass() == null || user.getPass().strip().isEmpty()) {
			return false;
		}

		// 新しいメールアドレスの形式が正しいかチェック
		if (!isValidEmail(newUser.getMail())) {
			return false;
		}

		// 新しいパスワードの形式が正しいかチェック
		if (!isValidPassword(newUser.getPass())) {
			return false;
		}

		return true;
	}

	// メールアドレスの形式が正しいかを確認するメソッド
	private boolean isValidEmail(String email) {
		// 正規表現を使用してメールアドレスの形式を確認
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		return email.matches(emailRegex);
	}

	// パスワードの形式が正しいかを確認するメソッド
	private boolean isValidPassword(String password) {
		// パスワードは最低8文字以上で、大文字、数字を含む必要がある
		if (password.length() < 8) {
			return false;
		}
		if (!password.matches(".*[A-Z].*")) { // 大文字が含まれているか
			return false;
		}
		if (!password.matches(".*[0-9].*")) { // 数字が含まれているか
			return false;
		}
		return true;
	}

}
