package co.yedam.abstracts;

public class MainExe {

	public static void main(String[] args) {
		// 추상클래스.
		// Phone phone = new Phone("사용자"); // 인스턴스 생성 불가.
		SmartPhone phone = new SmartPhone("기본");
		phone.powerOn();
		phone.powerOff();
	}

}
