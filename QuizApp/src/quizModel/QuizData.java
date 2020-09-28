//JavaBeansのルール①～⑤
//①クラスはpublicでパッケージに所属している
package quizModel;

import java.io.Serializable;
import java.util.Random;

public class QuizData implements Serializable {
	//Randomインスタンスを生成
	Random random = new Random();
	//0を発生させないため(割り算に不都合)
	//引数を9にしてそこに1を加える
	private int x1 = random.nextInt(9) + 1;
	private int y1 = random.nextInt(9) + 1;
	private int x2 = random.nextInt(9) + 1;
	private int y2 = random.nextInt(9) + 1;
	private int x3 = random.nextInt(9) + 1;
	private int y3 = random.nextInt(9) + 1;
	private int x4 = random.nextInt(9) + 1;
	private int y4 = random.nextInt(9) + 1;
	private int x5 = random.nextInt(9) + 1;
	private int y5 = random.nextInt(9) + 1;
	private String[] questions = {
		x1 + "+" + y1 + "= の値を求めよ", //一問目
		"底辺が" + x2 + "cm,高さが" + y2 +
				"cmの三角形の面積を求めよ。" +
				//\n～改行
				"\nただし割り切れない場合小数第2位は四捨五入する", //二問目
		"縦が" + x3 + "cm,横が" + y3 + "cmの長方形を求めよ", //三問目
		x4 + "-" + y4 + "=の値を求めよ。" +
				"\nただし答えが0より小さくなる場合は-1を入れること", //四問目
		x5 + "÷" + y5 + "の値を求めよ。" +
				"\nただし答えが割り切れない場合は-1を入力して下さい"//五問目

	};

	private double[] truth = {
			this.plus(x1, y1),
			this.triangleArea(x2, y2),
			this.multiply(x3, y3),
			this.minus(x4, y4),
			this.divide(x5, y5)
	};


	public QuizData() {

	}

	public String[] getQuestions() {
		return this.questions;
	}

	public double[] getTruth() {
		return this.truth;
	}

	//公式メソッド(private:非公開)

	//三角形の面積を求め小数第二位で四捨五入した結果を返す関数
	private double triangleArea(double a, double b) {
		double z = a * b / 2;
		//小数第2位から四捨五入する
		double truth = (double) Math.round(z * 10) / 10;
		return truth;
	}
	//他の公式も関数化する
	//足し算
	private double plus(double a,double b) {
		return a + b;
	}
	//掛け算
	private double multiply(double a,double b) {
		return a * b;
	}
	//小学校のカリキュラムでは負の数は扱わないので
	//例外が出た時の戻り値は-で返す
	//引き算
	private double minus(double a,double b) {
		if(a < b) {
			return -1;
		}else {
			return a - b;
		}

	}
	//割り算(小数第二位は四捨五入)
	private double divide(double a,double b) {
		if(b == 0) {
			return -1.0;
		}else {
			double z = a / b;
			//小数第2位から四捨五入する
			double truth = (double) Math.round(z * 10) / 10;
			return truth;
		}
	}
}
