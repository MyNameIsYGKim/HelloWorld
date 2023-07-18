package co.yedam.student;

import java.util.Scanner;

public class StudentAppExe {
	public static void main(String[] args) {
		// 메뉴: 1.등록 2.목록 3.합계 4.최고점 5.종료.
		// 기능 구현.
		StudentApp app = new StudentApp();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.합계 4.최고점 5.종료\n선택>> ");
			int put = Integer.parseInt(scn.nextLine());
			
			if(put == 1) {
				System.out.println("학생번호>> ");
				String no = scn.nextLine();
				System.out.println("학생이름>> ");
				String name = scn.nextLine();
				System.out.println("학생점수>> ");
				int score = Integer.parseInt(scn.nextLine());
				System.out.println("학생키>> ");
				double height = Double.parseDouble(scn.nextLine());
				
				Student student = new Student(no, name, score, height);
				if(app.addStudent(student)) {
					System.out.println("정상적으로 등록되었습니다.");
				}else {
					System.out.println("등록이 안되었습니다.");
				}
				
			}else if(put == 2) {
				Student[] ary = app.studentList();
				for(int i = 0; i < ary.length; i++) {
					if(ary[i] != null) {
						System.out.printf("학생번호 %s, 이름 %s, 점수 %d\n", 
							ary[i].stdNo, ary[i].stdName, ary[i].score);
					}
				}
			}else if(put == 3) {
				int result = app.sumScores();
				System.out.println("합계점수는 " + result);
			}else if(put == 4) {
				int result = app.maxPrint();
				System.out.println("최고점수는 " + result);
			}else if(put == 5) {
				System.out.println("종료합니다.");
				run = false;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
//		app.studentList();
//		app.sumScores();
//		app.maxPrint();
	}
}
