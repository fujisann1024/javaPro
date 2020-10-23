package japaneseDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import japaneseModel.KanjiQuiz;

public class KanjiDAO {
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

	//すべてのテーブルの値を表示するメソッド
	public List<KanjiQuiz> findAll() {
		//格納するためのMapを生成
		List<KanjiQuiz> readKanjiQuiz = new ArrayList<>();

		try {
		//データベース接続
		conn =
		DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
		System.out.println("接続に成功しました");

		//SQL文の準備(SELECT文)
		String sql = "SELECT id + area AS number,";
		sql += "name,ruby FROM kanji WHERE area = 10 ";
		sql += "ORDER BY number";
		System.out.println("sql文" + sql);

		//SQL文の発行
		preSta = conn.prepareStatement(sql);

		//SQL文の実行
		rs = preSta.executeQuery();

		//カラムの値を取り出す
		while(rs.next()) {
			int number = rs.getInt("number");
			String name = rs.getString("name");
			String ruby = rs.getString("ruby");

			System.out.println(number);
			System.out.println(name);
			System.out.println(ruby);

			//インスタンスに保存
			KanjiQuiz kanjiQuiz = new KanjiQuiz(name,ruby);
			//readKanjiQuizにインスタンスを格納
			readKanjiQuiz.add(kanjiQuiz);


		}

		} catch (SQLException e) {
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
		//while文で格納した値を返す
		return readKanjiQuiz;
	}
	//
	public static void main(String[] args) {
//
//		KanjiDAO kanjiDAO = new KanjiDAO();
//		List<KanjiQuiz> readKanjiQuiz = kanjiDAO.findAll();
//		Collections.shuffle(readKanjiQuiz);
//		for(KanjiQuiz value : readKanjiQuiz) {
//			System.out.println(value.getName() + "=>" + value.getRuby());
//		}
//		System.out.println();
	}
}
