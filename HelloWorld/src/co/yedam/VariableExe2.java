package co.yedam;

public class VariableExe2 {
	public static void main(String[] args) {
		// 실수형
		double num1 = 1.2;	// 8 BYte
		double num2 = 1.2;
		
		double result  = num1 + num2;
		System.out.println(Double.MAX_VALUE);
		
		float num3 = 1.2f;	// 4 Byte
		float num4 = 1.2f;
		result = num3 + num4;
		System.out.println(result);
		System.out.println(Float.MAX_VALUE);
		
		// byte < short < int < long < float < double
		byte n1 = 10;
		short n2 = n1; // 작은 타입 -> 큰 타입 OK
		int n3  = 128;
		n1 = (byte)n3;
		System.out.println("n1 : " + n1);
		
		// boolean
		boolean trueOrFalse = true;
		trueOrFalse = false;
		
		trueOrFalse = 10 > 5;
	}
}
