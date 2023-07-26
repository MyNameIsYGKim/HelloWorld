package co.yedam.board;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		BoardApp app = new BoardApp();

		Scanner scn = new Scanner(System.in);
		boolean run = true;

		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String nowString = now.format(formatter);

		app.readFromFile(); // 파일 불러오기.

		while (run) {
			try {
				System.out.println(app.menu());
				int menu = Integer.parseInt(scn.nextLine());

				if (menu == 1) { // 등록
					int no = app.getNextNo();
					System.out.println("등록>> 제목, 내용, 작성자");
					String[] str = scn.nextLine().split(", ");
					Board board = new Board(no, str[0], str[1], str[2], nowString);

					if (app.register(board)) {
						System.out.println("등록성공.");
					} else {
						System.out.println("등록실패.");
					}

				} else if (menu == 2) { // 수정
					System.out.println("수정>> 번호, 제목, 내용, 작성자");
					String[] str = scn.nextLine().split(", ");
					Board board = new Board(Integer.parseInt(str[0]), str[1], str[2], str[3], nowString);

					if (app.modify(board)) {
						System.out.println("수정성공.");
					} else {
						System.out.println("수정실패.");
					}

				} else if (menu == 3) { // 조회
					System.out.println("조회할 번호 >>");
					int no = Integer.parseInt(scn.nextLine());

					if (app.search(no) != null) {
						System.out.println(app.search(no));
					} else {
						System.out.println("조회할 게시글이 없습니다.");
					}

				} else if (menu == 4) { // 삭제
					System.out.println("삭제할 번호 >>");
					int no = Integer.parseInt(scn.nextLine());

					if (app.remove(no)) {
						System.out.println("삭제성공.");
					} else {
						System.out.println("삭제실패.");
					}

				} else if (menu == 5) { // 목록
					if (app.boards != null) {
						for (Board board : app.boards) {
							System.out.println(board.toString());
						}
					} else {
						System.out.println("빈 목록.");
					}

				} else if (menu == 9) { // 종료
					System.out.println("종료합니다.");
					try {
						app.toSaveFile();
					} catch (Exception e) {
						e.printStackTrace();
					}
					run = false;

				} else {
					System.out.println("잘못된 입력.");
				}
			} catch (Exception e) {
				System.out.println("오류발생!");
			}
		}

	} // end of main.

}
