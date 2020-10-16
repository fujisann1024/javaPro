package Array;

public class Test {

	public static void main(String[] args) {
		//値渡しと参照渡し
		//変数->値渡し(名前を付けて保存)
		//配列->参照渡し(上書き保存)


		//変数Ver
		int numberVariable = 0;
		//戻り値がvoid型なのでそのまま使用
		insertNumber1(numberVariable);
		System.out.println(numberVariable);


		//配列Ver
		int[] numberArray = new int[3];
		insertArray1(numberArray);
		for(int i = 0; i < numberArray.length; i++) {
			System.out.print(numberArray[i] + ",");
		}
		System.out.println();

	}
	//変数(引数)に値を代入する関数
	public static void insertNumber1(int number) {
		number = 5;
		System.out.println(number);
	}


	//配列に値を代入する関数
	public static void insertArray1(int[] number) {
		//for文で各インデックス(添え字)に代入
		/*iはインデックス番号とする。インデックスは0から始まるので初期値は0
		 *インデックスが受け取った配列の要素数を下回っていたら繰り返し処理を行う
		 *処理が終わったらiをインクリメント(1を足す)して繰り返し処理をするのか判定する
		 * */
		for(int i = 0; i < number.length; i++) {
			number[i] = i;
			System.out.print(number[i] + ",");
		}
		System.out.println();
	}



}
