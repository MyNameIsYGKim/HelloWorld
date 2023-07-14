package co.yedam;

public class ForLoopExe {

	public static void main(String[] args) {
		showCalendar(7);
	} // end of main()
	
	public static void showCalendar(int month) {
		System.out.println("          2023년 "+month+"월");
		
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		
		for(int i=0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println(); // 줄 바꿈.
		
		// 1일의 위치 지정
		int pos = getFirstDay(month);
		for(int i=0; i < pos; i++) { 
			System.out.printf("%4s", "");
		}
		
		int lastDate = getLastDay(month);
		for(int i=1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if((i + pos) % 7 == 0) {
				System.out.println();
			}
		}
	} // showCalendar()
	
	// 1일의 위치 지정(공간 반환)
	public static int getFirstDay(int month) {
		int pos = 0;
		
		switch(month) {
		case 2: pos = 3; break;
		case 3: pos = 3; break;
		case 4: pos = 6; break;
		case 5: pos = 1; break;
		case 6: pos = 4; break;
		case 7: pos = 6; break;
		case 8: pos = 2; break;
		case 9: pos = 5; break;
		}
		return pos;
	} // getFirstDay()
	
	
	// 월 정보에 따라 해당월 마지막날 반환.
	public static int getLastDay(int month) {
		int lastDate = 31;
		switch(month) {
		case 2: lastDate = 28; break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
		}
		return lastDate;
	} // getLastDay()
	
} // end of class
