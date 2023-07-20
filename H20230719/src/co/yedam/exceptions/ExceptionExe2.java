package co.yedam.exceptions;

import java.util.Scanner;

public class ExceptionExe2 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int age;
		
		System.out.println("이름>> ");
		String name = scn.nextLine();
		
		while(true) {
			System.out.println("나이>> ");
			try {
				age = Integer.parseInt(scn.nextLine());
				break;
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
				// continue;
			}
		}
		
		System.out.println("주소>> ");
		String addr = scn.nextLine();
		
		System.out.printf("이름은 %s, 나이는 %d, 주소는 %s",
				name, age, addr);
		
	} // end of main.

}
