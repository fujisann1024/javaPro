package japaneseDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import japaneseModel.KanjiQuiz;
import japaneseModel.Score;

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
	public List<KanjiQuiz> findAll(Score score) {
		//格納するためのMapを生成
		List<KanjiQuiz> readKanjiQuiz = new ArrayList<>();

		try {
		//データベース接続
		conn =
		DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
		System.out.println("接続に成功しました");

		//SQL文の準備(SELECT文)
		String sql = "SELECT name,ruby FROM kanji WHERE area = ?";


		//SQL文の発行
		preSta = conn.prepareStatement(sql);

		//?に値をセット
		preSta.setInt(1, score.getArea());

		//SQL文の実行
		rs = preSta.executeQuery();

		//カラムの値を取り出す
		while(rs.next()) {
			String name = rs.getString("name");
			String ruby = rs.getString("ruby");

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
			close(conn,preSta,rs);
		}
		//while文で格納した値を返す
		return readKanjiQuiz;
	}

	//
	public Map<Integer,String> selectQuiz() {
		Map<Integer,String> kindArea = new HashMap<>();
		try {
			conn =
			DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql =
			"SELECT area, kind FROM kanji GROUP BY area, kind";

			preSta = conn.prepareStatement(sql);

			rs = preSta.executeQuery();

			while(rs.next()) {
				int area = rs.getInt("area");
				String kind = rs.getString("kind");

				kindArea.put(area, kind);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}finally {
			close(conn,preSta,rs);
		}
		//while文で格納したMapをreturnする
		return kindArea;
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

		KanjiDAO kanjiDAO = new KanjiDAO();
		Score score = new Score(1,10);
		List<KanjiQuiz> readKanjiQuiz = kanjiDAO.findAll(score);
		Collections.shuffle(readKanjiQuiz);
		for(KanjiQuiz value : readKanjiQuiz) {
			System.out.println(value.getName() + "=>" + value.getRuby());
		}
		System.out.println();

		Map<Integer,String> test2 = kanjiDAO.selectQuiz();
		for(Map.Entry<Integer, String> entry : test2.entrySet()) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}
	}
}
