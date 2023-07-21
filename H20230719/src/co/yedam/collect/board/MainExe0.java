package co.yedam.collect.board;

import java.util.List;
import java.util.Scanner;

public class MainExe0 {
	public static void main(String[] args) {
		UserApp0 userApp = new UserApp0();
		BoardApp0 boardApp = new BoardApp0();
		Scanner scn = new Scanner(System.in);

		String logId = "", logPw = "";
		boolean logStatus = false;
		boolean run = true;
		int boardSeq = 1, boardNo = 0;
		Board board = null;

		while (run) {
			if (!logStatus) {
				// 로그인 처리 => 기능 사용.
				System.out.print("ID입력>> ");
				logId = scn.nextLine();
				System.out.print("비번입력>> ");
				logPw = scn.nextLine();

				if (userApp.login(logId, logPw)) {
					System.out.println("로그인 성공...");
					logStatus = true;
				} else {
					System.out.println("로그인 실패...");
					continue;
				}
			}

			// 1.등록 2.목록 3.단건조회 4.삭제 9.종료
			System.out.println("1.등록 2.목록 3.단건조회 4.삭제 9.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("제목>> ");
				String title = scn.nextLine();
				System.out.print("내용>> ");
				String content = scn.nextLine();

				board = new Board(boardSeq++, title, content, logId);
				if (boardApp.addBoard(board)) {
					System.out.println("등록성공.");
				}
				break;

			case 2:
				List<Board> list = boardApp.boardList();
				for (Board brd : list) {
					System.out.println(brd.toString());
				}
				break;

			case 3:
				System.out.print("조회할 글번호>> ");
				boardNo = Integer.parseInt(scn.nextLine());
				board = boardApp.getBoard(boardNo);
				if (board == null) {
					System.out.println("조회한 내용이 없습니다.");
					continue;
				}
				System.out.println(board.toString());
				break;

			case 4:
				System.out.print("삭제할 글번호>> ");
				boardNo = Integer.parseInt(scn.nextLine());
				// 삭제전 작성자 확인.
				board = boardApp.getBoard(boardNo);
				if (!board.getWriter().equals(logId)) {
					System.out.println("삭제권한이 없습니다.");
					continue;
				}
				if (boardApp.delBoard(boardNo)) {
					System.out.println("삭제성공!");
				} else {
					System.out.println("삭제실패!");
				}
				break;

			case 9:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;

			default:
				System.out.println("없는 메뉴입니다.");
			}
		}
		System.out.println("end of prog.");
		scn.close();
	}
}
