package co.yedam.board;

import java.util.Scanner;

public class BoardExe {
	static Board[] boards = new Board[30];
	static Scanner scn = new Scanner(System.in);
	
	static Board board = new Board();
	private static void init() {
		Board b1 = new Board(1, "잭과 콩나무", "잭이 끝없이 자라는 콩나무를 심었어", "홍길동");
		boards[0] = b1;
		Board b2 = new Board(2, "노인과 바다", "어업을 하는 노인의 이야기", "이말숙");
		boards[1] = b2;
		Board b3 = new Board(3, "갈매기의 꿈", "꿈을 까먹어버린 갈매기의 이야기", "김구");
		boards[2] = b3;
		Board b4 = new Board(4, "안녕 자두야", "자두의 학교생활 이야기", "자두");
		boards[3] = b4;
		Board b5 = new Board(5, "라면 레시피", "뒷면을 참조하세요.", "농심");
		boards[4] = b5;
		Board b6 = new Board(6, "오늘의 저녁메뉴", "김밥 불고기 김치찌개", "엄마");
		boards[5] = b6;
	}
	
	private static void addBoard() {
		System.out.println("1.게시글 등록");
		System.out.println("글번호>>");
		int put = Integer.parseInt(scn.nextLine());
		boolean end = false;
		
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getPoNo() == put) {
				System.out.println("이미 있는 게시글 번호입니다.");
				end = true;
			}
		}
		if(end == false) {
			int pNo = put;
			
			System.out.println("글 제목>>");
			String pTitle = scn.nextLine();
			System.out.println("글 내용>>");
			String pContents = scn.nextLine();
			System.out.println("작성자>>");
			String pWriter = scn.nextLine();
			
			board.setPoNo(pNo);
			board.setPoTitle(pTitle);
			board.setPoContents(pContents);
			board.setWriter(pWriter);
		}
		
		// 인스턴스 저장.
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = board; // 배열의 빈값에 저장.
				break; // 한건저장 후 반복문 종료.
			}
		}
	}
	// 1번(등록)
	private static void list() {
		System.out.println("2.목록");
		boolean end = false;
		System.out.println("페이지수 입력(-1은 종료)>> ");
		int put = Integer.parseInt(scn.nextLine());
		
		if(put == -1) {
			System.out.println("종료.");
		}else {
			for(int i = put*5-5; i < put*5; i++) {
				if(boards[i] != null) {
					System.out.println(boards[i].showInfo());
				}
			} // end of for.
		}
		
	}
	// 2번(목록)
	private static void editBoard() {
		System.out.println("수정할 글번호>> ");
		int put = Integer.parseInt(scn.nextLine());
		boolean end = false;
		
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getPoNo() == put) {
				System.out.println("수정할 내용>> ");
				String cont = scn.nextLine();
				boards[i].setPoContents(cont);
				System.out.println("수정완료!!");
				end = true;
			}
		}
		if(end == false) {
			System.out.println("없는 글번호입니다.");
		}
	}
	// 3번(수정)
	private static void dellBoard() {
		System.out.println("삭제할 글번호>> ");
		int put = Integer.parseInt(scn.nextLine());
		boolean end = false;
		
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getPoNo() == put) {
				boards[i] = null;
				System.out.println("게시글 삭제 완료.");
				end = true;
			}
		}
		if(end == false) {
			System.out.println("없는 글번호입니다.");
		}
	}
	// 4번(삭제)
	private static void detail() {
		System.out.println("조회할 글번호>> ");
		int put = Integer.parseInt(scn.nextLine());
		boolean end = false;
		
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getPoNo() == put) {
				System.out.println(boards[i].detailInfo());
				end = true;
			}
		}
		if(end == false) {
			System.out.println("없는 글번호입니다.");
		}
	}
	// 5번(자세히보기)
	
	public static void main(String[] args) {
		init();
		boolean run = true;
		while(run) {
			System.out.println("1.글작성 2.목록 3.수정 4.삭제 5.상세보기 6.종료"
					+ "\n메뉴를 선택하세요>>");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) {
				addBoard();
			}else if(menu == 2) {
				list();
			}else if(menu == 3) {
				editBoard();
			}else if(menu == 4) {
				dellBoard();
			}else if(menu == 5) {
				detail();
			}else if(menu == 6) {
				System.out.println("6.종료");
				run = false;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		} // end of while.
		
	} // end of menu.

} // end of class.
