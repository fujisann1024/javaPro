package quizModel;

import java.util.List;

public class AnswerLogic {
	//第一引数～インスタンス
	//第二引数～List型の配列
	public void answerLog(AnswerData answer,
	//AnswerDataインスタンスが格納できるList(ArrayList)配列
	List<AnswerData> answerDataList) {
		/*addメソッド
		第一引数～指定のインデックス番号
		第二引数～値(インスタンス)
		指定の位置に値がある場合は上書きするのではなく
		指定の位置に値を格納し,もともとあった値を後ろ
		にずらす
		*/
		answerDataList.add(answer);
	}
}
