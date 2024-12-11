package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckUserEdit;
import model.ConversionPrevention;
import model.User;
import model.UserEditLogic;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラーメッセージをリクエストスコープにあげてクリアする
		HttpSession session = request.getSession();
		String error = (String) session.getAttribute("error");
		session.removeAttribute("error");
		request.setAttribute("error", error);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String pastMail = request.getParameter("pastEmail");
		String pastPass = request.getParameter("pastPass");
		String newMail = request.getParameter("newEmail");
		String newPass = request.getParameter("newPass");
		
		//エスケープ処理されたものを元に戻す
		ConversionPrevention cp = new ConversionPrevention();
		pastMail = cp.change(pastMail);
		pastPass = cp.change(pastPass);
		newMail = cp.change(newMail);
		newPass = cp.change(newPass);

		//ログインしているユーザーのセッションを取ってくる
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("user");

		// 現在のメールとパスワードがあっているかを確認	ログインロジックとやっていることは一緒なので流用
		User user = new User();
		user.setMail(pastMail);
		user.setPass(pastPass);
		UserEditLogic uel2 = new UserEditLogic();
		boolean result = uel2.loginInfoCheck(user, loginUser);

		// リクエストパラメータの値を引数で渡してエラーメッセージを受け取る
		CheckUserEdit checkRegistrationForm = new CheckUserEdit();
		String error = checkRegistrationForm.checkAll(pastMail, pastPass, newMail, newPass, result);

		// 現在のメールとパスワードがあっているかの成否によって処理を分岐
		if (result) { // 成功時
			// 新しいメールとパスに変更
			User newUser = new User();
			newUser.setMail(newMail);
			newUser.setPass(newPass);
			UserEditLogic uel = new UserEditLogic();
			boolean updateResult = uel.execute(user, newUser);
			if (updateResult) {
				//成功メッセージ
		  		String success = "ユーザー情報を編集しました。";
				session.setAttribute("success", success);
				
				//	ユーザー情報のセッションを更新
				User updateUser = (User) session.getAttribute("user");
				updateUser.setMail(newMail);
				updateUser.setPass(newPass);
				session.setAttribute("user", updateUser);

				// 過去目標画面servletにリダイレクト
				response.sendRedirect("ChoiceServlet");

			} else { // 失敗時
				// エラーメッセージを設定
				// セッションスコープにユーザーIDを保存
				session.setAttribute("error", error);
				
				// リダイレクト
				response.sendRedirect("UserEditServlet");
			}
		} else {
			// エラーメッセージを設定
			// セッションスコープにユーザーIDを保存
			session.setAttribute("error", error);

			// リダイレクト
			response.sendRedirect("UserEditServlet");
		}
	}

}
