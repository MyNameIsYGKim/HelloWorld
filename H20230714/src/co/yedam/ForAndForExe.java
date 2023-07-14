package co.yedam;

import java.util.Scanner;

public class ForAndForExe {
	public static void main(String[] args) { // main-------------------------
		practice3();
	} // end of main --------------------------------------------------------
	
	public static void practice3() {
		boolean run = true;
		while(run) {
			int dice[] = {(int)Math.floor(Math.random()*6+1), (int)Math.floor(Math.random()*6+1)};
			System.out.println(dice[0]+", "+dice[1]);
			if(dice[0] + dice[1] == 5) {
				System.out.println("5만들기 완료");
				run = false;
			}else {
				continue;
			}
		}
	} // end practice3()
	
	public static void practice4() {
		for(int i=1; i<11; i++) {
			for(int j=1; j<11; j++) {
				if(4*i + 5*j == 60) {
					System.out.printf("(%i, %j)\n");
				}
			}
		}
	} // end practice4()

	public static void practice5() {
		
	} // end practice5()
	
	public static void ForAndFor() {
//		for(int i=2; i < 4; i++) {
//		System.out.printf("====%d단====\n", i);
//		for(int j=1; j < 10; j++) {
//			System.out.printf("%d * %d = %d\n", i, j, i*j);
//		}
//	}
	
		for(int i = 1; i < 10; i++) {
			for(int j = 2; j < 5; j++) {
				System.out.printf("%d * %d = %d \t", j, i, j*i);
			}
			System.out.println();
		}
	} // end ForAndFor()

}
