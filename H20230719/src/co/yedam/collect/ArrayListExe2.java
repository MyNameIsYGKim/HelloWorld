package co.yedam.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import co.yedam.friend.Friend;

public class ArrayListExe2 {
	public static void main(String[] args) {
		List<Friend> friends = new ArrayList<>(); // 뒤에 <>는 내용 생략가능.
		friends.add(new Friend("홍길동", "1111"));
		Friend friend = new Friend("김길동", "2222");
		friends.add(friend);
		friends.remove(friend);
		
		System.out.println(friends.size());
		
		List<String> list = new Vector<>(); // ArrayList클래스와 같음.
		list.add("홍길동");
		list.add("김길동");
		list.remove(0);
	}
}
