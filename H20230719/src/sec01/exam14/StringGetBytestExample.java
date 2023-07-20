package sec01.exam14;

import java.io.UnsupportedEncodingException;

public class StringGetBytestExample {
	public static void main(String[] args) {
		
		String str = "안녕";
		
		// 기본 문자열로 인코딩과 디코딩
		byte[] b1 = str.getBytes(); // 문자열을 바이트 배열로 인코딩
		System.out.println("b1.length: " + b1.length);
		String str1 = new String(b1); // 문자열로 디코딩
		System.out.println("b1->String: " + str1);
		
		try {
			
			// EUC-KR 타입으로 인코딩과 디코딩
			byte[] b2 = str.getBytes("EUC-KR");
			System.out.println("b2.length: " + b2.length);
			String str2 = new String(b2, "EUC-KR");
			System.out.println("b2->String: " + str2);
			
			// UTF-8 타입으로 인코딩과 디코딩
			byte[] b3 = str.getBytes("UTF-8");
			System.out.println("b3.length: " + b3.length);
			String str3 = new String(b3, "UTF-8");
			System.out.println("b3->String: " + str3);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
