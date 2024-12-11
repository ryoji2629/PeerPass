package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDAO {
	private final String JDBC_URL = "jdbc:mysql://192.168.10.10/peerpass?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "OTHER";
	private final String DB_PASS = "OTHER";

	//ログイン処理
	public User findByLogin(User login) {
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT  USER_ID,USER_NAME,EMAIL, PASS FROM USERS WHERE EMAIL = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getMail());
			pStmt.setString(2, login.getPass());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				// ユーザーが存在したらデータを取得
				// そのユーザーを表すAccountインスタンスを生成
				int userID = rs.getInt("USER_ID");
				String name = rs.getString("USER_NAME");

				login.setUserID(userID);
				login.setName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return login;
	}

	public boolean create(User user) {
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文の準備
			String sql = "INSERT INTO users(USER_NAME, EMAIL, PASS) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getMail());
			pStmt.setString(3, user.getPass());

			// INSERT文を実行（resultには追加された行数が代入される）
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int edit(User user, User newUser) {
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		int rowsUpdated = 0;
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE USERS SET EMAIL = ?,PASS = ? WHERE EMAIL = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// UPDATE文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, newUser.getMail());
			pStmt.setString(2, newUser.getPass());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getPass());

			// updateを実行し、更新した行数を取得
			rowsUpdated = pStmt.executeUpdate();
			System.out.println(rowsUpdated + " 行が更新されました。");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	public int editProfile(User user, User newUser) {
		// JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		int rowsUpdated = 0;
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "UPDATE USERS SET USER_NAME = ? WHERE EMAIL = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// UPDATE文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, newUser.getName());
			pStmt.setString(2, user.getMail());
			pStmt.setString(3, user.getPass());

			// updateを実行し、更新した行数を取得
			rowsUpdated = pStmt.executeUpdate();
			System.out.println(rowsUpdated + " 行が更新されました。");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

}