package co.yedam.calculator;

public class MainExe {
	public static void main(String[] args) {
		Person person = new Person(); // 인스턴스 생성.
		
		int result = person.sum(1232, 2340);
		System.out.println("결과: " + result);
		
		// 인스턴스 필드와 메소드로 사용할 경우.
//		Calculator cal = new Calculator();
//		cal.model = "SSC101";
//		cal.price = 20000;
//		cal.showInfo();
		
		Calculator.model = "SSC101";
		Calculator.price = 20000;
		Calculator.showInfo();
	}
}
