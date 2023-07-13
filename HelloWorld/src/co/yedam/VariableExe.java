package co.yedam;

public class VariableExe {
	public static void main(String[] args) {
		// 정수형.
		int num1 = 100;		// 4Byte
		System.out.println(Integer.MAX_VALUE); // 2147483647
	
		long num2 = 200;	// 8byte
		System.out.println(Long.MAX_VALUE); // 9223372036854775807
		
		byte num3 = 30;		// -128 ~ 127 (8bit = 1Byte)
		num3 = 126;
		for(int i= 1; i < 10; i++) {
			System.out.println("num3 : "+ num3++);
		}
		short num4 = 32767;		// 2Byte
		
		int result = num3 + 30;
//		result = 12345678900;
		
		char chr = 97; // 2Byte - 65536개의 유니코드.
		for(int i=1; i<=26; i++) {
			System.out.println(chr++);
		}
//		System.out.println((int)chr);	// 형변환.
//		System.out.println(chr);
		
	}
}
