package co.yedam.calculator;

public class Person {
	String name;
	int age;
	double height;
	
	int sum(int n1, int n2) {
//		Calculator cal = new Calculator();
		return Calculator.add(n1, n2); // 정적메소드 호출.
	}
	
	// 기본생성자 : 자바컴파일러 생성.
	Person(){}
}
