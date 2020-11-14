package practice;

public class Coding1 {

	public static void main(String[] args) {
		//Point1～変数名は分かりやすい名前をつける
		//×1文字の変数名
		int a;
		int b;
		//△省略した変数名
		int qty;
		int up;
		//〇意味のある単語を使った変数名
		int quantity = 0;//数量
		int unitPrice = 0;//単価

		//Point2～長いメソッドは段落に分けて読みやすくする
		//		int price = quantity * unitPrice;
		//
		//		if (price < 3000) {
		//			price += 500;//送料
		//		}
		//
		//		price = price * taxRate();

		//破壊的代入～一つの変数を使いまわして代入

		//Point3～目的ごとの変数を用意する
		//reason～独立性が高くなる
//		int basePrice = quantity * unitPrice;
//
//		int shippingCost = 0; //送料の初期値
//		if (basePrice < 3000) { //3000円未満
//			shippingCost += 500;//送料500円
//		}
//
//		double itemPrice = (basePrice + shippingCost) * taxRate();//税込み価格

		//説明用の変数の導入～コードの意図を変数名で説明するやり方

		//Point4～メソッド化して独立させる
		//reason～コードの重複を防ぐ
		//        コードの意図をメソッド名から理解しやすくする
		//        メソッド内に変更の影響を閉じ込めやすくする
		int basePrice = quantity * unitPrice;

		int shippingCost = shippingCost(basePrice); //送料計算メソッド

        double itemPrice = (basePrice + shippingCost) * taxRate();//税込み価格

        //メソッドの抽出～様々なロジックをメソッドとして抽出する
	}

	private static double taxRate() {
		// TODO 自動生成されたメソッド・スタブ
		return 1.1;
	}

	//メソッドに独立された送料計算ロジック
	private static int shippingCost(int basePrice) {
		if (basePrice < 3000) { //3000円未満
			return 500;//送料500円
		}

		return 0;
	}

}
