package co.micol.noticeprj.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.noticeprj.board.service.BoardService;
import co.micol.noticeprj.board.service.BoardVO;
import co.micol.noticeprj.common.DataSource;

public class BoardServiceImpl implements BoardService {
	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	@Override
	public List<BoardVO> boardSelectList() {
		String sql = "SELECT * FROM BOARD";
		List<BoardVO> boards = new ArrayList<BoardVO>();
		BoardVO vo ;
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				vo = new BoardVO();
				vo.setBoardId(resultSet.getInt("board_id"));
				vo.setBoardWriter(resultSet.getString("board_writer"));
				vo.setBoardTitle(resultSet.getString("board_title"));
				vo.setBoardDate(resultSet.getDate("board_date"));
				vo.setBoardHit(resultSet.getInt("board_hit"));
				boards.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return boards;
	}

	private void close() {
		try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUdpdate(BoardVO vo) {  //내용만 변경할 수 있다
		String sql = "UPDATE BOARD SET BOARD_SUBJECT = ? WHERE BOARD_ID = ?";
		int n = 0;
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getBoardSubject());
			preparedStatement.setInt(2, vo.getBoardId());
			n = preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

}
