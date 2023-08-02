package co.micol.miniproject.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.miniproject.member.service.MemberService;
import co.micol.miniproject.member.service.MemberVO;
import co.micol.miniproject.member.serviceImpl.MemberServiceImpl;
import co.micol.noticeprj.board.service.BoardService;
import co.micol.noticeprj.board.service.BoardVO;
import co.micol.noticeprj.board.serviceImpl.BoardServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService ms = new MemberServiceImpl();  //DB
	
	private void memberTitle() {  
		System.out.println("==== 회원관리 ====");
		System.out.println("= 1.전체회원 조회 =");
		System.out.println("= 2.한명회원 조회 =");
		System.out.println("= 3.회원정보 등록 =");
		System.out.println("= 4.회원정보 수정 =");
		System.out.println("= 5.회원정보 삭제 =");
		System.out.println("= 6.메인으로 가기 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요? ");
	}
	
	private void boardTitle() {
		System.out.println("==== 공지관리 ====");
		System.out.println("= 1.공지사항 조회 =");
		System.out.println("= 2.공지사항 세부 =");
		System.out.println("= 3.공지사항 등록 =");
		System.out.println("= 4.공지사항 수정 =");
		System.out.println("= 5.공지사항 삭제 =");
		System.out.println("= 6.메인으로 가기 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요? ");	
	}
	
	private void mainTitle() {
		System.out.println("==== 학사관리 ====");
		System.out.println("= 1. 회원 관리   =");
		System.out.println("= 2.공지사항 관리 =");
		System.out.println("= 3.학사관리 종료 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요? ");	
	}
	
	private void memberSelectList() {
		List<MemberVO> members = ms.memberSelectList();
		if(!members.isEmpty()) {
			for(MemberVO member : members) {
				member.toString();
			}
		} else {
			System.out.println("회원이 한명도 존재하지 않습니다.");
		}
	}
	//여기서 CRUD 메소드를 private으로 하나씩 만들어 간다.
	private void memberSelect() {
		MemberVO member = new MemberVO();
		System.out.println("===검색할 회원의 아이디를 입력하세요?.===");
		sc.nextLine();
		String id = sc.nextLine();
		member.setMemberId(id);
		member = ms.memberSelect(member);
		if(member.getMemberName() != null) {
			member.toString();
		}else {
			System.out.println("존재하지 않는 회원 입니다. ㅠㅠ");
		}
	}
	
	public void run() {
		boolean b = false;
		do {
			mainTitle();
			int key = sc.nextInt();
			switch(key) {
				case 1 : 
					memberManagement();
					break;
				case 2 :
					boardManagement();
					break;
				case 3 : 
					System.out.println("학사관리를 종료합니다.!!!");
					b = true;
					break;
			}
		}while(!b);
		sc.close();
	}

	private void boardManagement() {
		boolean b = false;
		do {
			boardTitle();
			sc.nextLine();
			int key = sc.nextInt();
			switch(key) {
				case 1 : 
					boardList();
					break;
				case 2 :					
					break;
				case 3 :
					break;
				case 4 :
					break;
				case 5 :
					break;
				case 6 : 
					b = true;
					break;
			}
		}while(!b);		
	}

	private void memberManagement() {
		boolean b = false;
		do {
			memberTitle();
			sc.nextLine();
			int key = sc.nextInt();
			switch(key) {
				case 1 : 
					memberSelectList();
					break;
				case 2 :
					memberSelect();
					break;
				case 3 :
					break;
				case 4 :
					break;
				case 5 :
					break;
				case 6 : 
					b = true;
					break;
			}
		}while(!b);	
	}

	private void boardList() {
		BoardService bs = new BoardServiceImpl();
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = bs.boardSelectList();
		
		for(BoardVO board : boards) {
			board.toString();
		}		
	}

}
