package co.yedam.interfaces;

public class MainExe {

	public static void main(String[] args) {
		Audio audio = new Audio();
//		audio.turnOn();
//		audio.turnOff();
		
		Television tv = new Television();
//		tv.turnOn();
//		tv.turnOff();
		
		// 인터페이스.
		RemoteCon rc = tv;
//		rc = tv;
		rc.turnOn();
		rc.turnOff();
	}

}
