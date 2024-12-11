package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetGoalLogic;
import model.GetMutterListLogic;
import model.Goal;
import model.StatusLogic;
import model.User;
import model.UserGoal;

/**
 * Servlet implementation class ChoiceServlet
 */
@WebServlet("/ChoiceServlet")
public class ChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChoiceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/test.jsp");
		//		dispatcher.forward(request, response);

		//セッションスコープでユーザー情報を取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		//今日の日付を取得
		LocalDate day = LocalDate.now();
		String today = day.toString();

		//ユーザーidを取得
		int userID = user.getUserID();

		//ステータス確認
		UserGoal useGoal = new UserGoal(userID, today);
		StatusLogic Sta = new StatusLogic();
		int status = Sta.execute(useGoal);
		System.out.println(status);

		// つぶやきリストをデータベースから取得､リクエストスコープに保存
		GetMutterListLogic gmll = new GetMutterListLogic();
		List<Goal> mutterList = gmll.execute();
		request.setAttribute("mutterList", mutterList);

		//ログインに成功したら、ステータス確認
		if (status == 1) {
			//成功メッセージをリクエストスコープにあげてクリアする
			String success = (String) session.getAttribute("success");
			session.removeAttribute("success");
			request.setAttribute("success", success);
			
			// ログインしているユーザーの目標をデータベースからすべて取ってくる
			GetGoalLogic ggl = new GetGoalLogic();
			Goal goal = ggl.execute(useGoal);

			//目標のリストをセッションスコープにあげる
			session.setAttribute("goal", goal);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/withGoalMain.jsp");
			dispatcher.forward(request, response);
		} else if (status == 2) {
			//成功メッセージをリクエストスコープにあげてクリアする
			String success = (String) session.getAttribute("success");
			session.removeAttribute("success");
			request.setAttribute("success", success);
			
			// ログインしているユーザーの目標をデータベースからすべて取ってくる
			GetGoalLogic ggl = new GetGoalLogic();
			Goal goal = ggl.execute(useGoal);

			//目標のリストをセッションスコープにあげる
			session.setAttribute("goal", goal);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/clearMain.jsp");
			dispatcher.forward(request, response);
		} else if (status == 3) {
			//成功メッセージをリクエストスコープにあげてクリアする
			String success = (String) session.getAttribute("success");
			session.removeAttribute("success");
			request.setAttribute("success", success);
			
			// ログインしているユーザーの目標をデータベースからすべて取ってくる
			GetGoalLogic ggl = new GetGoalLogic();
			Goal goal = ggl.execute(useGoal);

			//目標のリストをセッションスコープにあげる
			session.setAttribute("goal", goal);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/failMain.jsp");
			dispatcher.forward(request, response);
		} else {
			//成功メッセージをリクエストスコープにあげてクリアする
			String success = (String) session.getAttribute("success");
			session.removeAttribute("success");
			request.setAttribute("success", success);
			
			//エラーメッセージをリクエストスコープにあげてクリアする
			String error = (String) session.getAttribute("error");
			session.removeAttribute("error");
			request.setAttribute("error", error);
			
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/noGoalMain.jsp");
			dispatcher.forward(request, response);

		}

	}

}
