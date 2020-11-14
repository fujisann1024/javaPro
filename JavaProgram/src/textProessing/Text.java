package textProessing;

public class Text {
	//①文字列を調査するメソッド
	//文字列の内容が等しいかどうかを調べるメソッド
	public static void equalCheck(String args1, String args2) {
		if(args1.equals(args2)) {
			System.out.println("この文字列は等しい");
		}else {
			System.out.println("この文字列は等しくない");
		}
	}

	//大文字小文字を区別せず等しいかどうかを調べる
	public static void equalsIgnoreCase(String args1, String args2) {
		if(args1.equalsIgnoreCase(args2)) {
			System.out.println("この文字列は大小を無視して等しい");
		}else {
			System.out.println("この文字列は大小を無視しても等しくない");
		}
	}

	//文字列の長さを表示するメソッド
	public static void stringLength(String args1) {
		System.out.println("この文字列は" + args1.length() + "です");
	}

	//文字列が空かどうかを調べる
	public static void isEmpty(String args1) {
		if(args1.isEmpty()) {
			System.out.println("この変数の中身は空です");
		}else {
			System.out.println("この変数の中身に値が設定されています");
		}
	}

	//②文字列を検索するメソッド
	//第一引数の文字列に第二引数の文字が含まれているのかを調べる
	public static void contains(String args1,String args2) {
		if(args1.contains(args2)) {
			System.out.println(args1 +"の文字列には" +
		     args2 + "の文字列が含まれています");
		}else {
			System.out.println(args1 +"の文字列には" +
				     args2 + "の文字列は含まれていません");
		}
	}

	//第二引数の文字列が第一引数の文字列の先頭に含まれているか
	public static void startsWith(String args1,String args2) {
		if(args1.startsWith(args2)) {
			System.out.println(args2 + "は"+ args1 + "の先頭に含まれています");
		}else {
			System.out.println(args2 + "は"+ args1 + "の先頭には含まれていません");
		}
	}

	//第二引数の文字列が第一引数の文字列の語尾に含まれているか
	public static void endsWith(String args1,String args2) {
		if(args1.endsWith(args2)) {
			System.out.println(args2 + "は"+ args1 + "の語尾に含まれています");
		}else {
			System.out.println(args2 + "は"+ args1 + "の語尾には含まれていません");
		}
	}

	//第二引数の文字列が第一引数の文字列上で最初から何番目に現れるか
	public static void checkStringStartPosition(String args1,String args2) {
		System.out.println("文字列"+args1 + "で,\n最初に" + args2 +
	    "が登場する位置は" + args1.indexOf(args2) + "番目");
	}

	//第二引数の文字列が第一引数の文字列上で最後から何番目に現れるか
	public static void checkStringLastPosition(String args1,String args2) {
		System.out.println("文字列"+args1 + "で,\n最後に" + args2 +
	    "が登場する位置は" + args1.lastIndexOf(args2) + "番目");
	}

	//③文字列を切り出す
	//第一引数の文字列から第二引数で指定した位置の1文字を切り出す
	public static char cutChar(String args,int i) {
		char oneString = args.charAt(i);
		System.out.println(args+"の"+(i+1) + "番目の文字\n「" +
		          oneString + "」を切り取りました" );
		return oneString;
	}

	public static String cutString(String args,int start,int end) {
		String text = args.substring(start,end);
		System.out.println(args+"の"+(start+1) + "番目の文字から、\n" +
		         end + "番目を切り取りました" );
		return text;
	}


	//普通のfor文
	public  static void connectKeywords(String words) {
		for(int i = 0; i < 50; i++) {
			words += words;

		}
		System.out.print(words);
	}

	public static void connectWords(String word) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100; i++) {
			sb.append(word);
		}
		System.out.println(sb.toString());
	}

}
