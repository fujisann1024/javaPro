package fileOperation;

import java.io.FileWriter;
import java.io.IOException;

//テキストファイルを書き込む
public class TextWriting {

	FileWriter fileWriter = null;

	//ファイルを開く
	//第一引数～指定ファイルが存在する絶対パス
	//第二引数～記入する文字列
	public void newTextWriter(String path, String str) {
		try {
			fileWriter = new FileWriter(path);

			writeTextString(str);

			flushText();

		} catch (IOException e) {
			//指定されたファイルが存在するが通常ファイルではなく
			//ディレクトリである場合、存在せず作成もできない場合、
			//またはなんらかの理由で開くことができない場合
			System.out.println("エラー：" + e);
		} finally {
			closeText();
		}
	}

	//ファイルを開く
	//第一引数～指定ファイルが存在する絶対パス
	//第二引数～先頭から上書き:false,後ろから書く:true
	//第三引数～記入する文字列
	public void appendedTextWriter(String path, boolean continued, String str) {
		try {
			fileWriter = new FileWriter(path, continued);

			writeTextString(str);

			flushText();

		} catch (IOException e) {
			System.out.println("エラー：" + e);
		}finally {
			closeText();

		}
	}

	//ファイルに書き込む(すぐに書き込んでいるわけではない)
	//引数～入力する文字列
	private void writeTextString(String str) {
		try {
			fileWriter.write(str);
		} catch (IOException e) {
			//入出力エラーが発生した場合
			System.out.println("エラー：" + e);
		}
	}

	//JVMに今すぐ書かせる
	private void flushText() {
		try {
			fileWriter.flush();
		} catch (IOException e) {
			System.out.println("エラー：" + e);
		}
	}

	//ファイルを閉じる
	private void closeText() {
		try {
			//ファイルが開きっぱなしだったら閉じる
			if (fileWriter != null) {
				fileWriter.close();
			}
		} catch (IOException e) {
			System.out.println("エラー：" + e);
		}
	}

	public static void main(String[] args) {
		TextWriting fileWriting = new TextWriting();
		fileWriting.newTextWriter("C:\\test/data.txt", "こんにちは\n");
		fileWriting.appendedTextWriter("C:\\test/data.txt", true,"こんばんは");

	}

}
