package model;

import dao.UsersDAO;

public class LoginLogic {
	public boolean execute(User login) {
		UsersDAO dao = new UsersDAO();
		User user = dao.findByLogin(login);

		//	return account != null;
		if (user.getName() != null)

			return true;
		else
			return false;
	}
}