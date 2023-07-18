package co.yedam.calculator;

public class Calculator {
	static int price;
	static String model;
	
	// 정적메소드.
	static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	static String showInfo() {
		return "모델은: " + model + "가격은: " + price;
	}
}
