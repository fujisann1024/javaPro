package practice;

//計算結果も含めて、数量が1以上100以下であるように制限した

//値オブジェクト～値を扱うための専用クラスを作るやり方

//例
//Unit～単位
//Amount～金額
//Days～日数
//Period～期間
//Telphone～電話番号
//Email～メールアドレス
public class Quantity {

	//範囲
	public static final int MIN = 1;
	public static final int MAX = 100;

	//少ないフィールドを持つ
	public int value;

	public Quantity() {

	}

	public Quantity(int value) {
		if (value < MIN) {
			//IllegalArgumentException～
			//不正な引数、または不適切な引数をメソッドに渡したことを示すためにスローされます。
			throw new IllegalArgumentException(
				"不正:" + MIN + "未満"
			);//引数がメッセージ内容
		}

		if (value > MAX) {
			throw new IllegalArgumentException(
				"不正" + MAX + "超"
			);
		}

		this.value = value;

	}

	private int addValue(Quantity other) {
		return this.value = other.value;
	}

	public boolean conAdd(Quantity other) {
		int added = addValue(other);
		return added <= MAX;

	}

	public Quantity add(Quantity other) {
		if (!conAdd(other)) {
			throw new IllegalArgumentException(
				"不正:合計が" + MAX + "以上"
					);
		}
		int added = addValue(other);
		return new Quantity(added);
	}

	//割引基準をジャッジするメソッド
	public boolean isDiscountable() {
		if(this.value >= 30) {
			 return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Quantity quantity = new Quantity(10);
		System.out.println(quantity.isDiscountable());
	}

}
