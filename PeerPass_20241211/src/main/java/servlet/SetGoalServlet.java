package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckNoGoalMain;
import model.Goal;
import model.GoalLogic;
import model.User;

/**
 * Servlet implementation class SetGoalServlet
 */
@WebServlet("/SetGoalServlet")
public class SetGoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetGoalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String goalName = request.getParameter("goalName");
		
		//セッションスコープでユーザー情報を取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		//今日の日付を取得	
		LocalDate day = LocalDate.now();
		String today = day.toString();
		
		// セッションから user_id を取得
        int userID = user.getUserID();
        
        //初期のステータスを設定
        int goalAttribute = 1;
        
        //確認
        System.out.println(goalName);
        System.out.println(today);
        System.out.println(goalAttribute);
        System.out.println(userID);
        
		// 登録処理の実行
		Goal goal = new Goal(goalName, today, goalAttribute, userID);
		GoalLogic gl = new GoalLogic();
		boolean result = gl.execute(goal);
		
		// リクエストパラメータの値を引数で渡してエラーメッセージを受け取る
		CheckNoGoalMain checkRegistrationForm = new CheckNoGoalMain();
		String error = checkRegistrationForm.checkAll(goalName);
		
		// 登録処理の成否によって処理を分岐
		if (result) { // 登録成功時
			// リダイレクト
			//成功メッセージ
	  		String success = "目標を設定しました。";
			session.setAttribute("success", success);
			response.sendRedirect("ChoiceServlet");
		} else { // 登録失敗時
			// リダイレクト
			session.setAttribute("error", error);
			System.out.println(error);
			response.sendRedirect("ChoiceServlet");
		}	
	}

}

