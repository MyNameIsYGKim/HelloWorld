package co.yedam.collect.board;

import java.util.Hashtable;
import java.util.Map;

public class UserApp0 {

	Map<String, String> users //
			= new Hashtable<String, String>();

	UserApp0() {
		users.put("user1", "1111");
		users.put("user2", "2222");
		users.put("admin", "3333");
	}

	boolean login(String id, String pw) {
		if (users.containsKey(id)) {
			if (users.get(id).equals(pw)) {
				return true;
			}
		}
		return false;
	}
}
