package model;

import dao.UsersDAO;

public class ProfileEditLogic {
	public boolean execute(User user, User newUser) {
		UsersDAO dao = new UsersDAO();
		//バリデーション
		if (isValidNewUser(newUser)) {
			int rowsUpdated = dao.editProfile(user, newUser);
			if (rowsUpdated == 1) {
				return true;
			} 
		}else {
			return false;
		}
		return false;
	}
	
	private boolean isValidNewUser(User newUser) {
        if (newUser == null) {
            return false;
        }
        // プロフィール編集フォームがnullや空文字でないかをチェック
        if (newUser.getName() == null || newUser.getName().strip().isEmpty()) {
            return false;
        }
        
        return true;
    }
}
