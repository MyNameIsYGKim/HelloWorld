package co.yedam.product;

import java.io.Serializable;

public class Product implements Serializable { // 필드
	private int code;
	private String name;
	private int price;
	private String sellDate;
	private int sellAmount;
	private String buyDate;
	private int buyAmount;
	private int leftAmount = 0;
	
	// 생성자
	public Product(String name, int price, String sellDate, int sellAmount, String buyDate, int buyAmount,
			int leftAmount) {
		super();
		this.name = name;
		this.price = price;
		this.sellDate = sellDate;
		this.sellAmount = sellAmount;
		this.buyDate = buyDate;
		this.buyAmount = buyAmount;
		this.leftAmount = leftAmount;
	}

	public Product(int code, String name, int price) { // 상품등록용.
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	// getter, setter
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public int getSellAmount() {
		return sellAmount;
	}
	public void setSellAmount(int sellAmount) {
		this.sellAmount = sellAmount;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public int getBuyAmount() {
		return buyAmount;
	}
	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}
	public int getLeftAmount() {
		return leftAmount;
	}
	public void setLeftAmount(int leftAmount) {
		this.leftAmount = leftAmount;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + ", leftAmount=" + leftAmount + "]";
	}

//	@Override
//	public String toString() {
//		return "Product [code=" + getCode() + ", name=" + getName() + ", leftAmount=" + getLeftAmount() + "]";
//	}
	
	
	
}










