package co.yedam.board;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		BoardManager manager = new BoardManager();
		boolean run = true;

//		manager.readFromFile(); // 파일 불러오기.
		
		manager.u_readFromFile();
		manager.b_readFromFile();
		
		while (run) { // while 1
//			try {
				manager.LogInMenu();
				int logInMenu = Integer.parseInt(scn.nextLine());
				if (logInMenu == 1) {
					manager.join();
					continue;
				} else if (logInMenu == 2) {
					if (manager.logIn()) { // 로그인 성공하면
						break;
					} else {
						System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
						continue;
					}
				} else {
					System.out.println("잘못된 입력.");
					continue;
				}
//			} catch (Exception e) {
//				System.out.println("오류발생. 처음부터..");
//			}
		} // end of while 1

		while (run) { // 로그인 성공하면. while 2
			try {
				manager.Menu();
				int Menu = Integer.parseInt(scn.nextLine());

				if (Menu == MENU.INPUT) { // 1.등록
					manager.inputPost();
					continue;

				} else if (Menu == MENU.EDIT) { // 2.수정
					manager.editPost();
					continue;

				} else if (Menu == MENU.DEL) { // 3.삭제
					manager.delPost();
					continue;

				} else if (Menu == MENU.LIST) { // 4.목록
					manager.postList();
					continue;

				} else if (Menu == MENU.EXIT) { // 5.종료
					System.out.println("종료합니다.");
					try {
						manager.storeToFile();
					} catch (Exception e) {

					}
					run = false;

				} else if (Menu == MENU.EDIT_USER) { // 9.개인정보
					System.out.println("1.아이디 변경 2. 이름 변경 3.비밀번호 변경");
					Menu = Integer.parseInt(scn.nextLine());
					if (Menu == 1) {
						System.out.println("아이디는 변경할 수 없습니다.");
					} else if (Menu == 2) {
						System.out.println("이름은 변경할 수 없습니다.");
					} else if (Menu == 3) {
						manager.editPw();
						System.out.println("변경 완료.");
					} else {
						System.out.println("잘못된 입력.");
					}
				} else {
					System.out.println("잘못된 입력.");
				}
			} catch (Exception e) {
				System.out.println("오류발생. 처음부터..");
			}
		} // end of while 2

	} // end of main.

}
