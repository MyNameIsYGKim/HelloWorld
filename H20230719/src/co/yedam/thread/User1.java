package co.yedam.thread;

public class User1 extends Thread {
	Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		setName("User1 쓰레드");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(100);
	}
}
