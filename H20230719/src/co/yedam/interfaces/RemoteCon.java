package co.yedam.interfaces;


// 인터페이스.
// 생성자(X), 필드(O): 상수로 사용, 메소드: 추상메소드로 선언.
public interface RemoteCon {
	final int CHANNEL = 10; // final 자동으로 적용
	
	abstract void turnOn(); // 자동 abstract
	void turnOff();
}
