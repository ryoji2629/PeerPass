package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Goal;
import model.User;
import model.UserGoal;

public class GoalsDAO {
	private final String JDBC_URL = "jdbc:mysql://192.168.10.10/peerpass?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "OTHER";
	private final String DB_PASS = "OTHER";

	//目標登録
	public boolean create(Goal goals) {
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// INSERT文の準備
			String sql = "INSERT INTO goals(GOAL_NAME, GOAL_ATTRIBUTE, REGISTER_DATE_VARCHAR, USER_ID) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//確認
			System.out.println("GoalsDAOのcreateメソッド↓");
			System.out.println(goals.getGoal());
			System.out.println(goals.getGoalAttribute());
			System.out.println(goals.getRegisterDate());
			System.out.println(goals.getUserId());

			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, goals.getGoal());
			pStmt.setInt(2, goals.getGoalAttribute());
			pStmt.setString(3, goals.getRegisterDate());
			pStmt.setInt(4, goals.getUserId());

			// INSERT文を実行（resultには追加された行数が代入される）
			int result = pStmt.executeUpdate();
			System.out.println("resultの中身↓");
			System.out.println(result);
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//同じ日付の目標があるか確認
	//ステータスを確認
	public int statusCheck(UserGoal useGoal) {
		int goAt = 0;
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT GOAL_ATTRIBUTE FROM GOALS WHERE USER_ID = ? AND REGISTER_DATE_VARCHAR = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//確認
			//			System.out.println(useGoal.getUserID());
			//			System.out.println(useGoal.getToday());

			pStmt.setInt(1, useGoal.getUserID());
			pStmt.setString(2, useGoal.getToday());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				// そのユーザーを表すAccountインスタンスを生成
				int goalAttribute = rs.getInt("GOAL_ATTRIBUTE");
				return goalAttribute;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return goAt;
		}
		return goAt;
	}

	// 目標状態をアップデートする
	public int editStatus(Goal goal) {
		int rowsUpdated = 0;
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// UPDATE文を準備
			String sql = "UPDATE GOALS SET GOAL_ATTRIBUTE = ? WHERE GOAL_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//確認
			//			System.out.println(useGoal.getUserID());
			//			System.out.println(useGoal.getToday());

			pStmt.setInt(1, goal.getGoalAttribute());
			pStmt.setInt(2, goal.getGoalID());

			// updateを実行し、更新した行数を取得
			rowsUpdated = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	public List<Goal> findAllGoals(User user) {
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		List<Goal> goalList = new ArrayList<Goal>();
		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文の準備
			String sql = "SELECT GOAL_ID,GOAL_NAME,GOAL_ATTRIBUTE,REGISTER_DATE_VARCHAR,USER_ID FROM GOALS WHERE USER_ID = ? ORDER BY REGISTER_DATE_DATE DESC ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECT文を完成
			pStmt.setInt(1, user.getUserID());

			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int goalID = rs.getInt("GOAL_ID");
				String goal = rs.getString("GOAL_NAME");
				String registerDate = rs.getString("REGISTER_DATE_VARCHAR");
				int goalAttribute = rs.getInt("GOAL_ATTRIBUTE");
				int userID = rs.getInt("USER_ID");
				Goal goals = new Goal(goalID, goal, registerDate, goalAttribute, userID);
				goalList.add(goals);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return goalList;
	}

	// 今日の日付の目標を取ってくるSELECT
	public Goal findGoal(UserGoal useGoal) {
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文の準備
			String sql = "SELECT GOAL_ID,GOAL_NAME,GOAL_ATTRIBUTE,REGISTER_DATE_VARCHAR,USER_ID FROM GOALS WHERE USER_ID = ? AND REGISTER_DATE_VARCHAR = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECT文を完成
			pStmt.setInt(1, useGoal.getUserID());
			pStmt.setString(2, useGoal.getToday());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				// goalモデルにSELECTでとってきたものを入れる
				int goalID = rs.getInt("GOAL_ID");
				String goalName = rs.getString("GOAL_NAME");
				String registerDate = rs.getString("REGISTER_DATE_VARCHAR");
				int goalAttribute = rs.getInt("GOAL_ATTRIBUTE");
				int userID = rs.getInt("USER_ID");
				Goal goals = new Goal(goalID, goalName, registerDate, goalAttribute, userID);
				return goals;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	//全ての投稿を取ってくる
	public List<Goal> findMutterList() {
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		List<Goal> mutterList = new ArrayList<Goal>();
		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文の準備
			String sql = "SELECT GOAL_ID,GOAL_NAME,GOAL_ATTRIBUTE,REGISTER_DATE_VARCHAR,G.USER_ID,USER_NAME FROM GOALS AS G INNER JOIN USERS AS U ON G.USER_ID = U.USER_ID ORDER BY REGISTER_DATE_DATE DESC ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int goalID = rs.getInt("GOAL_ID");
				String goal = rs.getString("GOAL_NAME");
				String registerDate = rs.getString("REGISTER_DATE_VARCHAR");
				int goalAttribute = rs.getInt("GOAL_ATTRIBUTE");
				int userID = rs.getInt("G.USER_ID");
				String userName = rs.getString("USER_NAME");
				Goal goals = new Goal(goalID, goal, registerDate, goalAttribute, userID);
				goals.setUserName(userName);
				System.out.println(goals.getUserName());
				mutterList.add(goals);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
}
