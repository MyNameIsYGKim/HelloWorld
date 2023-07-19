package co.yedam.friend;

public class UnivFriend  extends Friend{
	
	private String univ;
	private String major;
	
	// 생성자
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
//		super.setName(name); // 기본생성자 있으면 가능.
//		super.setPhone(phone);
		this.univ = univ;
		this.major = major;
	}
	
	// getter, setter
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
//	@Override
//	public String showInfo() {
//		return super.showInfo() + ", 학교: " + univ + ", 전공: "+ major;
//	}
	
	@Override
	public String showInfo() {
		return "이름: " + super.getName() + ", 번호: " + super.getPhone() + ", 학교: " + univ + ", 전공: "+ major;
	}

	
}
