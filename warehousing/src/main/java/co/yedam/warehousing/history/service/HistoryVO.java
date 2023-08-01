package co.yedam.warehousing.history.service;

import java.sql.Date;
import java.text.DecimalFormat;

import lombok.Data;

@Data
public class HistoryVO {
	DecimalFormat dFormatter = new DecimalFormat("###,###,###");
	
	private int historyNo;
	private String historyType;
	private int productNo;
	private String productName;
	private int productPrice;
	private int historyPrice;
	private int historyAmount;
	private int historyCost;
	private Date historyDate;
	
	public void string() {
//		System.out.print(historyNo + " ");
//		System.out.print(historyType + " ");
//		System.out.print(productNo + " ");
//		System.out.print(productName + " ");
//		System.out.print(productPrice + " ");
//		if(historySellPrice != 0) {
//			System.out.print(historySellPrice + " ");
//		}
//		System.out.print(historyAmount + " ");
//		System.out.print(historyCost + " ");
//		System.out.print(historyDate + " ");
//		return null;
		System.out.printf("%-4d %2s %4d %-10s %6s %6s %3d %10s %10s\n", 
				historyNo, historyType, productNo, productName, 
				dFormatter.format(productPrice), dFormatter.format(historyPrice), 
				historyAmount, dFormatter.format(historyCost), historyDate);
	}
}
