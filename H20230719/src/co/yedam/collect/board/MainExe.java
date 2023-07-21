package co.yedam.collect.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		Board board = new Board();
		BoardApp boardApp = new BoardApp();
		UserApp userApp = new UserApp();
		String logId = "", logPw = "";
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		// 로그인 처리 => 기능 사용.
		
		// 1.등록 2.목록 3.단건조회 4.삭제 9.종료
		while(run) {
			System.out.println("로그인할 아이디>> ");
			logId = scn.nextLine();
			System.out.println("로그인할 비밀번호>> ");
			logPw = scn.nextLine();
			
			if(userApp.login(logId, logPw)) { // 로그인
				System.out.println("로그인 완료.");
				run = false;
			}else {
				System.out.println("로그인 실패.");
				continue;
			}
		}
		
		run = true;
		while(run) {
			try {
				System.out.println("입력>> [1]등록 [2]목록 [3]단건조회 [4]삭제 [9]종료");
				int put = Integer.parseInt(scn.nextLine());
				
				if(put == 1) { // 1.등록 ----------------------------------------------
					System.out.println("번호>> ");
					int postNo = Integer.parseInt(scn.nextLine());
					System.out.println("제목>> ");
					String postTitle = scn.nextLine();
					System.out.println("내용>> ");
					String postContent = scn.nextLine();
					
					Board b1 = new Board(postNo, postTitle, postContent, logId);
					if(boardApp.addBoard(b1)) {
						System.out.println("등록성공.");
					}else {
						System.out.println("등록실패.");
					}
					
				}else if(put == 2) { // 2.목록 ----------------------------------------------
					for(int i=0; i<boardApp.boards.size(); i++) {
						Board thatBoard = boardApp.boards.get(i);
						if(thatBoard != null) {
							System.out.println(thatBoard.toString());
						}
					}
					
				}else if(put == 3) { // 3.단건조회 ----------------------------------------------
					System.out.println("조회할 글번호>> ");
					int postNum = Integer.parseInt(scn.nextLine());
					
					for(int i=0; i<boardApp.boards.size(); i++) {
						Board thatBoard = boardApp.boards.get(i);
						if(thatBoard.getBoardNo() == postNum) { // 해당 글번호가 있으면
//							if(thatBoard.getWriter().equals(logId)) { // 글쓴이가 얘 아이디랑 같으면
								System.out.println("조회완료.");
								System.out.println(thatBoard.toString());
								break;
//							}
//							System.out.println("다른 유저의 게시글은 접근이 불가합니다.");
//							break;
						}else {
						System.out.println("해당 게시글이 없습니다.");
						break;
						}
					}
					
				}else if(put == 4) { // 4.삭제 ----------------------------------------------
					System.out.println("삭제할 글번호>> ");
					int postNum = Integer.parseInt(scn.nextLine());
					
					for(int i=0; i<boardApp.boards.size(); i++) {
						Board thatBoard = boardApp.boards.get(i);
						if(thatBoard.getBoardNo() == postNum) { // 해당 글번호가 있으면
							if(thatBoard.getWriter().equals(logId)) { // 글쓴이가 얘 아이디랑 같으면
								System.out.println("삭제완료.");
								thatBoard = null;
								break;
							}
							System.out.println("다른 유저의 게시글은 접근이 불가합니다.");
							break;
						}else {
						System.out.println("해당 게시글이 없습니다.");
						break;
						}
					}
					
				}else if(put == 9) { // 9.종료 ----------------------------------------------
					System.out.println("종료합니다.");
					run = false;
					
				}else {
					System.out.println("잘못된 입력.");
				}
			} catch(NumberFormatException e) {
				System.out.println("잘못된 입력.");
			}
		}
		
	}

}
