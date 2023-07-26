package co.yedam.boardpkg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.Spliterators;

interface Menu {
	int ADD = 1, EDIT = 2, DEL = 3, LIST = 4, INFO = 5, EXIT = 6;
}

public class MainExe {
	public static void menuPrint() {
		System.out.println("1.등록 2.수정 3.삭제 4.목록 5.개인정보 6.종료");
		System.out.print("선택>> ");
	}

	public static void main(String[] args) {
		
		BoardService svc = new BoardApp(); // BoardDAO
		
		LocalDate now = LocalDate.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		String id = "";

		while (run) {
			System.out.println("ID >>");
			id = scn.nextLine();
			System.out.println("password >>");
			String pw = scn.nextLine();

			if (svc.login(id, pw)) {
				System.out.println("로그인 성공.");
				break;
			} else {
				System.out.println("로그인 실패.");
			}
		}

		while (run) {

			try {
				menuPrint();
				int menu = Integer.parseInt(scn.nextLine());

				switch (menu) {
				case Menu.ADD:
					System.out.println("등록>> [번호], [제목], [내용], [날짜]");
					String str = scn.nextLine();
					String[] list = str.split(", ");
					if (list[3] == null) {
						list[3] = formatedNow;
					}
					Board board = new Board(Integer.parseInt(list[0]), list[1], list[2], id, list[3]);

					if(svc.addBoard(board)) {
						System.out.println("등록완료.");
					}
					break;

				case Menu.EDIT:
					System.out.println("수정>>[번호], [제목], [내용], [날짜]");
					str = scn.nextLine();
					list = str.split(", ");
					
					for (int i = 0; i < svc.boardList().size(); i++) {
						if (svc.boardList().get(i).getBrdNo() == Integer.parseInt(list[0])) { // 게시글이 있으면
							if (svc.boardList().get(i).getWriter().equals(id)) { // 작성자랑 아이디가 같으면
								board = new Board(Integer.parseInt(list[0]), list[1], list[2], id, list[3]);
								
								if(svc.editBoard(board)) {
									System.out.println("수정성공.");
									break;
								}
							}
						}
						
					}
					System.out.println("수정실패.");
					break;

				case Menu.DEL:
					System.out.println("삭제할 글번호 >>");
					int no = Integer.parseInt(scn.nextLine());
					
					for (int i = 0; i < svc.boardList().size(); i++) {
						if (svc.boardList().get(i).getBrdNo() == no) { // 게시글이 있으면
							if (svc.boardList().get(i).getWriter().equals(id)) { // 작성자랑 아이디가 같으면
								svc.delBoard(no);
								System.out.println("삭제성공.");
								break;
							}
						}
					}
					System.out.println("삭제실패.");
					break;
					

				case Menu.LIST:
					for (Board brd : svc.boardList()) {
						System.out.println(brd.toString());
					}
					break;

				case Menu.INFO:
					System.out.println("수정>> [ID], [name], [password]");
					str = scn.nextLine();
					list = str.split(", ");
					User user = new User(list[0], list[1], list[2]);
					svc.modInfo(user);
					break;

				case Menu.EXIT:
					System.out.println("종료합니다.");
					svc.exit();
					run = false;
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력.");
			}
		}
		System.out.println("end of prog.");
		scn.close();
	}
}
