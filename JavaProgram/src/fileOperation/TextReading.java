package fileOperation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//テキストファイルを読み込む
public class TextReading {
	//ファイルを少しずつ読み込むインスタンス～ストリーム
	 FileReader fileReader = null;

	 //バッファリングフィルター
	 BufferedReader bufferedReader = null;

	 public TextReading() {

	 }

	 public void newReadText(String path) {
		 try {
			fileReader = new FileReader(path);

			readText();
		} catch (FileNotFoundException e) {
			System.out.println("エラー:" + e);
		}finally{
			closeText();
		}
	 }

	 //バッファリングすることで処理が速くなる
	 public void newBufferedReadText(String path) {
		 try {
			fileReader = new FileReader(path);

			bufferedReadText(fileReader);
		} catch (FileNotFoundException e) {
			System.out.println("エラー:" + e);
		}finally{
			closeText();
		}
	 }

	 private void readText() {

		 try {
			 //ファイルを読み込む
			int i = fileReader.read();

			while(i != -1) {
				char word = (char)i;

				System.out.print(word);

				i = fileReader.read();
			}
			System.out.println();
		} catch (IOException e) {
			System.out.println("エラー：" + e);
		}

	 }


	 private void closeText() {
		 try {
			 if(fileReader != null) {
				 fileReader.close();
			 }
		} catch (IOException e) {
			System.out.println("エラー:" + e);

		}
	 }


	//バッファリングフィルタを行って
	private void bufferedReadText(FileReader reader) {
		 bufferedReader = new BufferedReader(reader);

		 try {
			String line = bufferedReader.readLine();

			while(line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("エラー："+e);
		}finally {
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e2) {
					System.out.println("エラー："+e2);
				}
			}
		}



	 }


	public static void main(String[] args) {
		TextReading fileReading = new TextReading();
		fileReading.newReadText("C:\\test\\data.txt");
		fileReading.newBufferedReadText("C:\\test\\data.txt");


	}

}
