package ideaRef2;

import java.util.Random;
import java.util.Scanner;

//配列の内容を表示させる
public class quiz2 {
	//問題に対する答えを入力しそれをanswer配列に代入するメソッド
	//関数化(1)
	public static void enterKeybordData(String[] questions, double[] answer) {
		Scanner sca = new Scanner(System.in);
		for (int i = 0; i < questions.length; i++) {
			//iが問題と解答に1対1で対応しているのでiは共通
			//問題文を表示
			System.out.println(questions[i]);
			System.out.println("値を入力して下さい");
			//答えの内容を格納する配列に入力値を代入
			answer[i] = sca.nextDouble();

		}
	}

	//答えの内容を表示する関数
	//関数化(2)
	public static void answerArray(double[] answer) {
		System.out.println("あなたが入力した値");
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + ", ");
		}
		System.out.println();//改行
	}

	//三角形の面積を求め小数第二位で四捨五入した結果を返す関数
	//関数化(3)
	public static double triangleArea(double a, double b) {
			double z = a * b / 2;
			//小数第2位から四捨五入する
			double truth = (double) Math.round(z * 10) / 10;
			return truth;
		}



	//採点結果を表示し点数を入れる関数
	//関数化(4)
	public static int scoreJudge(double[] answer, double[] truth, int score) {
		for (int i = 0; i < truth.length; i++) {
			if (answer[i] == truth[i]) {
				System.out.println("正解");
				score = score + 10;
			} else {
				System.out.println("不正解,正解は" + truth[i] + "です");
			}
		}
		return score;
	}
	//関数化(5)
	public static void passJudge(int score) {
		System.out.println("合格点は30点以上です。あなたの合否は");
		if (score >= 30) {
			System.out.println(score + "点で合格");
		} else {
			System.out.println(score + "点で不合格");
		}
	}
	//関数化(6)
	public static void addArrayData(String[] questionData,
	String[] questions){
		for(int i = 0; i < questionData.length; i++) {
			questions[i] = questionData[i];
		}
	}
	public static void main(String[] args) {
		//Randomインスタンスを生成
		Random random = new Random();
		//0を発生させないため(割り算に不都合)
		//引数を9にしてそこに1を加える
		int x = random.nextInt(10);
		int y = random.nextInt(10);
		String[] questions = {
				x + "+" + y + "= の値を求めよ", //一問目
				"底辺が" + x + "cm,高さが" + y +
						"cmの三角形の面積を求めよ。" +
						//\n～改行
						"\nただし割り切れない場合小数第2位は四捨五入する", //二問目
				"縦が" + x + "cm,横が" + y + "cmの長方形を求めよ",//三問目

		};
		//解答の数と答えの数を一致させるための変数numAnswerを宣言する
		//バグをなくすため
		int numAnswer = 3;
		double[] answer = new double[numAnswer];
		//関数化(1)
		/*
		 * 	第一引数～セットされた問題
		    第二引数～解答を入れるための配列
		    問題を表示しそれに対する答えを入力しそれをanswer配列に
		    代入するメソッド
		 * */
		enterKeybordData(questions, answer);

		//テスト関数化(2)
		/*
		 * 引数～答えが格納された配列
		 * */
		answerArray(answer);

		//(D)解答と答えを照らし合わせる

		//解答を配列で格納する
		double[] truth = new double[numAnswer];
		//		double truth1 = x + y;

		//		(double z = (double)x * y / 2;
		//		double truth2 = (double)Math.round(z*10)/10;)
		//					↓関数化(3)
		//		double truth2 = quotient(x,y);

		//		double truth3 = x * y;

		truth[0] = x + y;
		truth[1] = triangleArea(x, y);
		truth[2] = x * y;
		//(E)数値化
		int score = 0;

		//関数化(4)
		/* 第一引数～入力した内容の配列
		 * 第二引数～設定された答え
		 * 第三引数～採点結果
		 * 戻り値int型 scoreの点数
		 * 入力した内容と設定した答えを比較して
		 * 結果を表示するメソッド
		 *
		 * */
		score = scoreJudge(answer, truth, score);
		System.out.println(score);
		//		if (answer[0] == truth1) {
		//			System.out.println("正解");
		//			score = score + 10;
		//		} else {
		//			System.out.println("不正解,正解は"+ truth1 +"です");
		//		}
		//
		//
		//		if (answer[1] == truth2) {
		//			System.out.println("正解");
		//			score = score + 20;
		//		} else {
		//			System.out.println("不正解,正解は" + truth2 + "です");
		//		}
		//
		//
		//		if (answer[2] == truth3) {
		//			System.out.println("正解");
		//			score = score + 20;
		//		} else {
		//			System.out.println("不正解,正解は" + truth3 + "です");
		//		}
		passJudge(score);
		//(F)合否の判定//関数化(5)
//		System.out.println("合格点は30点以上です。あなたの合否は");
//		if (score >= 30) {
//			System.out.println(score + "点で合格");
//		} else {
//			System.out.println(score + "点で不合格");
//		}
	}
}
