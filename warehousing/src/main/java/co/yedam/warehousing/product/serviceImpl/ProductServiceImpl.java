package co.yedam.warehousing.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.accessibility.AccessibleRelationSet;

import co.yedam.warehousing.common.DataSource;
import co.yedam.warehousing.product.service.ProductService;
import co.yedam.warehousing.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	@Override
	public int productInsert(ProductVO vo) {
		int n = 0;
		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?)";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductNo());
			preparedStatement.setString(2, vo.getProductName());
			preparedStatement.setInt(3, vo.getProductPrice());
			preparedStatement.setString(4, vo.getProductLocation());
			preparedStatement.setInt(5, vo.getProductAmount());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int productUpdate(ProductVO vo) {
		int n = 0;
		String sql = "UPDATE PRODUCT SET PRODUCT_PRICE = ?, " + "PRODUCT_LOCATION = ? WHERE PRODUCT_NO = ?";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(3, vo.getProductNo());
			preparedStatement.setInt(1, vo.getProductPrice());
			preparedStatement.setString(2, vo.getProductLocation());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int productDelete(ProductVO vo) {
		int n = 0;
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_NO = ?";
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductNo());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	@Override
	public List<ProductVO> productSelectList() {
		String sql = "SELECT * FROM PRODUCT";
		List<ProductVO> products = new ArrayList<>();
		ProductVO vo;
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				vo = new ProductVO();
				vo.setProductNo(resultSet.getInt("product_no"));
				vo.setProductName(resultSet.getString("product_name"));
				vo.setProductPrice(resultSet.getInt("product_price"));
				vo.setProductLocation(resultSet.getString("product_location"));
				vo.setProductAmount(resultSet.getInt("product_amount"));
				products.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}
	
	@Override
	public List<ProductVO> productSelect(String str) {
		String sql = "select * from product where product_name like '%?%'";
		List<ProductVO> products = new ArrayList<>();
		ProductVO vo;
		try {
			connection = dao.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				vo = new ProductVO();
				
			}
		}
		return vo;
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
