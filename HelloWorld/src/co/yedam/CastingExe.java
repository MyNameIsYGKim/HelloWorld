package co.yedam;
// 타입변환.
public class CastingExe {
	public static void main(String[] args) {
		// let result = "10";
		int num1 =  100;
		long num2 = num1; // 자동형변환(promotion)
		
		int num3 = (int)num2; // 강제형변환(casting)
		
		String str = "120";
		num3 = Integer.parseInt(str); // 문자열 -> 정수
		System.out.println("num3 : " + num3);
		
		str = "12.3";
		double num4 = Double.parseDouble(str); // 문자열 -> 실수
		System.out.println("num4 : " + num4);
		
		System.out.print("num4 : " + num4);
		System.out.print("num4 : " + num4);
		
		System.out.printf("\nnum3의 값은 %5d, num4의 값은 %.2f %s", num3, num4, "입니다");
	}

}
