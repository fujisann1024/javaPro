package japaneseModel;

import java.util.List;

public class ScoringLogic {
	//サーブレット内で用意した配列に回答を入れていく
	public void setDataList(String answer, List<String> answerList) {
		answerList.add(answer);
	}

	//回答内容とクイズの内容を照らし合わせるメソッド

	public void getReadScoreData(Score score,
	List<String> answerList,
	List<KanjiQuiz> readKanjiList) {
		//点数を格納する変数
		int scorePoint = 0;
		//正解率を格納する変数
		int percentage = 0;
		//正解数を格納する変数
		int clearCount = 0;
		//問題数を格納する変数
		int quizSize = readKanjiList.size();
		int i = 0;
		for(String answer : answerList) {
			boolean check =
			readKanjiList.get(i).getRuby().equals(answer);
			if(check) {
				scorePoint += 10;
				clearCount++;
			}
			i++;
		}

		//ループで計算が終わったのでパーセンテージを算出
		double rate = (double) clearCount / quizSize;
		percentage = (int) Math.round(rate * 100);
		/*
		 * rate = 0.529
		 * rate * 100 = 52.9
		 * round(52.9)= 53
		 * */

		//scoreインスタンスに格納する
		score.setScore(scorePoint);
		score.setPercentage(percentage);
	}

	public static void main(String[] args) {
		//round関数の説明
		int number1 = 13;
		int number2 = 4;
		double number = (double) number2 / number1;//0.3076923076923077
		System.out.println(number);
		int percentage = (int) Math.round(number * 100);//31
		System.out.println(percentage);

	}

}
