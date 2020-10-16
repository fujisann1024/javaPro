package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuizDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL =
	"jdbc:mysql://localhost:3306/quizselect?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	//データベース接続のためのオブジェクト変数
	Connection conn = null;
	//SQL文を発行するためのオブジェクト変数
	PreparedStatement preSta = null;
	//SQL文を実行するためのオブジェクト変数


	public static void main(String[] args) {


	}

}
