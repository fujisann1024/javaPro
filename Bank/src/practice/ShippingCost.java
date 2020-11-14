package practice;

//Point5～狭い関心事に特化したクラスにする
//reason～変更する際の影響範囲を限定できる

//送料クラス
//送料が無料になる注文金額(3000円)
//送料(500円)
//注文金額を判断して、適切な送料を計算するロジック

//ドメインオブジェクト～業務で使われる用語に合わせて
//						その用語の関心事に対応するクラス

public class ShippingCost {

	static final int minimumForFree = 3000;
	static final int cost = 500;
	//int,BigDecimalは数字を扱える範囲が広い=>バグの危険
	//Point6～範囲を狭めることで計算が安全になる
	int basePrice;

	public ShippingCost(int basePrice) {
		this.basePrice = basePrice;
	}

	int amount() {
		if (basePrice < minimumForFree)
			return cost;
		return 0;
	}

	//送料クラスを使う側のコード
	public int shippingCost(int basePrice) {
		ShippingCost cost = new ShippingCost(basePrice);
		return cost.amount();

	}

	public static void main(String[] args) {

	}

}
