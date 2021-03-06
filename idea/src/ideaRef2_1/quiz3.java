package ideaRef2_1;

import java.util.Random;

public class quiz3 {


	public static void main(String[] args) {
		//Randomインスタンスを生成
		Random random = new Random();
		//0を発生させないため(割り算に不都合)
		//引数を9にしてそこに1を加える
		int x = random.nextInt(9) + 1;
		int y = random.nextInt(9) + 1;
		String[] questions = {
				x + "+" + y + "= の値を求めよ", //一問目
				"底辺が" + x + "cm,高さが" + y +
				"cmの三角形の面積を求めよ。" +
				//\n～改行
				"\nただし割り切れない場合小数第2位は四捨五入する", //二問目
				"縦が" + x + "cm,横が" + y + "cmの長方形を求めよ",//三問目
				x + "-" + y + "=の値を求めよ。"+
				"\nただし答えが0より小さくなる場合は-1を入れること",//四問目
				x + "÷" + y + "の値を求めよ。" +
				"\nただし答えが割り切れない場合は-1を入力して下さい"//五問目

		};
		//解答の数と答えの数を一致させるための変数numAnswerを宣言する
		//バグをなくすため
		int numAnswer = 5;
		double[] answer = new double[numAnswer];
		//関数化(1)
		/*
		 * 	第一引数～セットされた問題
		    第二引数～解答を入れるための配列
		    問題を表示しそれに対する答えを入力しそれをanswer配列に
		    代入するメソッド
		 * */
		methodQuiz.enterKeybordData(questions, answer);

		//テスト関数化(2)
		/*
		 * 引数～答えが格納された配列
		 * */
		methodQuiz.answerArray(answer);

		//(D)解答と答えを照らし合わせる

		//解答を配列で格納する
		double[] truth = new double[numAnswer];

		truth[0] = methodQuiz.plus(x, y);
		truth[1] = methodQuiz.triangleArea(x, y);
		truth[2] = methodQuiz.multiply(x, y);
		truth[3] = methodQuiz.minus(x, y);
		truth[4] = methodQuiz.divide(x, y);
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
		score = methodQuiz.scoreJudge(answer, truth, score);
		System.out.println(score);

		methodQuiz.passJudge(score);

	}
}
