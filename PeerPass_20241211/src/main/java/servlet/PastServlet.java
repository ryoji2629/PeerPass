package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetGoalListLogic;
import model.Goal;
import model.StatusRegister;
import model.User;

/**
 * Servlet implementation class PastServlet
 */
@WebServlet("/PastServlet")
public class PastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PastServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		//エラーメッセージをリクエストスコープにあげてクリアする
		//				HttpSession session = request.getSession();
		//				String error = (String) session.getAttribute("error");
		//				session.removeAttribute("error");
		//				request.setAttribute("error", error);
		//		 テストコード
		//		 int goalID, String goal, String registerDate, int goalAttribute, int userID
		//		Goal pastGoal = new Goal();
		//		pastGoal.setGoal("GOAL1");
		//		pastGoal.setGoalAttribute(1);
		//		pastGoal.setGoalID(1);
		//		HttpSession session = request.getSession();
		//		session.setAttribute("pastGoal", pastGoal);

		//ログインしているユーザーのセッションを取ってくる
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// ログインしているユーザーの目標をデータベースからすべて取ってくる
		GetGoalListLogic ggll = new GetGoalListLogic();
		List<Goal> goalList = ggll.execute(user);

		//目標のリストをセッションスコープにあげる
		session.setAttribute("goalList", goalList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/pastGoal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		int goalID = Integer.parseInt(request.getParameter("goalID"));
		int goalAttribute = Integer.parseInt(request.getParameter("goalAttribute"));
		Goal pastGoal = new Goal();
		pastGoal.setGoalID(goalID);
		pastGoal.setGoalAttribute(goalAttribute);
		// データベースの目標状態の更新
		StatusRegister sr = new StatusRegister();
		boolean result = sr.execute(pastGoal);
		if (result) {
			// 過去目標画面servletにリダイレクト
			response.sendRedirect("PastServlet");
		}
	}
}
