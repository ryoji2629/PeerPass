
package model;

import dao.UsersDAO;

public class RegisterLogic {
	public boolean execute(User user) {
		UsersDAO dao = new UsersDAO();
		//userバリデーション
		if (isValidUser(user)) {
			// createメソッドの戻り値を確認
			boolean isSuccess = dao.create(user);
			return isSuccess; // 成功したかどうかを返す
		}else {
			return false;
		}
	}
	
	 // Userオブジェクトにバリデーションを行うメソッド
    private boolean isValidUser(User user) {
        if (user == null) {
            return false;
        }
        // 各フィールドがnullや空文字でないかをチェック
        if (user.getName() == null || user.getName().strip().isEmpty()) {
            return false;
        }
        if (user.getMail() == null || user.getMail().strip().isEmpty()) {
            return false;
        }
        if (user.getPass() == null || user.getPass().strip().isEmpty()) {
            return false;
        }
        
        // メールアドレスの形式が正しいかチェック
        if (!isValidEmail(user.getMail())) {
            return false;
        }
        
        // パスワードの形式が正しいかチェック
        if (!isValidPassword(user.getPass())) {
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