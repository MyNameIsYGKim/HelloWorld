package co.yedam.hr;

import java.util.List;

public class JdbcExe {

	public static void main(String[] args) {
		int empNo = 00000;
		
		EmpDAO dao = new EmpDAO();
		if(dao.getEmp(empNo) != null) {
			System.out.println("조회: " + dao.getEmp(empNo));
		}else {
			System.out.println("조회 실패.");
		}
		
		System.out.println("end of prog.");
	}
	
}
