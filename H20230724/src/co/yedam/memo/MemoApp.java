package co.yedam.memo;

import java.util.List;
import java.util.Scanner;

public class MemoApp {

	public static void main(String[] args) throws Exception {
		MemoManager manager = new MemoManager();

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = -1;

		try {
			while (run) {
				manager.printMenu();
				menu = Integer.parseInt(scn.nextLine());

				if (menu == 1) { // 1.등록
					manager.inputData();
					continue;

				} else if (menu == 2) { // 2.검색
					manager.search();
					continue;

				} else if (menu == 3) { // 3.삭제
					manager.deleteData();
					continue;
					
				} else if (menu == 4) { // 4.종료
					System.out.println("종료합니다.");
					run = false;
					manager.storeToFile(); // 파일로 데이터 저장.

				} else {
					System.out.println("잘못된 입력.");
				}
				scn.close();
			}
			System.out.println("end of prog.");
		} catch (Exception e) {

		}
	}

}
