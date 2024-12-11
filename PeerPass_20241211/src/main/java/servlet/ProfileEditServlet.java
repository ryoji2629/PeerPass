package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckProfileEdit;
import model.ConversionPrevention;
import model.ProfileEditLogic;
import model.User;

/**
 * Servlet implementation class ProfileEditServlet
 */
@WebServlet("/ProfileEditServlet")
public class ProfileEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileEditServlet() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/profileEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String newName = request.getParameter("name");

		//エスケープ処理されたものを元に戻す
		ConversionPrevention cp = new ConversionPrevention();
		newName = cp.change(newName);

		
		// セッションから現在のUSER_NAMEを取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		// リクエストパラメータの値を引数で渡してエラーメッセージを受け取る
		CheckProfileEdit checkRegistrationForm = new CheckProfileEdit();
		String error = checkRegistrationForm.checkAll(newName);

		// 新しいメールとパスに変更
		User newUser = new User();
		newUser.setName(newName);
		ProfileEditLogic pel = new ProfileEditLogic();
		boolean updateResult = pel.execute(user, newUser);
		if (updateResult) {
	  		//成功メッセージ
	  		String success = "プロフィール情報を編集しました。";
			session.setAttribute("success", success);
			// ユーザー情報のセッションを更新
			User updateUser = (User) session.getAttribute("user");
			updateUser.setName(newName);
			session.setAttribute("user", updateUser);

			// 過去目標画面servletにリダイレクト
			response.sendRedirect("ChoiceServlet");

		}else {
			session.setAttribute("error", error);	
			// リダイレクト
			response.sendRedirect("ProfileEditServlet");
		}

	}

}
