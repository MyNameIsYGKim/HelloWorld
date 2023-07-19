package co.yedam;

public class Friend {
	private String name;
	private String phone;
	private int birth;
	private double height;
	
	// 생성자.
	public Friend(String name, String phone, int birth, double height) {
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.height = height;
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
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	// 메소드
	Friend[] friends = new Friend[10];
	
	public void register(String name, String phone, int birth, double height) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] == null) {
				friends[i].name = name;
				friends[i].phone = phone;
				friends[i].birth = birth;
				friends[i].height = height;
			}
		}
	}
	
	public void list() {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) {
				System.out.println(
						"이름: "+friends[i].name+", 전화번호: "+friends[i].phone+
						", 생일: "+friends[i].birth+", 키: "+friends[i].height);
			}
		}
	}
	
	public void modify(String name, String phone) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i].name == name) {
				friends[i].phone = phone;
			}
		}
	}
	
	public void remove() {
		
	}
}
