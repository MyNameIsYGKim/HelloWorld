package co.yedam.grade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.product.Product;

public class StudentManager {

	Scanner scn = new Scanner(System.in);
	List<Student> list = new ArrayList<>();

	// 메뉴출력
	public void menu() { // 메뉴
		System.out.println("1.성적입력 2.전체성적출력 3.장학금대상자 4.종료");
	}

	public int studentNum() { // 학번
		int no = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo() > no) {
				no = list.get(i).getNo();
			}
		}
		return no + 1;
	} // end of printMenu();

	public void input() { // 1.성적입력
		int no = studentNum();
		System.out.println("[이름] [국어] [영어] [수학]");
		String[] str = scn.next().split(" ");
		Student student = new Student(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]),
				Integer.parseInt(str[3]));
		if (list.add(student)) {
			System.out.println("입력성공.");
		} else {
			System.out.println("입력실패.");
		}
	}

	public void studentList() { // 2.전체성적출력
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				System.out.println(list.get(i).toString());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("빈 목록입니다.");
		}
	}

	public void gradeA() { // 3.장학금대상자
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			Student student = list.get(i);
			int sum = student.kor + student.eng + student.math;
			double avg = 99.99;
			avg = sum/3;
			if (avg >= 90) {
				System.out.println("이름: " + list.get(i).getName() + ", 평균점수: " + avg);
				count++;
			}
		}
		if (count == 0) {
			System.out.println("장학생 없음.");
		}
	}

	// 파일 불러오기
	public void readFromFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/student.text");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Student>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
//				e.printStackTrace();
		}
	}

	// 파일에 저장하기
	public void storeToFile() throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/Temp/student.text");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
		fos.flush();
		fos.close();
	}

}
