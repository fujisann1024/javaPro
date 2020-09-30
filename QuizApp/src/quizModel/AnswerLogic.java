package quizModel;

import java.util.List;

public class AnswerLogic {
	//第一引数～インスタンス
	//第二引数～List型の配列
	public void answerLog(AnswerData answer,
	//AnswerDataインスタンスが格納できるList(ArrayList)配列
	List<AnswerData> answerDataList) {
		/*addメソッド
		引数～挿入する値
		値がある場合は1つ後ろのインデックス番号に格納する
		*/
		answerDataList.add(answer);
	}
	//サーブレット内で準備したArrayListにQuizDataのインスタンスから
	//取得した問題リストと正解リストを後ろに格納していくメソッド

	public void setListQandT(QuizData quizData,
	List<String> quizDataList,List<Double> truthDataList) {
		for(String question : quizData.getQuestions()) {
			quizDataList.add(question);
		}
		for(Double truth : quizData.getTruth()) {
			truthDataList.add(truth);
		}
	}

	public void setScore(AnswerData answerData,
	List<Double> truthDataList,List<AnswerData> answerDataList) {
		int score = 0;
		//テスト2
        for(AnswerData answer : answerDataList){
        	/* ①answerDataListをanswerインスタンスとして一個ずつ前から取り出す
        	 * ②answer = new AnswerData();と同じで
        	 * 格納された答えを取り出すgetAnswer()にアクセス
        	 * ③answer.getAnswer()の戻り値はString型なので
        	 * Double.parseDouble()の引数に入れて戻り値をdouble型に変換する
        	 * */
        	double ans = Double.parseDouble(answer.getAnswer());
        	for(double truth : truthDataList) {
        		if(ans == truth) {
        			score += 10;
        			//ここのループ文が回答を比較するたびにすべての
        			//正解リストを検索してしまう->
        			break;
        		}
        	}
        }
		answerData.setScore(score);
	}


}
