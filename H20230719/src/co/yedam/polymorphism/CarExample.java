package co.yedam.polymorphism;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i = 0; i < 10; i++) {
			int problemLoc = car.run();
			
			switch(problemLoc) {
			case 1:
				System.out.println("앞왼쪽 타이어 펑크. 타이어 교체");
				car.frontLeft = new HankookTire("앞왼쪽", 10);
				break;
			case 2:
				System.out.println("앞오른쪽 타이어 펑크. 타이어 교체");
				car.frontRight = new Tire("앞오른쪽", 4);
				break;
			case 3:
				System.out.println("뒤왼쪽 타이어 펑크. 타이어 교체");
				car.backLeft = new HankookTire("뒤왼쪽", 15);
				break;
			case 4:
				System.out.println("뒤오른쪽 타이어 펑크. 타이어 교체");
				car.backRight = new Tire("뒤왼쪽", 6);
				break;
			}
			System.out.println("-----------------------------------");
		}
		System.out.println("end of run.");
	}
}
