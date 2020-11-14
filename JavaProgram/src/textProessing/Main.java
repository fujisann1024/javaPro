package textProessing;

public class Main {

	public static void main(String[] args) {
		//文字列を調査するメソッド
		String name1 = "TaNaKa";
		String name2 = "tanaka";
		String name3 = "";
		System.out.println("調査メソッド");
		Text.equalCheck(name1, name2);
		Text.equalsIgnoreCase(name1, name2);
		Text.stringLength(name2);
		Text.isEmpty(name3);
		System.out.println();
		//文字列を検索するメソッド
		System.out.println("検索メソッド");

		String textWord = "Diffrence Java AND JavaScript";
		Text.contains(textWord,"Python" );
		Text.startsWith(textWord, "Diffrence");
		Text.endsWith(textWord, "Diffrence");
		Text.checkStringStartPosition(textWord, "Java");
		Text.checkStringLastPosition(textWord, "Java");
		System.out.println();

		System.out.println("切り取りメソッド");
		char text1 = Text.cutChar(textWord, 4);
		System.out.println(text1);
		String text2 = Text.cutString(textWord, 4, 8);
		System.out.println(text2);

		System.out.println("連結メソッド");
		//Text.connectKeywords("犬");
		Text.connectWords("犬");
	}

}
