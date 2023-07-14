package co.yedam.reference;

import java.util.Scanner;

public class ArrayPracticeExe {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0; // 학생수
		int[] scores = {}; // 학생 점수 배열
		Scanner scn = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------");
			System.out.println("선택>> ");
			
			int selectNo = Integer.parseInt(scn.nextLine());
			if(selectNo == 1) {
				System.out.println("학생수 입력>> ");
				studentNum = Integer.parseInt(scn.nextLine());
				scores = new int[studentNum];
			}else if(selectNo == 2) {
				if(studentNum == 0) {
					System.out.println("학생수를 먼저 입력하세요.");
				}else {
					for(int i=0; i < studentNum; i++) {
						System.out.println("scores["+i+"]> ");
						scores[i] = Integer.parseInt(scn.nextLine());
					}
				}
			}else if(selectNo == 3) {
				if(scores[0] == 0) {
					System.out.println("점수를 먼저 입력하세요.");
				}else {
					for(int i=0; i < studentNum; i++) {
						System.out.println("score["+i+"]> "+scores[i]);
					}
				}
			}else if(selectNo == 4) {
				if(studentNum == 0 || scores == null) {
					System.out.println("학생수와 점수 모두 입력해야 합니다.");
				}else {
					int sum = 0;
					int max = 0;
					for(int i=0; i < studentNum; i++) {
						sum += scores[i];
					}
					for(int i=0; i < studentNum; i++) {
						if(scores[i]>max) {
							max = scores[i];
						}
					}
					System.out.println("최고 점수 : "+max);
					System.out.println("평균 점수 : "+sum/studentNum);
				}
			}else if(selectNo == 5) {
				run = false;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		System.out.println("end of prog");
	} // end of main.

}
