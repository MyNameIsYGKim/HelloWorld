package co.yedam.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

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
			if(psmt != null)
				psmt.close();
			if(rs != null)
				rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 입력
	boolean addEmp(EmpVO emp) {
		String sql = "insert into emp_temp (emp_id, emp_name, email, address, salary)";
		sql += " values(?, ?, ?, ?, ?)";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmpId());
			psmt.setString(2, emp.getEmpName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getAddress());
			psmt.setInt(5, emp.getSalary());
			int r = psmt.executeUpdate(); // 처리된 건수 반환.
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
	// 목록
	List<EmpVO> empList() {
		String sql = "select * from emp_temp order by emp_id";
		getConn();
		List<EmpVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpId(rs.getInt("emp_id"));
				vo.setEmpName(rs.getString("emp_name"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
				vo.setSalary(rs.getInt("salary"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	// 수정
	boolean editEmp(EmpVO emp) {
		String sql = "update emp_temp set address=?, email=? where emp_id=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getAddress());
			psmt.setString(2, emp.getEmail());
			psmt.setInt(3, emp.getEmpId());
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
	
	// 삭제
	boolean delEmp(int empNO) {
		String sql = "delete emp_temp where emp_id=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empNO);
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
	
	// 단건조회
	EmpVO getEmp(int empNo) {
		String sql = "select * from emp_temp where emp_id=?";
		getConn();
		EmpVO emp = new EmpVO();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empNo);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return emp;
	}
}




















