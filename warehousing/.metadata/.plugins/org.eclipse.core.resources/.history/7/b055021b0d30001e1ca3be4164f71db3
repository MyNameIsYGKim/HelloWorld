package co.yedam.warehousing.product.service;

import lombok.Data;

@Data
public class ProductVO {
	private int productNo;
	private String productName;
	private int productPrice;
	private String productLocation;
	private int productAmount = 0;
	
//	@Override
//	public String toString() {
//		return productNo + " " + productName + " " + productPrice 
//				+ " " + productLocation + " " + productAmount;
//	}
	
	public void string() {
		System.out.printf("%-4d %-10s %6d %4s %4d\n", productNo, 
				productName, productPrice, productLocation, productAmount);
	}
}
