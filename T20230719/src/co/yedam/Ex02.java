package co.yedam;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int num1 = 0;
		int num2 = 0;
		int min = 0;
		int max = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		while(run) {
			System.out.println("선택> [1]수1입력 [2]수2입력");
			int put = Integer.parseInt(scn.nextLine());
			
			if(put==1) {
				System.out.println("수1 입력>> ");
				num1 = Integer.parseInt(scn.nextLine());
				if(num1<0) {
					System.out.println("0이상이어야 합니다.");
					num1=0;
				}
			}else if(put==2) {
				System.out.println("수2 입력>> ");
				num2 = Integer.parseInt(scn.nextLine());
				if(num2<0) {
					System.out.println("0이상이어야 합니다.");
					num2=0;
				}
			}else {
				System.out.println("잘못된 입력입니다.");
			}
			if(num1>0 || num2>0) {
				if(num1>=num2) {  // 큰값, 작은값 결정.
					max = num1;
					min = num2;
				}else if(num2>num1) {
					max = num2;
					min = num1;
				}
				
				for(int i=min; i<=max; i++) { // 2배수 합
					if(i % 2 == 0) {
						sum2 += i;
					}
				}
				for(int i=min; i<=max; i++) {// 3배수 합
					if(i % 3 == 0) {
						sum3 += i;
					}
				}
				
				System.out.println(min+" ~ "+max+"사이의 2의 배수의 합은: "+sum2);
				System.out.println(min+" ~ "+max+"사이의 3의 배수의 합은: "+sum3);
			}
			
		} // end of while.
	}
}
