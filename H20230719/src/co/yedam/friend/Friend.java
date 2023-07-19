package co.yedam.friend;

public class Friend {
	// 이름, 연락처.
	private String name;
	private String phone;
	
	// 생성자.
	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	public Friend() {}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// showInfo
	public String showInfo() {
		return  "이름: " + name + ", 연락처: " + phone;
	}
}
