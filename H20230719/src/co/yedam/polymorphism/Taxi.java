package co.yedam.polymorphism;

public class Taxi extends Vehicle{
	@Override
	public void run() {
		System.out.println("Taxi가 달립니다.");
	}
}
