package userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import userModel.LoginUser;
import userModel.Regist;
import userModel.Student;

public class AccountDAO {
	//データベース接続に使用する情報
		private final String JDBC_URL =
		"jdbc:mysql://localhost:3306/quiz?characterEncoding=UTF-8&serverTimezone=JST";
		private final String DB_USER = "root";
		private final String DB_PASS = "root";
		//データベース接続のためのオブジェクト変数
		Connection conn = null;
		//SQL文を発行するためのオブジェクト変数
		PreparedStatement preSta = null;
		//SQL文を実行するためのオブジェクト変数
		ResultSet rs = null;

		//フォームから受け取った値をインスタンスに格納して
		//インスタンスから取り出したデータをWHERE文の?にセットし
		//SELECT文を実行したときに取り出すことができるかを確認するメソッド
		public Student findAcount(LoginUser login) {
			Student student = null;
			try {
				conn =
				DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
				System.out.println("接続に成功しました");

				String sql =
				"SELECT * FROM account WHERE email = ? AND pass = ?";
				preSta = conn.prepareStatement(sql);

				preSta.setString(1,login.getEmail());
				preSta.setString(2,login.getPass());

				rs = preSta.executeQuery();

				if(rs.next()) {
					int userId = rs.getInt("user_id");
					String userName = rs.getString("user_name");
					student = new Student(userId,userName);
				}else {
					return null;
				}


			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return null;
			}finally {
				close(conn,preSta,rs);
			}

			return student;
		}

		//パスワードをチェックするメソッド
		public String passCheck(String pass) {
			String data = null;
			try {
				//データベース接続
				conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

				String sql =
				"SELECT pass FROM account WHERE pass = ? ";

				//SQL文の発行
				preSta = conn.prepareStatement(sql);

				//?に引数から受け取った値をセット
				preSta.setString(1,pass);

				rs = preSta.executeQuery();

				if(rs.next()) {
					data = rs.getString("pass");

				}else {
					return null;
				}

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return null;
			}finally{
				close(conn,preSta,rs);
			}

			return data;
		}

		//アカウントを登録するメソッド
		public boolean create(Regist regist) {
			try {
				conn =
				DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
				System.out.println("接続に成功しました");
				//INSERT文の準備
				String sql = "INSERT INTO account ";
				sql += "(user_name,email,pass,morf) ";
				sql += "VALUES (?, ?, ?, ?)";
				System.out.println(sql);

				//INSERT文の発行
				preSta = conn.prepareStatement(sql);

				//フォームの内容を格納したインスタンスからゲッターで
				//それぞれ取得し値をSQL文にセットしていく
				preSta.setString(1,regist.getUserName());
				preSta.setString(2,regist.getEmail());
				preSta.setString(3,regist.getPass());
				preSta.setString(4,regist.getMorf());

				//INSERT文を実行(戻り値は実行したSQL文の行数)
				int result = preSta.executeUpdate();
				System.out.println(result );
				if(result != 1) {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}finally{
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return false;
					}
				}
				if(preSta != null ) {
					try {
						preSta.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
			return true;

		}


		public void close(Connection conn,
		PreparedStatement preSta,ResultSet rs) {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preSta != null ) {
				try {
					preSta.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null ) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		//テスト
		public static void main(String[] args) {
			AccountDAO accountDAO = new AccountDAO();
//			LoginUser loginUser = new LoginUser("gmail.com","1234");
//			Student student = accountDAO.findAcount(loginUser);
//			System.out.println(student);
//
//			Regist regist = new Regist("けんじ","yahoo.mail","5678","男");
//			boolean test = accountDAO.registringAccount(regist);
//			System.out.println(test);
			String test = accountDAO.passCheck("1234");
			System.out.println(test);

		}
}
