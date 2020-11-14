package practice;


//完全コンストラクタ
//①インスタンス変数はコンストラクタでオブジェクトの生成時に設定する
//②インスタンス変数を変更するメソッドを設定しない
//③別の値が必要であれば、別のインスタンス(オブジェクト)を作る
public class Money {

	public static final int MIN = 0;
	public static final int MAX = 100000000;

	public int value;
	public int price;

	public Money() {

	}


	//例外処理で値を限定する
	public Money(int value) {
		if (value < MIN) {
			//IllegalArgumentException～
			//不正な引数、または不適切な引数をメソッドに渡したことを示すためにスローされます。
			throw new IllegalArgumentException("不正:" + MIN + "未満");//引数がメッセージ内容
		}

		if (value > MAX) {
			throw new IllegalArgumentException("不正" + MAX + "超");
		}

		this.value = value;
	}

	//Valueゲッター
	public int getValue() {
		return this.value;
	}

	//Priceゲッター
	public int getPrice() {
		return this.price;
	}



	private int plusValue(Money money) {
		return this.value + money.value;
	}

	private int minusValue(Money money) {
		return this.value - money.value;
	}

	//実行したメソッドが設定した範囲に収まるかどうかを返す
	public boolean conValuePlus(Money money) {
		int plused = plusValue(money);
		return plused <= MAX;
	}

	public boolean conValueMinus(Money money) {
		int minused = minusValue(money);
		return minused >= MIN;
	}

	//例外処理で実際に実行するかどうか
	public Money plus(Money money) {
		if(!conValuePlus(money)) {
			throw new IllegalArgumentException("不正:合計が" + MAX + "以上");
		}

		int plused = plusValue(money);
		return new Money(plused);
	}

	public Money minus(Money money) {
		if(!conValueMinus(money)) {
			throw new IllegalArgumentException("不正:合計が" + MIN + "以下");
		}

		int minused = minusValue(money);
		return new Money(minused);
	}

	public Money multiply(Quantity quantity) {
		Money money = new Money();
		money.price = this.value * quantity.value;
		return money;
	}

	public static void main(String[] args) {
		//Point7～値オブジェクトは「不変」にする
		//reason～オブジェクトの用途が限定されプログラムが安定
		Money basePrice = new Money(1000);

		Money option = new Money(50);

		Money minused = basePrice.minus(option);

		Money plused = basePrice.plus(option);

		System.out.println(minused.getValue());
		System.out.println(plused.getValue());
		Quantity quantity = new Quantity(50);

		Money price = basePrice.multiply(quantity);
		System.out.println(price.price);

	}


}
