package selectQuiz;

public class quiz {

	public static void main(String[] args) {

		//questions配列に問題を入れていく
		//(データベースから取得するイメージ)
		String[] questionsData = {
				"問題1:extendの意味を次の選択肢の中から選べ",//答え2
				"問題2:interfaceの意味を次の選択肢から選べ",//答え3
				"問題3:implementの意味を次の選択肢の中から選べ"//答え1
		};

		String[][] Choice = {
		    {"1:狭める","2:広げる","身に着ける"},
			{"1:曲面","2:凹凸面","3:接触面"},
			{"1:実装する","2:解除する","組み合わせる"},
		};

		//(B)問題のデータを格納した配列の中身を表示
		for (int i = 0; i < questionsData.length; i++) {
			System.out.println(questionsData[i]);
		}
//
//		//(C)入力したデータを変数に格納する
//		System.out.println("値を入力して下さい");
//		//		int input = new java.util.Scanner(System.in).nextInt();
//		//		System.out.println(input);
//
//		//(C)入力したデータを配列に格納する
//		int[] answer = new int[3];
//		answer[0] = new java.util.Scanner(System.in).nextInt();
//		answer[1] = new java.util.Scanner(System.in).nextInt();
//		answer[2] = new java.util.Scanner(System.in).nextInt();
//
//		//テスト
//		for (int i = 0; i < answer.length; i++) {
//			System.out.print(answer[i] + ", ");
//		}
//		System.out.println();
//
//		//(D)解答と答えを照らし合わせる
//		int truth1 = 13;
//		int truth2 = 15;
//		int truth3 = 30;
//
//		//(E)数値化
//		int score = 0;
//
//		if (answer[0] == truth1) {
//			System.out.println("正解");
//			score = score + 10;
//		} else {
//			System.out.println("不正解");
//		}
//		//テスト
//		//System.out.println(score);
//
//		if (answer[1] == truth2) {
//			System.out.println("正解");
//			score = score + 20;
//		} else {
//			System.out.println("不正解");
//		}
//		//テスト
//		//System.out.println(score);
//
//		if (answer[2] == truth3) {
//			System.out.println("正解");
//			score = score + 20;
//		} else {
//			System.out.println("不正解");
//		}
//		//テスト
//		//System.out.println(score);
//
//		//(F)合否の判定
//		System.out.println("あなたの合否は");
//		if(score >= 30) {
//			System.out.println("合格");
//		}else {
//			System.out.println("不合格");
//		}

	}

}
