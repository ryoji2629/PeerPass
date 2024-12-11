package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckLogin;
import model.LoginLogic;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//エラーメッセージをリクエストスコープにあげてクリアする
		String error = (String) session.getAttribute("error");
		session.removeAttribute("error");
		request.setAttribute("error", error);
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		// ログイン処理の実行
		User user = new User();
		user.setMail(mail);
		user.setPass(pass);
		LoginLogic ll = new LoginLogic();
		boolean result = ll.execute(user);
		// ログイン処理の成否によって処理を分岐
		
		 // リクエストパラメータの値を引数で渡してエラーメッセージを受け取る
		CheckLogin checkRegistrationForm = new CheckLogin();
        String error = checkRegistrationForm.checkAll(mail, pass, result);
        
		if (result) { // ログイン成功時
			//成功メッセージ
			String success = "ログインに成功しました。";
			
			// セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("success", success);
			// フォワード(変更前）
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/noGoalMain.jsp");
//			dispatcher.forward(request, response);
			//リダイレクト（変更後）
			response.sendRedirect("ChoiceServlet");
		} else { // ログイン失敗時

			//エラーメッセージ(変更前）
//			String error = "ログインに失敗しました";
		
			//エラーメッセージ(変更後）
			
			// セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("error", error);
			// リダイレクト
			response.sendRedirect("LoginServlet");
		}
	}
}