package co.yedam.collect;

import java.util.ArrayList;
import java.util.List;

import co.yedam.friend.Friend;

public class ArrayListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); // list<type> type과 일치한 타입만 가능.
		list.add("홍길동");
		list.add("김길동");
		list.add("박길동");
		for(int i=0; i < 15; i++) {
			list.add(String.valueOf(i));
		}
//		list.add(10); 불가.
//		list.add(new Friend("김길동", "010-1111"));
		
		String obj = list.get(0); // list[0]   .get(n) n번째 위치 가져오기
		list.set(0, "Hong"); // list[0] = "Hong";  .set(n, value) n번째 값을 value로 바꾸기.
		System.out.println("크기: " + list.size());
		list.remove(0); // list[0] = null;
		System.out.println("크기: " + list.size());
		obj = list.get(0);
		System.out.println(obj);
		
		list.clear();
		System.out.println("크기: " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.printf("[%d]의 위치값 %s \n", i, list.get(i));
		}
//		Integer num = (Integer) list.get(1);
//		System.out.println(obj + ", " + num);
		
		
	}
}
