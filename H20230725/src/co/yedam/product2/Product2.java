package co.yedam.product2;

public class Product2 {
	private int no;
	private String name;
	private int price;
	private int amount;
	private String date;
	private int totalAmount = 0;
	
	// 생성자
	public Product2(String name, int price, int amount) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	// getter, setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSellDate() {
		return date;
	}
	public void setSellDate(String sellDate) {
		this.date = sellDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	public String buyString() {
		return "Product2 [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + ", date="
				+ date + "]";
	}

	
	
}






