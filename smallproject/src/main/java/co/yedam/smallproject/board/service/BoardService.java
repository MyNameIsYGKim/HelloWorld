package co.yedam.smallproject.board.service;

import java.util.List;

public interface BoardService {
	List<BoardVO> boardSelectList(); // R
	BoardVO boardSelect(BoardVO vo); // R
	int boardInsert(BoardVO vo); // C
	int boardDelete(BoardVO vo); // D
	int boardUpdate(BoardVO vo); // U
}
