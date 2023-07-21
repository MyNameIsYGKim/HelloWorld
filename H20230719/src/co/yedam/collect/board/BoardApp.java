package co.yedam.collect.board;

import java.util.ArrayList;
import java.util.List;

public class BoardApp {
	// 게시글저장.
	List<Board> boards = new ArrayList<>();
	Board board = new Board();
	
	boolean addBoard(Board board) { // 등록
		if(boards.add(board)) {
			return true;
		}
		return false;
	}
	
	List<Board> boardList(){ // 목록
		return boards;
	}
	
	Board getBoard(int boardNo) { // 단건조회
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getBoardNo() == boardNo) {
				return board;
			}
		}
		return null;
	}
	
	boolean delBoard(int boardNo) { // 삭제
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getBoardNo() == boardNo) {
				boards.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
