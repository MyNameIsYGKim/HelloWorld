package co.yedam.friend;

import java.util.Scanner;

public class MainExe1 {
	public static void main(String[] args) {
		
		// 1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료
		AddressApp app = new AddressApp();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Friend friend = null;
		int put;
		
		// String name = "", phone = "";
		
		// 1.등록
		while(true) {
			System.out.println("입력>> 1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료");
			try {
				put = Integer.parseInt(scn.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
				//put = 2;
				continue;
			}
			
//			try {
//				put2 = Integer.parseInt(scn.nextLine());
//			} catch(NumberFormatException e) {
//				System.out.println("잘못 선택했습니다.");
//				continue;
//			}
			
			try {
				// 1 ~ 6 메뉴 이외의 메뉴 선택하면...
				if (put < 1 || put > 6) {
					throw new MenuException(put);
				}
			} catch(MenuException e) {
				e.showMessage();
				continue;
			}
			
			
			if(put == INIT_MENU.ADD) { // 등록 ---------------------------------------------
				System.out.println("선택>> 회사원(1), 대학친구(2), 일반친구(3)");
				int put2 = Integer.parseInt(scn.nextLine());
				
				System.out.println("이름>> ");
				String name = scn.nextLine();
				System.out.println("전화번호>> ");
				String phone = scn.nextLine();
				
				if(put2 == 1) { // 회사친구 등록--------------------------------
					System.out.println("회사명>> ");
					String comp1 = scn.nextLine();
					System.out.println("부서>> ");
					String comp2 = scn.nextLine();
					
					Friend f1 = new CompFriend(name, phone, comp1, comp2);
					boolean result1 = app.addFriend(f1);
					if (result1 == true) {
						System.out.println("등록완료.");
					}else {
						System.out.println("등록실패.");
					}
				}else if(put2 == 2) { // 대학친구 등록----------------------------
					System.out.println("학교명>> ");
					String univ1 = scn.nextLine();
					System.out.println("전공>> ");
					String univ2 = scn.nextLine();
					
					Friend f2 = new UnivFriend(name, phone, univ1, univ2);
					boolean result2 = app.addFriend(f2);
					if (result2 == true) {
						System.out.println("등록완료.");
					}else {
						System.out.println("등록실패.");
					}
				}else if(put2 == 3) { // 일반친구 등록----------------------
					friend = new Friend(name, phone);
				}
			}else if(put == INIT_MENU.LIST) { // 2.목록----------------------------------
				Friend[] arr = app.friendList();
				for(Friend frn : arr) {
					if(frn != null) {
						System.out.printf(frn.showInfo());
					}
				}
			}else if(put == INIT_MENU.EDIT) { // 3.수정 -------------------------------------
				
			}else if(put == INIT_MENU.DEL) { // 4.삭제 -------------------------------------
				
			}else if(put == INIT_MENU.SEARCH) { // 5.상세조회 -------------------------------------
				
			}else if(put == INIT_MENU.EXIT) { // 6.종료 -------------------------------------
				
			}else { // 메뉴 딴거 입력했을 경우.
				System.out.println("잘못된 입력입니다.");
			}
			
		} // end of While.
		
		
	} // end of main.
	
//	// Friend <- CompFriend, UnivFriend.
//	Friend[] friends = new Friend[10];
//	
//	//CompFriend[] f2 = new CompFriend[10]; // 의미가 없음.
//	
//	// friends배열에 Friend 클래스의 인스턴스 대입.
//	friends[0] = new Friend("홍길동", "010-1111");
//	friends[1] = new CompFriend("김길동", "010-2222", "네이버", "개발부서");
//	friends[2] = new UnivFriend("박길동", "010-3333", "대구대학교", "정보통신");
//	
//	for(int i=0; i < 3; i++) {
//		System.out.println(friends[i].showInfo()); // 메소드 재정의에 의한 showInfo실행.
//	}
}
