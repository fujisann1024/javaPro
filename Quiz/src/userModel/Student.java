package userModel;

import java.io.Serializable;

public class Student implements Serializable{
	//後々データベースに保存する内容
	private int userId; //ユーザーID
	private String userName; //ユーザー名


	public Student () {

	}
	//ログイン成功時にSQLに格納されるコンストラクタ
	public Student(int userId,String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public int getUserId(){
		return userId;
	}

	public String getUserName() {
		return userName;
	}

}
