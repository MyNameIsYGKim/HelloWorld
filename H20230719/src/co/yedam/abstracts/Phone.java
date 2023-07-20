package co.yedam.abstracts;

public abstract class Phone {
	// 필드
	private String owner;
	
	// 생성자
	public Phone(String owner) {
		this.owner = owner;
	}
	
	// 메소드
	public String getOwner() {
		return owner;
	}
	
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	// 추상메소드: 자식클래스에서 기능을 반드시 구현하도록 강제함.
	public abstract void powerOff();
}
