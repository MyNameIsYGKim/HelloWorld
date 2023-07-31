package co.yedam.warehousing.history.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.warehousing.common.DataSource;
import co.yedam.warehousing.history.service.HistoryService;
import co.yedam.warehousing.history.service.HistoryVO;

public class HistoryServiceImpl implements HistoryService {
	private DataSource dao = DataSource.getInstance();
	// DataSource = 데이터 저장.
	private Connection connection;
	// Application - Connection(연결) - DataSource
	private PreparedStatement preparedStatement;
	// PreparedStatement = SQL 실행하는 역할.
	private ResultSet resultSet;
	// ResultSet = ResultSet 타입으로 결과값을 변환하여 저장하기 위해.

	@Override
	public int historyInsert(HistoryVO vo) { // 구매, 판매, 폐기
		int n = 0;
		String sql = "INSERT INTO HISTORY VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getHistoryNo());
			preparedStatement.setString(2, vo.getHistoryType());
			preparedStatement.setInt(3, vo.getProductNo());
			preparedStatement.setString(4, vo.getProductName());
			preparedStatement.setInt(5, vo.getProductPrice());
			preparedStatement.setInt(6, vo.getHistorySellPrice());
			preparedStatement.setInt(7, vo.getHistoryAmount());
			preparedStatement.setInt(8, vo.getHistoryCost());
			preparedStatement.setDate(9, vo.getHistoryDate());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

//	@Override
//	public int historySellInsert(HistoryVO vo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int historyDissuseInsert(HistoryVO vo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public List<HistoryVO> historySelectList() {
		String sql = "SELECT * FROM HISTORY";
		List<HistoryVO> historys = new ArrayList<>();
		HistoryVO vo;
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vo = new HistoryVO();
				vo.setHistoryNo(resultSet.getInt("history_no"));
				vo.setHistoryType(resultSet.getString("history_type"));
				vo.setProductNo(resultSet.getInt("produnt_no"));
				vo.setProductName(resultSet.getString("product_name"));
				vo.setProductPrice(resultSet.getInt("product_price"));
				vo.setHistorySellPrice(resultSet.getInt("history_sell_price"));
				vo.setHistoryAmount(resultSet.getInt("history_amount"));
				vo.setHistoryCost(resultSet.getInt("history_cost"));
				vo.setHistoryDate(resultSet.getDate("history_date"));
				historys.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return historys;
	}

	@Override
	public List<HistoryVO> historySelect(String str) {
		String sql = "SELECT * FROM HISTORY WHERE HISTORY_NO = ?";
		List<HistoryVO> historys = new ArrayList<>();
		HistoryVO vo;
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, str);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				vo = new HistoryVO();
				vo.setHistoryNo(resultSet.getInt("history_no"));
				vo.setHistoryType(resultSet.getString("history_type"));
				vo.setProductNo(resultSet.getInt("produnt_no"));
				vo.setProductName(resultSet.getString("product_name"));
				vo.setProductPrice(resultSet.getInt("product_price"));
				vo.setHistorySellPrice(resultSet.getInt("history_sell_price"));
				vo.setHistoryAmount(resultSet.getInt("history_amount"));
				vo.setHistoryCost(resultSet.getInt("history_cost"));
				vo.setHistoryDate(resultSet.getDate("history_date"));
				historys.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return historys;
	}

	@Override
	public int historyDelete(int no) {
		int n = 0;
		String sql = "DELETE FROM HISTORY WHERE HISTORY_NO = ?";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, no);
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	private void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
