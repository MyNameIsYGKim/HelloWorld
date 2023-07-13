package co.yedam;

import java.io.IOException;

public class PrintStreamExe {
	public static void main(String[] args) {
		
		for(int i=1;  i<3; i++) {
			System.out.println(i);
		}
		
		try {
			while(true) {
				System.out.println("value>> "); // 49 13 10
				int result = System.in.read(); // Enter: 13, 10
				
				if(result != 13 && result != 10) {
					System.out.println("결과 : " + result);
					System.in.read(); // 입력스트림 값을 읽고 키 반환.
					System.in.read();
				}
				if(result == 113) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}

}
