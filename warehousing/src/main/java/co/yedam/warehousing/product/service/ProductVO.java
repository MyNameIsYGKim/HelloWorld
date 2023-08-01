package co.yedam.warehousing.product.service;

import java.text.DecimalFormat;

import lombok.Data;

@Data
public class ProductVO {
	DecimalFormat dFormatter = new DecimalFormat("###,###,###");
	
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
		System.out.printf("%-4d %-10s %6s %4s %4d\n", productNo, 
				productName, dFormatter.format(productPrice),
				productLocation, productAmount);
	}
}
