package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KanjiDAO {
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

	//すべてのテーブルの値を表示するメソッド
	public void findAll() {
		try {
		//データベース接続
		conn =
		DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
		System.out.println("接続に成功しました");

		//SQL文の準備(SELECT文)
		String sql = "SELECT id + area AS number,";
		sql += "name,ruby,mean FROM kanji ORDER BY number";

		//SQL文の発行
		preSta = conn.prepareStatement(sql);
		System.out.println("SQL文を発行しました");

		//SQL文の実行
		rs = preSta.executeQuery();
		System.out.println("SQL文を実行しました");
		
		//カラムの値を取り出す
		while(rs.next()) {
			int number = rs.getInt("number");
			String name = rs.getString("name");
			String ruby = rs.getString("ruby");
			String mean = rs.getString("mean");
			System.out.println(name);
			System.out.println(ruby);
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	}

	public static void main(String[] args) {

		KanjiDAO kanjiDAO = new KanjiDAO();
		kanjiDAO.findAll();
	}
}
