package ideaRef2_1;

import java.util.Scanner;

public class methodQuiz {
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
	//他の公式も関数化する
	//足し算
	public static double plus(double a,double b) {
		return a + b;
	}
	//掛け算
	public static double multiply(double a,double b) {
		return a * b;
	}
	//小学校のカリキュラムでは負の数は扱わないので
	//例外が出た時の戻り値は-で返す
	//引き算
	public static double minus(double a,double b) {
		if(a < b) {
			return -1;
		}else {
			return a - b;
		}

	}
	//割り算(小数第二位は四捨五入)
	public static double divide(double a,double b) {
		if(b == 0) {
			return -1.0;
		}else {
			double z = a / b;
			//小数第2位から四捨五入する
			double truth = (double) Math.round(z * 10) / 10;
			return truth;
		}
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
}
