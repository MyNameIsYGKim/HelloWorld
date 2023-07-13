package co.yedam;

// 상속(부모 -> 자식)
public class PrintExe extends Object {
	public void showInfo() {
		System.out.println("helloy guys");
	}
	
	@Override
	public String toString() {
		return "PrintExe";
	}
}
