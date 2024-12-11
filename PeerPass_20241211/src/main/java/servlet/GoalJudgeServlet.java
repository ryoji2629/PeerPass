package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Goal;
import model.StatusRegister;

/**
 * Servlet implementation class GoalJudgeServlet
 */
@WebServlet("/GoalJudgeServlet")
public class GoalJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoalJudgeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		Goal goal = new Goal();
		goal.setGoalID(goalID);
		goal.setGoalAttribute(goalAttribute);
		// データベースの目標状態の更新
		StatusRegister sr = new StatusRegister();
		boolean result = sr.execute(goal);
		HttpSession session = request.getSession();
		if (result) {
			// 過去目標画面servletにリダイレクト
			System.out.println("目標可否確認サーブレット↓");
			System.out.println(goalAttribute);
			if (goalAttribute == 2 ) {
				//成功メッセージ
		  		String success = "クエストクリア！";
		  		session.setAttribute("success", success);
			}else {
				String success = "明日は頑張りましょう！";
				session.setAttribute("success", success);
			}
			response.sendRedirect("ChoiceServlet");
		}
	}

}
