package co.yedam.warehousing.history.service;

import java.sql.Date;

import lombok.Data;

@Data
public class HistoryVO {
	private int historyNo;
	private String historyType;
	private int productNo;
	private String productName;
	private int productPrice;
	private int historySellPrice;
	private int historyAmount;
	private int historyCost;
	private Date historyDate;
	
	public String toString() {
		System.out.print(historyNo + " ");
		System.out.print(historyType + " ");
		System.out.print(productNo + " ");
		System.out.print(productName + " ");
		System.out.print(productPrice + " ");
		if(historySellPrice != 0) {
			System.out.print(historySellPrice + " ");
		}
		System.out.print(historyAmount + " ");
		System.out.print(historyCost + " ");
		System.out.print(historyDate + " ");
		return null;
	}
}
