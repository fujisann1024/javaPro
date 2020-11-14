package practice;

public class Coding2 {

	//Point8～型を使ってコードを分かりやすく安全にする
	//例1～int型なので順番が違ってもエラーが出ず,
	//     実行結果が同じなのでエラーを見つけにくい
//		public int amount(int unitPrice, int quantity) {
//			return unitPrice * quantity;
//		}

	//例2～引数の入れる順番によって実行結果が違うので
	//     エラーが見つけやすいがそもそも順番が違うだけでエラーが
	//     出るようにしたい
//	public int amount(int unitPrice, int quantity) {
//		 final int DISCOUNT_CRITERIA = 30;//割引の基準
//		if(quantity >= DISCOUNT_CRITERIA) {
//			//2割引
//			return discountAmount(unitPrice,quantity);
//		}
//
//		return unitPrice * quantity;
//	}
//
//	//割引関数
//		private int discountAmount(int unitPrice, int quantity) {
//			return  (int) (unitPrice * quantity / 0.8);
//		}

	//例3
	public static Money amount(Money unitPrice,Quantity quantity) {

		if(quantity.isDiscountable()) {
			return discountAmount(unitPrice,quantity);
		}
		return unitPrice.multiply(quantity);
	}

		public static Money discountAmount(Money unitPrice, Quantity quantity) {

			unitPrice.price = (int)((unitPrice.multiply(quantity).getPrice()) * 0.8);
			return unitPrice;
		}



	public static void main(String[] args) {
//		int quantity = 50;//数量
//		int unitPrice = 100;//単価
		Quantity quantity = new Quantity(30);
		Money unitPrice = new Money(100);
		Money sellingPrice = amount(unitPrice,quantity);
		System.out.println(sellingPrice.getPrice());


	}

}
