package co.yedam.polymorphism;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		// 매개변수의 다형성.
		driver.drive(new Vehicle());
		driver.drive(new Bus());
		driver.drive(new Taxi());
	}
}
