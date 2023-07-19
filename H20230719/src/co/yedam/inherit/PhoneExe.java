package co.yedam.inherit;

public class PhoneExe {
	public static void main(String[] args) {
		
		CellPhone cellPhone = new CellPhone();
		cellPhone.setModel("Galaxy S10");
		cellPhone.setColor("White");
		cellPhone.powerOn();
		cellPhone.sendMessage();
		cellPhone.receiveMessage();
		cellPhone.powerOff();
		System.out.println(cellPhone.showInfo());
		
		System.out.println("------------------------");
		// 자식클래스는 부모클래스의 필드, 메소드, 생성자.
		DmbCellPhone dmbPhone = new DmbCellPhone();
		dmbPhone.setModel("Galaxy Dmb1");
		dmbPhone.setColor("Yellow");
		dmbPhone.powerOn();
		dmbPhone.turnOn();
		dmbPhone.changeChannel(10);
		dmbPhone.turnOff();
		dmbPhone.sendMessage();
		dmbPhone.receiveMessage();
		dmbPhone.powerOff();
		System.out.println(dmbPhone.showInfo());
		
		// 부모클래스의 변수에 자식크래스의 변수 대입.
		CellPhone parent = new DmbCellPhone("DMB S22", "White", 10); // promotion
		// parent.turnOn(); // 자식클래스의 필드, 메소드 사용이 불가.
		System.out.println(parent.getModel());
		DmbCellPhone child = null;
		
		if (cellPhone instanceof DmbCellPhone) {
			child = (DmbCellPhone) parent; // casting
			child.turnOn();
		}
		
		// 부모클래스의 변수를 자식변수로 casting 할 경우 체크.
		if (cellPhone instanceof DmbCellPhone) {
			child = (DmbCellPhone) cellPhone;
			child.turnOn();
		}
	}
}
