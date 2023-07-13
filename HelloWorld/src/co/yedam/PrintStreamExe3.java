package co.yedam;

import java.util.Scanner;

public class PrintStreamExe3 {
	public static void main(String[] args) {
		// 사용자 3개 숫자(정수) 입력.
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		int maxVal = 0;
		int count = 0;
		while(true) {
			System.out.print("값>>> ");
			String put = scn.nextLine();
			if(put.equals("end")) {
				break;
			}
			int num = Integer.parseInt(put);
			if(num > maxVal){
				maxVal = num;
			}
			sum += num;
			count++;
		}
		int avg = sum/count;
		System.out.println("최대값은 : "+maxVal+"이고, 평균은 : "+avg+"입니다.");
		
		// max값과 평균값 계산 후 출력.
	}

}
