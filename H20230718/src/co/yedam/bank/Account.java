package co.yedam.bank;

public class Account {
	String account;
	String name;
	int money;
	
	public Account(String account, String name, int money) {
		super();
		this.account = account;
		this.name = name;
		this.money = money;
	}
	
	public String showList() {
		return "계좌번호: "+account+", 예금주: "+name+", 잔액: "+money;
	}
	
}
