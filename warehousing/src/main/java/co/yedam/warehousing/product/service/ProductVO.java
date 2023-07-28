package co.yedam.warehousing.product.service;

import lombok.Data;

@Data
public class ProductVO {
	private int productNo;
	private String productName;
	private int productPrice;
	private String productLocation;
	private int productAmount;
	
	public String toString() {
		System.out.print(productNo + " ");
		System.out.print(productName + " ");
		System.out.print(productPrice + " ");
		System.out.print(productLocation + " ");
		System.out.println(productAmount);
		return null;
	}
}
