package userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import userModel.LoginUser;
import userModel.Student;

public class AccountDAO {
	//データベース接続に使用する情報
		private final String JDBC_URL =
		"jdbc:mysql://localhost:3306/docotsubu?characterEncoding=UTF-8&serverTimezone=JST";
		private final String DB_USER = "root";
		private final String DB_PASS = "root";
		//データベース接続のためのオブジェクト変数
		Connection conn = null;
		//SQL文を発行するためのオブジェクト変数
		PreparedStatement preSta = null;
		//SQL文を実行するためのオブジェクト変数
		ResultSet rs = null;

		public Student findAcount(LoginUser login) {
			Student student = null;
			try {
				conn =
				DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
				System.out.println("接続に成功しました");

				String sql =
				"SELECT * FROM account WHERE email = ? AND password = ?";
				preSta = conn.prepareStatement(sql);

				preSta.setString(1,login.getEmail());
				preSta.setString(2,login.getPass());

				rs = preSta.executeQuery();

				if(rs.next()) {
					int userId = rs.getInt("id");
					String userName = rs.getString("userName");
					student = new Student(userId,userName);
				}else {
					return null;
				}


			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return null;
			}finally {
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
				if(preSta != null ) {
					try {
						preSta.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
				if(rs != null ) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}

			return student;
		}

		//テスト
		public static void main(String[] args) {
			AccountDAO accountDAO = new AccountDAO();
			LoginUser loginUser = new LoginUser("yahoo.mail","9999");
			Student student = accountDAO.findAcount(loginUser);
			System.out.println(student);
		}
}
