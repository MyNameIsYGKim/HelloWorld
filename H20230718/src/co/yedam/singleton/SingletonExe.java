package co.yedam.singleton;

public class SingletonExe {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); // new Singleton();
		Singleton s2 = Singleton.getInstance(); // new Singleton();
		System.out.println(s1 == s2); // 인스턴스 공유 메모리 절약.
	}
}
