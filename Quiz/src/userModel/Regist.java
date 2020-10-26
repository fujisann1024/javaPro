package userModel;

public class Regist {
   private String userId;
   private String userName;
   private String email;
   private String pass;
   private String morf;

   public Regist() {

   }

   //フォームから受け取ったデータをインスタンスに格納する
   public Regist(String userName,String email,
   String pass,String morf) {
	   this.userName = userName;
	   this.email = email;
	   this.pass = pass;
	   this.morf = morf;
   }

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public String getMorf() {
		return morf;
	}

}
