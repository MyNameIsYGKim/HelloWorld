package co.yedam;

import java.util.Scanner;

public class ConditionExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택하세요(숫자입력)>> ");
			System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
			
			int num = Integer.parseInt(scn.nextLine());
			if(num == 1) {
				login();
			}else if(num == 2) {
				logout();
			}else if(num == 3) {
				signUp();
			}else if(num == 4) {
				System.out.println("end of prog.");
				break;
			}
			
			// switch, if else if else
			// "1" => equals, 1 => ==
		}
		
	} // end of main();
	
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
