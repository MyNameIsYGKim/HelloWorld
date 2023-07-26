package co.yedam.boardpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO implements BoardService {

	Connection conn = null; // DB 연결 세션.
	PreparedStatement psmt;
	ResultSet rs;

	void getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle드라이버가 없습니다.");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "1234";
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconn() {
		try {
			if (conn != null)
				conn.close();
			if (psmt != null)
				psmt.close();
			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String id, String pw) {
		return false;
	}

	@Override
	public boolean addBoard(Board board) { // 입력
		String sql = "insert into boards (board_no, title, content, writer, write_date)";
		sql += " values(?, ?, ?, ?, ?)";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBrdNo());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getContent());
			psmt.setString(4, board.getWriter());
			psmt.setString(5, board.getWriteDate());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public boolean editBoard(Board board) { // 수정
		String sql = "updqte boards set board_no=?, title=?, content=?, writer=?, write_date=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBrdNo());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getContent());
			psmt.setString(4, board.getWriter());
			psmt.setString(5, board.getWriteDate());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public boolean delBoard(int brdNo) { // 삭제
		String sql = "delete boards where board_no=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brdNo);
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public List<Board> boardList() { // 목록
		String sql = "select * from boards order by board_no";
		getConn();
		List<Board> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public boolean modInfo(User user) {
		String sql = "update users set user_id=?, user_name=?, user_pw=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserName());
			psmt.setString(3, user.getUserPw());
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public void exit() {
		String sql = "commit;";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
	
	

}








