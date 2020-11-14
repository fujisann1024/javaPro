package userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import japaneseModel.Score;
import userModel.Student;

public class ScoreDAO {
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

			public boolean insertScore(Score score,Student student) {
				Date date = new Date();
				SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
				String today = simpleDate.format(date);

				try {
					//データベースの接続
					conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

					//SQL(INSERT文の準備)
					String sql = "INSERT INTO score (user_id,subject,area,score,percent,day) ";
					sql += "VALUES (?, ?, ?, ?, ?, ? )";

					//SQLの発行
					preSta = conn.prepareStatement(sql);


					preSta.setInt(1, student.getUserId());
					preSta.setInt(2, score.getSubject());
					preSta.setInt(3, score.getArea());
					preSta.setInt(4, score.getScore());
					preSta.setInt(5, score.getPercentage());
					preSta.setString(6, today);

					int result = preSta.executeUpdate();

					if(result != 1) {
						return false;
					}
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					return false;
				}finally {
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

			public static void main(String[] args) {
				//テスト
//				Student student = new Student(2,"けんじ");
//				Score score = new Score(1,10);
//				score.setScore(40);
//				score.setPercentage(40);
//
//				ScoreDAO scoreDAO = new ScoreDAO();
//				boolean check = scoreDAO.insertScore(score,student);
//				System.out.println(check);
//
//

			}

}
