package userModel;

import java.io.Serializable;

public class LoginUser implements Serializable{

	private String email;
	private String pass;

	public LoginUser() {

	}
	//フォームから送られてきたデータを格納したときに
	//使うコンストラクタ
	public LoginUser(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}


}
