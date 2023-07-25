package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.product.Product;

public class BoardManager {

	Scanner scn = new Scanner(System.in);
	List<User> uList = new ArrayList<>();
	List<Board> bList = new ArrayList<>();
	String userId = "";

	// 로그인메뉴
	public void LogInMenu() {
		System.out.println("1.회원가입 2.로그인");
	}

	// 회원가입
	public void join() {
		System.out.println("ID >>");
		String id = scn.nextLine();
		System.out.println("Name >>");
		String name = scn.nextLine();
		System.out.println("Password >>");
		String pw = scn.nextLine();

		User user = new User(id, name, pw);
		uList.add(user);
		System.out.println("가입성공!");
	}

	// 로그인
	public boolean logIn() {
		System.out.println("ID >>");
		String id = scn.nextLine();
		System.out.println("Password >>");
		String pw = scn.nextLine();

		for (int i = 0; i < uList.size(); i++) {
			if (uList.get(i).id.equals(id) && uList.get(i).pw.equals(pw)) {
				userId = id;
				System.out.println("로그인 성공.");
				return true;
			}
		}
		return false;
	}

	// 메뉴출력
	public void Menu() {
		System.out.println("1.글등록 2.글수정 3.글삭제 4.게시글목록 5.종료 9.개인정보");
	}

	// 글번호 설정.
	public int boardNo() {
		int no = 0;
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getNo() > no) {
				no = bList.get(i).getNo();
			}
		}
		return no + 1;
	}

	public void inputPost() { // 1.글등록
		int no = boardNo();
		System.out.println("제목 >>");
		String title = scn.nextLine();
		System.out.println("내용 >>");
		String content = scn.nextLine();
		System.out.println("날짜 >>");
		String date = scn.nextLine();

		Board board = new Board(no, title, content, userId, date);
		if (bList.add(board)) {
			System.out.println("등록성공.");
		} else {
			System.out.println("등록실패.");
		}
	}

	public boolean editPost() { // 2.글수정
		System.out.println("수정할 글번호 >>");
		int Num = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getNo() == Num) { // 게시글 유무 확인
				if (bList.get(i).getId() == userId) { // 아이디 권한
					System.out.println("수정할 내용 >>");
					String content = scn.nextLine();
					bList.get(i).setContent(content);
					System.out.println("수정완료.");
					return true;
				} else {
					System.out.println("권한이 없습니다.");
				}
			} else {
				System.out.println("해당 게시글이 없습니다.");
			}
		}
		return false;
	}

	public boolean delPost() { // 3.글삭제
		System.out.println("삭제할 글번호 >>");
		int Num = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getNo() == Num) { // 게시글 유무 확인
				if (bList.get(i).getId() == userId) { // 아이디 권한
					bList.remove(i);
					System.out.println("삭제완료.");
					return true;
				} else {
					System.out.println("권한이 없습니다.");
				}
			} else {
				System.out.println("해당 게시글이 없습니다.");
			}
		}
		return false;
	}

	public void postList() { // 4.목록
		if (bList != null) {
			System.out.println("조회완료.");
			for (int i = 0; i < bList.size(); i++) {
				System.out.println(bList.get(i).toString());
			}
		} else {
			System.out.println("빈 목록.");
		}
	}
	
	public void editPw() { // 9.개인정보-비밀번호변경
		System.out.println("바꿀 비밀번호 >>");
		String pw = scn.nextLine();
		for (int i = 0; i < uList.size(); i++) {
			if (uList.get(i).getId().equals(userId)) {
				uList.get(i).setPw(pw);
				System.out.println("변경완료.");
			}
		}
	}

	// 파일 모두 불러오기
	public void readFromFile() {
		u_readFromFile();
		b_readFromFile();
	}
	
	// 파일 불러오기
	public void u_readFromFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/userList.text");
			ObjectInputStream ois = new ObjectInputStream(fis);
			uList = (List<User>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
//				e.printStackTrace();
		}
	}

	// 파일 불러오기
	public void b_readFromFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/boardList.text");
			ObjectInputStream ois = new ObjectInputStream(fis);
			bList = (List<Board>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	// 파일 모두 저장하기
	public void storeToFile() throws Exception {
		u_storeToFile();
		b_storeToFile();
	}
	
	// 파일에 저장하기
	public void u_storeToFile() throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/Temp/userList.text");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(uList);
		oos.flush();
		oos.close();
		fos.flush();
		fos.close();
	}

	// 파일에 저장하기
	public void b_storeToFile() throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/Temp/boardList.text");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(bList);
		oos.flush();
		oos.close();
		fos.flush();
		fos.close();
	}
}
