package co.yedam.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainExe {

	public static void main(String[] args) {
		//MysqlDao dao = new MysqlDao();
		//OracleDao dao = new OracleDao();
		Dao dao = new OracleDao();
		
		dao.insert();
		dao.modify();
		dao.search();
		dao.remove();
		
		Map<String, String> map = new HashMap<>();
		map.put("001", "홍길동");
		map.put("002", "김길동");
		
		Set<String> set = map.keySet();
		for (String str : set) {
			System.out.println("키: " + str);
		}
		Set<Map.Entry<String, String>> entSet = map.entrySet();
		
		
		System.out.println(map.get("002"));
	}

}
