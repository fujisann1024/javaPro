package managerModel;

import java.io.Serializable;

public class Teacher implements Serializable{
	private String name;
	private String pass;
	
	public Teacher() {
		
	}
	
	public Teacher (String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	
	public String getPass() {
		return pass;
	}

	
}
