package co.yedam.bank;

import java.util.Scanner;

import co.yedam.student.Student;

public class BankAppExe {
	public static void main(String[] args) {
		// 1.등록: 계좌번호, 입금주, 입금액
		// 2.입금: 계좌번호, 입금액
		// 3.출금: 계좌번호, 출금액
		// 4.잔액: 계좌번호, 잔액
		// 5.계좌목록: 목록출력
		
		BankApp app = BankApp.getInstance(); //new BankApp();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		Account a1 = new Account("1", "홍길동", 200000);
		app.account[0] = a1;
		Account a2 = new Account("2", "금잔디", 5000000);
		app.account[1] = a2;
		Account a3 = new Account("3", "노민희", 3000);
		app.account[2] = a3;
	
		while(run) {
			System.out.println("선택>> 1.등록 2.입금 3.출금 4.잔액 5.계좌목록 6.종료");
			int put = Integer.parseInt(scn.nextLine());
			
			if(put == 1) {
				// 1.등록: 계좌번호, 입금주, 입금액
				System.out.println("계좌번호> ");
				String account = scn.nextLine();
				System.out.println("입금주> ");
				String name = scn.nextLine();
				System.out.println("입금액> ");
				int money = Integer.parseInt(scn.nextLine());
				Account acc = new Account(account, name, money);
				
				if(app.registerAccount(acc)) {
					System.out.println("등록되었습니다.");
				}else {
					System.out.println("등록실패.");
				}
				break;
				
			}else if(put == 2) {
				// 2.입금: 계좌번호, 입금액
				System.out.println("입금할 계좌번호> ");
				String account = scn.nextLine();
				System.out.println("입금할 금액> ");
				int money = Integer.parseInt(scn.nextLine());
				
				if(money > 0) {
					app.deposit(account, money);
				}else {
					System.out.println("입금액은 0원보다 커야합니다.");
				}
				System.out.println("잘못된 계좌입니다.");
				break;
				
			}else if(put == 3) {
				// 3.출금: 계좌번호, 출금액
				System.out.println("출금할 계좌번호> ");
				for(int i=0; i < app.account.length; i++) {
					if(app.account[i].account.equals(scn.nextLine())) {
						String account = scn.nextLine();
						System.out.println("출금할 금액> ");
						int money = Integer.parseInt(scn.nextLine());
						if(money > 0) {
							app.withdraw(account, money);
						}else {
							System.out.println("출금액은 0원보다 커야합니다.");
						}
					}else {
						System.out.println("잘못된 계좌입니다.");
						break;
					}
				}
				
			}else if(put == 4) {
				// 4.잔액: 계좌번호, 잔액
				System.out.println("조회할 계좌번호> ");
				String account = scn.nextLine();
				app.checkBalance(account);
				
			}else if(put == 5) {
				// 5.계좌목록: 목록출력
				Account[] ary = app.account();
				for(int i = 0; i < ary.length; i++) {
					if(ary[i] != null) {
						System.out.printf("계좌번호 %s, 이름 %s, 잔액 %d\n", 
							ary[i].account, ary[i].name, ary[i].money);
					}
				}
				
			}else if(put == 6) {
				// 종료.
				run = false;
				System.out.println("종료합니다.");
				
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
