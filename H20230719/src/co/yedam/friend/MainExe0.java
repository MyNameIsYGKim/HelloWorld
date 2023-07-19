package co.yedam.friend;

import java.util.Scanner;

public class MainExe0 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// 1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료
		// 등록> 1.학교, 2.회사, 3.친구
		boolean run = true;
		AddressApp0 app = new AddressApp0();
		
		String name = "", phone = "";
		Friend friend = null;

		while (run) {
			promptMenu();
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				subMenu();
				int subMenu = Integer.parseInt(scn.nextLine());
				// 공통정보.
				name = promptString("친구이름");
				phone = promptString("연락처");

				if (subMenu == 1) {
					// 학교친구정보를 입력.
					String univ = promptString("학교정보");
					String major = promptString("전공정보");
					friend = new UnivFriend(name, phone, univ, major);

				} else if (subMenu == 2) {
					// 회사친구정보를 입력.
					String comp = promptString("회사정보");
					String dept = promptString("부서정보");
					friend = new CompFriend(name, phone, comp, dept);

				} else if (subMenu == 3) {
					friend = new Friend(name, phone);
				}

				if (app.addFriend(friend)) {
					System.out.println("정상처리됨.");
				} else {
					System.out.println("처리오류.");
				}
				break;

			case 2:
				Friend[] ary = app.friendList();
				for (Friend fnd : ary) {
					if (fnd != null)
						System.out.println(fnd.showInfo());
				}
				break;

			case 3:
				name = promptString("친구이름");
				phone = promptString("연락처");
				if (app.editFriend(name, phone)) {
					System.out.println("정상처리됨.");
				} else {
					System.out.println("처리오류.");
				}
				break;

			case 4:
				name = promptString("친구이름");
				if (app.delFriend(name)) {
					System.out.println("정상처리됨.");
				} else {
					System.out.println("처리오류.");
				}
				break;

			case 5:
				name = promptString("친구이름");
				friend = app.findFriend(name);
				if (friend != null) {
					System.out.println(friend.showInfo());
				} else {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;

			case 6:
				run = false;
				System.out.println("종료합니다.");

			}
		}

	} // end of main.

	static void subMenu() {
		System.out.println("1.학교친구 2.회사친구 3.친구");
		System.out.print("선택>> ");
	}

	static void promptMenu() {
		System.out.println("1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료");
		System.out.print("선택>> ");
	}

	static String promptString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

}
