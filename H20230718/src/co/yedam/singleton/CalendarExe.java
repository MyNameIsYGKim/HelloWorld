package co.yedam.singleton;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("input(번호 이름 성적)>> ");
		String str;
		
		String no = scn.next();
		String name = scn.next();
		String score = scn.next();
		System.out.println("번호: " + no + ", 이름: " + name + ", 점수: " + score);
		
		showCal(2023,7);
		
	}
	
	public static void showCal(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		
//		System.out.println("년도: " + cal.get(Calendar.YEAR));
//		System.out.println("월: " + (cal.get(Calendar.MONTH)+1) );
//		System.out.println("날짜: " + cal.get(Calendar.DATE));
//		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("말일: " + cal.getActualMaximum(Calendar.DATE));
		int max = cal.getActualMaximum(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("\t   "+year+". "+month);
		System.out.println(" Sun Mon Tue Wed Thr Fri Sat");
		for(int i = 0; i < day-1; i++) {
			System.out.printf("%4s", "");
		}
		for(int i = 1; i <= max; i++) {
			System.out.printf("%4s", i);
			if( ((i + day)-1) % 7 == 0 ) {
				System.out.println();
			}
			
		}
	}
}
