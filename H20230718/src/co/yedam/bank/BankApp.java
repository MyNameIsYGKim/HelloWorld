package co.yedam.bank;

// 기능구현.
public class BankApp {
	// 등록, 입금, 출금, 잔액확인, 계좌목록.
	// 등록: registerAccount (계좌번호,예금주,입금액)
	// 입금: deposit (계좌번호,입금액)
	// 출금: withdraw (계좌번호,출금액)
	// 잔액: checkBalance (계좌번호)
	// 목록: accountList()
	
	// 싱글톤 방식.
	private static BankApp instance = new BankApp();
	
	
	// 필드.
	Account[] accounts;
	int accountNum = 0;
	
	// 생성자
	private BankApp() {
		accounts = new Account[10];
	}
	
	public static BankApp getInstance() {
		return instance;
	}
	
	
	Account[] account = new Account[30];
	Account[] account() {
		return account;
	}
	
	
	boolean registerAccount(Account acnt) { // 등록.
		if(accountNum >= 30) {
			return false;
		}else {
			for(int i=0; i < accountNum; i++) {
				if(account[i] != null) {
					account[accountNum] = acnt;
					accountNum++;
				}
			}
			return true;
		}
	}
	
	int deposit(String acc, int money) { // 입금.
		for(int i=0; i < account.length; i++) {
			// 계좌가 있으면 1 없으면 0 리턴.
			if(account[i].account.equals(acc)) {
				account[i].money += money;
				System.out.println("입금완료.");
				return 1;
			}
		}
		return 0;
	}
	
	void withdraw(String acc, int money) { // 출금.
		for(int i=0; i < account.length; i++) {
			if(account[i].account.equals(acc)) {
				if(money <= account[i].money) {
					account[i].money -= money;
					System.out.println("출금완료.");
					break;
				}else {
					System.out.println("잔고가 부족합니다.");
				}
			}else {
				System.out.println("잘못된 계좌번호입니다.");
			}
		}
	}
	
	void checkBalance(String acc) { // 잔고.
		for(int i=0; i < accountNum; i++) {
			if(account[i].account == acc) {
				System.out.println(account[i].money);
			}else {
				System.out.println("잘못된 계좌번호입니다.");
			}
		}
	}
	
//	void accountList() { // 계좌리스트
//		return account();
//		for(int i=0; i < accountNum; i++) {
//			System.out.println("계좌번호: "+account[i].account+", 예금주: "+account[i].name+", 잔액: "+account[i].money);
//		}
//	}
	
	
	
}
