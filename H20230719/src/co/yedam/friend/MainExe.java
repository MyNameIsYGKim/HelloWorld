package co.yedam.friend;

import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		
		// 1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료
		AddressApp app = new AddressApp();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Friend friend = null;
		
		// String name = "", phone = "";
		
		// 1.등록
		while(true) {
			System.out.println("입력>> 1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료");
			int put = Integer.parseInt(scn.nextLine());
			
			if(put == 1) { // 등록 ---------------------------------------------
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
			}else if(put == 2) { // 2.목록--------------------------
				for(int i=0; i < app.friends.length; i++) {
					if(app.friends[i] != null) {
						System.out.printf("이름");
					}
				}
			}
		
		}
		
		// 2.목록
		
		
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
