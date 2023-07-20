package co.yedam.abstracts;

public class SmartPhone extends Phone {
	
	// 생성자 존재해야함.
	public SmartPhone(String owner) {
		super(owner);
	}
	
	@Override
	public void powerOn() {
		System.out.println("스마트폰 전원을 켬니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("스마트폰 전원을 끕니다.");
	}
	
	public void internetSearch() {
		System.out.println("검색기능.");
	}
}
