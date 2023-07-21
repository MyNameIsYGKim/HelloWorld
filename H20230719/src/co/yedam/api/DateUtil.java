package co.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String dateToStr(Date date) {
		// Date -> String 생성.
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
	public static String dateToStr(Date date, String pattern) {
		// Date -> String 생성.
		SimpleDateFormat sdf = 
				new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date strToDate(String str) {
		// String -> Date 생성.
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		
		try {
			result = sdf.parse(str);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}
