package co.yedam.singleton;

public class Singleton {
	private static Singleton instance = new Singleton();
	
	// 외부접근불가.
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return instance;
	}
}
