package co.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
		
		Date today = new Date();
		// Date -> String
		System.out.println(sdf.format(today));
		
//		Date tday = new Date(2023, 2, 10);
		Date tday = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			tday = sdf.parse("2023-01-10 10:10:20");
			System.out.println(tday);
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		String result = DateUtil.dateToStr(today, "yyyy-MM-dd");
		System.out.println(result);
		
		// 문자열(2023-03-05) => Tue Mar 5 00:00:00 KST 2023
		Date dday = DateUtil.strToDate("2023-03-05");
		System.out.println(dday);
	} // end of main.
	
	
}
