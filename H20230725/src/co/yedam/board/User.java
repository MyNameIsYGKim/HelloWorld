package co.yedam.board;

import java.io.Serializable;

public class User implements Serializable {
	String id;
	String name;
	String pw;
	
	public User(String id, String name, String pw) { // 회원가입용.
		this.id = id;
		this.name = name;
		this.pw = pw;
	}
	
	// getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
