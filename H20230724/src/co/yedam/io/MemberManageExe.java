package co.yedam.io;

import java.util.List;
import java.util.Scanner;

public class MemberManageExe {
	// 이름, 주소, 연락처 => 시작(초기값), 추가, 수정, 삭제, 목록, (종료)저장

	public static void main(String[] args) {
		MemberManage manager = new MemberManage();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			try {
				System.out.println("입력>> 1.추가 2.수정 3.삭제 4.목록 5.종료");
				int put = Integer.parseInt(scn.nextLine());

				if (put == 1) { // 1.추가
					try {
						System.out.println("추가> 이름 주소 연락처");
						String str = scn.nextLine();
						String[] data = str.split(" ");
						Member member = new Member(data[0], data[1], data[2]);
						if (manager.addMember(member)) {
							System.out.println("등록성공.");
						} else {
							System.out.println("등록실패.");
						}
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {
						System.out.println("잘못된 형식입니다.");
					}

				} else if (put == 2) { // 2.수정
					try {
						System.out.println("추가> 이름 주소 연락처");
						String str = scn.nextLine();
						String[] data = str.split(" ");
						Member member = new Member(data[0], data[1], data[2]);
						if (manager.editMember(member)) {
							System.out.println("변경성공.");
						} else {
							System.out.println("변경실패.");
						}
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {
						System.out.println("잘못된 형식입니다.");
					}

				} else if (put == 3) { // 3.삭제
					System.out.println("삭제> 이름");
					String str = scn.nextLine();
					if (manager.delMember(str)) {
						System.out.println("삭제성공.");
					} else {
						System.out.println("잘못된 값입니다.");
					}

				} else if (put == 4) { // 4.목록
					List<Member> list = manager.list();
					for (Member member : list) {
						System.out.println(member.toString());
					}

				} else if (put == 5) { // 5.종료
					System.out.println("종료합니다.");
					manager.save1();
					run = false;

				} else {
					System.out.println("잘못된 입력.");
				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("잘못된 입력.");
			}
		}
		System.out.println("end of prog.");
		scn.close();

	}

}
