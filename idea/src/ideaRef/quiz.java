package ideaRef;

import java.util.Random;
import java.util.Scanner;

public class quiz {

	public static void main(String[] args) {
		/*(A)配列に問題のデータを格納
		 * 数値を動的に変えたいので変数にしておく
		 * 変数に乱数を格納する
		 * */
		Random random = new Random();
		//0を発生させないため(割り算に不都合)
		//引数を9にしてそこに1を加える
		int x = random.nextInt(9)+1;
		int y = random.nextInt(9)+1;
		String[] questions = {
				x + "+" + y + "= の値を求めよ",
				"底辺が" + x + "cm,高さが" + y +
				"cmの三角形の面積を求めよ。"+
				"\nただし割り切れない場合小数第2位は四捨五入する",
				"縦が" + x + "cm,横が" + y + "cmの長方形を求めよ"

		};


		double[] answer = new double[3];
		Scanner sca = new Scanner(System.in);
		for (int i = 0; i < questions.length; i++) {
			//iが問題と解答に1対1で対応しているのでiは共通
			//問題文を表示
			System.out.println(questions[i]);
			System.out.println("値を入力して下さい");
			//答えの内容を格納する配列に入力値を代入
			answer[i] = sca.nextDouble();

		}

		//(B)問題のデータを格納した配列の中身を表示
		//答えを格納するための配列を宣言
//		int[] answer = new int[3];
//		Scanner sca = new Scanner(System.in);
//		for (int i = 0; i < questions.length; i++) {
//			//iが問題と解答に1対1で対応しているのでiは共通
//			System.out.println(questions[i]);
//			System.out.println("値を入力して下さい");
//			answer[i] = sca.nextInt();
//
//		}

		//(C)入力したデータを変数に格納する
//		int[] answer = new int[3];
//		answer[0] = new java.util.Scanner(System.in).nextInt();
//		answer[1] = new java.util.Scanner(System.in).nextInt();
//		answer[2] = new java.util.Scanner(System.in).nextInt();

		//for文で回して入力値を変数に代入する
//		double[] answer = new double[3];
//		Scanner sca = new Scanner(System.in);
//		for(int i = 0; i < answer.length; i++) {
//			/*キーボードで入力した値を配列の要素が埋まるまで
//			 * インデックスが0の配列から順番に格納していく
//			 * */
//			answer[i] = sca.nextDouble();
//		}

		//テスト
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + ", ");
		}
		System.out.println();

		//(D)解答と答えを照らし合わせる
		double truth1 = x + y;
		//int型の割り算は答えがすべてint型に変換されるので
		//double型にcastする
		//Math.round()関数を利用するための準備として
		double z = (double)x * y / 2;
		double truth2 = (double)Math.round(z*10)/10;
		double truth3 = x * y;
		System.out.println(truth2);
		//(E)数値化
		int score = 0;

		if (answer[0] == truth1) {
			System.out.println("正解");
			score = score + 10;
		} else {
			System.out.println("不正解,正解は"+ truth1 +"です");
		}
		//テスト
		//System.out.println(score);

		if (answer[1] == truth2) {
			System.out.println("正解");
			score = score + 20;
		} else {
			System.out.println("不正解,正解は" + truth2 + "です");
		}
		//テスト
		//System.out.println(score);

		if (answer[2] == truth3) {
			System.out.println("正解");
			score = score + 20;
		} else {
			System.out.println("不正解,正解は" + truth3 + "です");
		}
		//テスト
		//System.out.println(score);

		//(F)合否の判定
		System.out.println("合格点は30点以上です。あなたの合否は");
		if(score >= 30) {
			System.out.println("合格");
		}else {
			System.out.println("不合格");
		}

	}

}
