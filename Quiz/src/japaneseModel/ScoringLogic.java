package japaneseModel;

import java.util.List;

import userModel.Student;

public class ScoringLogic {
	//サーブレット内で用意した配列に回答を入れていく
	public void setDataList(String answer, List<String> answerList) {
		answerList.add(answer);
	}

	//回答内容とクイズの内容を照らし合わせる
	public void getReadScoreData(Student student, List<String> answerList,
			List<KanjiQuiz> readKanjiList) {
		//点数を格納する変数
		int score = 0;
		//正解率を格納する変数
		int percentage = 0;
		//正解数を格納する変数
		int clearCount = 0;
		//問題数を格納する変数
		int quizSize = readKanjiList.size();

		//理解しやすい方法
//
//		//正解を格納する配列
//		String[] rubyDatas = new String[quizSize];
//		//回答を格納する配列
//		String[] answerDatas = new String[answerList.size()];
//
//		for(int i = 0; i < rubyDatas.length; i++) {
//			rubyDatas[i] = readKanjiList.get(i).getRuby();
//		}
//
//		for(int i = 0; i < answerDatas.length; i++) {
//			answerDatas[i] = answerList.get(i);
//		}
//
//		for(int i = 0; i < answerDatas.length; i++) {
//			if(rubyDatas[i].equals(answerDatas[i])) {
//				score += 10;
//				clearCount++;
//			}
//		}

		//スマートな方法
		int i = 0;
		for(String answer : answerList) {
			boolean check =
			readKanjiList.get(i).getRuby().equals(answer);
			if(check) {
				score += 10;
				clearCount++;
			}
			i++;
		}

		//ループで計算が終わったのでパーセンテージを算出
		double rate = (double) clearCount / quizSize;
		percentage = (int) Math.round(rate * 100);

		//studentインスタンスに格納する
		student.setScore(score);
		student.setPercentage(percentage);
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
