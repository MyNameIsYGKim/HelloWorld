package co.yedam.collect.board;

import java.util.ArrayList;
import java.util.List;

public class BoardApp0 {
	// 게시글저장.
	List<Board> boards = new ArrayList<>();

	BoardApp0() {
		boards.add(new Board(11, "제목샘플1", "내용샘플1", "user2"));
		boards.add(new Board(12, "제목샘플2", "내용샘플2", "user2"));
		boards.add(new Board(13, "제목샘플3", "내용샘플3", "admin"));
		boards.add(new Board(14, "제목샘플4", "내용샘플4", "admin"));
		boards.add(new Board(15, "제목샘플5", "내용샘플5", "user1"));
		boards.add(new Board(16, "제목샘플6", "내용샘플6", "user1"));
	}

	// 등록기능.
	boolean addBoard(Board board) {
		return boards.add(board);
	}

	// 목록.
	List<Board> boardList() {
		return boards;
	}

	// 단건조회.
	Board getBoard(int boardNo) {
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getBoardNo() == boardNo) {
				return boards.get(i);
			}
		}
		return null;
	}

	// 삭제.
	boolean delBoard(int boardNo) {
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getBoardNo() == boardNo) {
				boards.remove(i);
				return true;
			}
		}
		return false;
	}
}
