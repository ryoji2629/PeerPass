package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckRegister;
import model.ConversionPrevention;
import model.RegisterLogic;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラーメッセージをリクエストスコープにあげてクリアする
		HttpSession session = request.getSession();
		String error = (String) session.getAttribute("error");
		session.removeAttribute("error");
		request.setAttribute("error", error);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String pass = request.getParameter("pass");
		//		System.out.println(pass);
		String mail = request.getParameter("mail");
		//		System.out.println(mail);
		String name = request.getParameter("name");
		//		System.out.println(name);
		
		//エスケープ処理されたものを元に戻す
		ConversionPrevention cp = new ConversionPrevention();
		pass = cp.change(pass);
		mail = cp.change(mail);
		name = cp.change(name);

		// 登録処理の実行
		User user = new User();
		user.setName(name);
		user.setMail(mail);
		user.setPass(pass);
		RegisterLogic rl = new RegisterLogic();
		boolean result = rl.execute(user);
		
		// リクエストパラメータの値を引数で渡してエラーメッセージを受け取る
		CheckRegister checkRegistrationForm = new CheckRegister();
		String error = checkRegistrationForm.checkAll(mail, pass, name, result);

		// 登録処理の成否によって処理を分岐
		if (result) { // 登録成功時
			//成功メッセージ
			String success = "アカウントの作成に成功しました。";
			request.setAttribute("success", success);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		} else { // 登録失敗時
			//エラーメッセージ
			request.setAttribute("error", error);
			// セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("error", error);
			// リダイレクト
			response.sendRedirect("RegisterServlet");
		}
	}
}