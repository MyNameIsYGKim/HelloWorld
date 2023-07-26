package co.yedam.boardpkg;

import java.util.List;

public interface BoardService {
	// 로그인 기능.
	boolean login(String id, String pw);
	// 글등록.
	boolean addBoard(Board board);
	// 글수정.
	boolean editBoard(Board board);
	// 글삭제.
	boolean delBoard(int brdNo);
	// 글목록.
	List<Board> boardList();
	// 개인정보수정.
	boolean modInfo(User user);
	// 프로그램 종료.
	void exit();
}
