package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetMutterListLogic;
import model.Goal;

/**
 * Servlet implementation class NotLoggedInServlet
 */
@WebServlet("/NotLoggedInServlet")
public class NotLoggedInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotLoggedInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/notLoggedIn.jsp");
		// つぶやきリストをデータベースから取得､リクエストスコープに保存
		GetMutterListLogic gmll = new GetMutterListLogic();
		List<Goal> mutterList = gmll.execute();
		request.setAttribute("mutterList", mutterList);
		dispatcher.forward(request, response);
	}

}
