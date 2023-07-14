package co.yedam;

import java.util.Scanner;

public class WhileLoopExe {
	static Scanner scn = new Scanner(System.in);
	static int balance = 0;
	public static void main(String[] args) { // main---------------------------------
		boolean run = true;
		// 은행: 1.입금 2.출금 3.잔액 4.종료
		// 제한금액: 10만원, 5만원 +5.2만원
		// 마이너스 통장 불가
		while(run) {
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: deposit(); break;
			case 2: withdraw(); break;
			case 3: check(); break;
				
			case 4:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
		System.out.println("종료합니다.");
		
	} // end of main-------------------------------------------------------------------
	
	
	public static void deposit() {
		System.out.print("입금액을 입력하세요>> ");
		int deposit = Integer.parseInt(scn.nextLine());
		if(deposit > 100000-balance) {
			System.out.println("통장 잔고는 100,000원을 초과할 수 없습니다.\n잔액 : "+balance);
			return; // continue;
		}
		balance += deposit;
//		else {
//			balance += deposit;
//		}
	} // end deposit()
	
	public static void withdraw() {
		System.out.print("출금액을 입력하세요>> ");
		int withdraw = Integer.parseInt(scn.nextLine());
		if(withdraw > balance) {
			System.out.println("출금액이 통장 잔고보다 많습니다.\n잔액 : "+balance);
		}else {
			balance -= withdraw;
		}
	} // end withdraw()
	
	public static void check() {
		System.out.printf("현재 잔액은 %d 입니다.\n", balance);
	} // end check()

}
