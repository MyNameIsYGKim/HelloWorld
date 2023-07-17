package co.yedam.member;

public class MemberExe {
	public static void main(String[] args) {
		
		java.util.Scanner scn = new java.util.Scanner(System.in);
		boolean run = true;
		Member[] members = new Member[10];
		
		Member m1 = new Member();
		m1.setMemberNo(1001);
		m1.setMemberName("홍길동");
		m1.setPhone("010-1111");
		m1.setGender(Gender.MEN);
		m1.setAddress("대구 100");
		Member m2 = new Member();
		m2.setMemberNo(1002);
		m2.setMemberName("김길동");
		m2.setPhone("010-2222");
		m2.setGender(Gender.MEN);
		m2.setAddress("부산 100");
		Member m3 = new Member();
		m3.setMemberNo(1003);
		m3.setMemberName("김길순");
		m3.setPhone("010-3333");
		m3.setGender(Gender.WOMEN);
		m3.setAddress("대구 200");
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
		
		Member m4 = new Member();
		members[3] = m4;
		Member m5 = new Member(3001, "오길동", "010-1234", Gender.WOMEN, "대구 500");
		members[4] = m5;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.상세조회 6.남자회원목록 7.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine()); // 정수를 반환
			
			if(menu == 1) { // 1번--------------------------------1번
				System.out.println("등록기능.");
				System.out.print("회원번호입력>> ");
				int mNo = Integer.parseInt(scn.nextLine());
				System.out.print("회원이름입력>> ");
				String mName = scn.nextLine();
				System.out.print("회원연락처입력>> ");
				String phone = scn.nextLine();
				
				System.out.print("회원성별입력>> ");
				// 남, 남자 startsWith("
				Gender gender = null;
				String temp = scn.nextLine();
				if(temp.startsWith("남")) {
					gender = Gender.MEN;
				} else if(temp.startsWith("여")) {
					gender = Gender.WOMEN;
				}
				
				System.out.print("회원주소입력>> ");
				String addr = scn.nextLine();
				
				Member member = new Member(); // 인스턴스.
				member.setMemberNo(mNo);
				member.setMemberName(mName);
				member.setPhone(phone);
				member.setGender(gender);
				member.setAddress(addr);
				
				// members 멤버 인스턴스 10개 저장.
				for(int i = 0; i < members.length; i++) {
					if(members[i] == null) {
						members[i] = member; // 배열의 빈값에 저장.
						break; // 한건저장 후 반복문 종료.
					}
				}
				
			}else if(menu == 2) { // 2번----------------------------------2번
				System.out.println("목록기능.");
				for(int i = 0; i < members.length; i++) {
					if(members[i] != null) {
						System.out.println(members[i].showInfo());
					}
				}
				
			}else if(menu == 3) { // 3번----------------------------------3번
				System.out.println("해당 회원번호 입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean end = false;
				
				for(int i=0; i<members.length; i++) {
					if(members[i] != null && members[i].getMemberNo() == no) {
						System.out.println("수정할 회원번호>> ");
						int no1 = Integer.parseInt(scn.nextLine());
						members[i].setMemberNo(no1);
						System.out.println("수정할 연락처>> ");
						String phone = scn.nextLine();
						members[i].setPhone(phone);
						System.out.println("변경된 회원번호: "+members[i].getMemberNo()+
								"연락처: "+members[i].getPhone());
						end = true;
					}
				}
				if(end == false) {
					System.out.println("잘못된 회원번호입니다.");
				}
				
			}else if(menu == 4) { // 4번----------------------------------4번
				System.out.println("삭제기능.");
				System.out.println("삭제할 회원번호 입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean end = false;
				
				for(int i=0; i<members.length; i++) {
					if(members[i] != null && members[i].getMemberNo() == no) {
						members[i] = null;
						System.out.println("해당 회원이 삭제되었습니다.");
						end = true;
					}
				}
				if(end == false) {
					System.out.println("없는 회원번호입니다.");
				}
				
			}else if(menu == 5) { // 5번----------------------------------5번
				System.out.println("상세조회기능.");
				System.out.print("회원번호입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean end = false;
				
				for(int i=0; i<members.length; i++) {
					// 배열의 값중에서 null 여부 체크.
					if(members[i] != null && members[i].getMemberNo() == no) {
						System.out.println(members[i].detailInfo());
						end = true;
					}
				}
				if(end == false) {
					System.out.println("없는 회원번호입니다.");
				}
				
			}else if(menu == 6) {
				for(int i=0; i<members.length; i++) {
					// 배열의 값중에서 null 여부 체크.
					if(members[i] != null && members[i].getGender() == Gender.MEN) {
						System.out.println(members[i].showInfo());
					}
				}
				
			}else if(menu == 7) {
				run = false;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		System.out.println("end of prog.");
		
	} // end of main.
}
