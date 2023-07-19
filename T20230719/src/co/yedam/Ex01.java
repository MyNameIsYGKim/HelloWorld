package co.yedam;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int num1 = 0;
		int num2 = 0;
		
		while(run) {
			System.out.println("선택> [1]수1입력 [2]수2입력");
			int put = Integer.parseInt(scn.nextLine());
			
			if(put==1) {
				System.out.println("수1 입력>> ");
				num1 = Integer.parseInt(scn.nextLine());
				if(num1<=0) {
					System.out.println("0보다 커야합니다.");
					num1=0;
				}
			}else if(put==2) {
				System.out.println("수2 입력>> ");
				num2 = Integer.parseInt(scn.nextLine());
				if(num2<=0) {
					System.out.println("0보다 커야합니다.");
					num2=0;
				}
			}else {
				System.out.println("잘못된 입력입니다.");
			}
			if(num1>0 && num2>0) {
				int max = Math.max(num1, num2);
				System.out.println("더 큰 수는 " + max + "입니다.");
				run = false;
			}
		} // end of while.
	}
		
}
