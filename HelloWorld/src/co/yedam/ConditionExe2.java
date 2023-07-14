package co.yedam;

import java.io.IOException;
import java.util.Scanner;

public class ConditionExe2 {
	public static void main(String[] args) {
		switchChoice();
	} // end of main();
	
	
	public static void menuChoice() {
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택하세요(숫자입력)>> ");
			System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
			String menu = scn.nextLine();
			int num = Integer.parseInt(menu);
			if(num == 1) {
				login();
			}else if(num == 2) {
				logout();
			}else if(num == 3) {
				signUp();
			}else if(num == 4) {
				System.out.println("end of prog.");
				scn.close();
				break;
			}
			
			// switch, if else if else
			// "1" => equals, 1 => ==
		}
	}
	
	public static void switchChoice() {
		boolean run = true;
		while(run) {
			System.out.println("메뉴를 선택하세요(숫자입력)>> ");
			System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
			Scanner scn = new Scanner(System.in);
			String menu = scn.nextLine();
//			try {
				switch(menu) {
				case "1": login(); break;
				case "2": logout(); break;
				case "3": signUp(); break;
				default: //	throw new IOException(); // 예외발생.
					run = false;
				}
//			} catch (IOException e) {
//				e.printStackTrace();
//				break;
//			}
			}
	}
	
	
	public static void login() {
		System.out.println("로그인메뉴입니다.");
	}
	public static void logout() {
		System.out.println("로그아웃메뉴입니다.");
	}
	public static void signUp() {
		System.out.println("회원가입메뉴입니다.");
	}
}
