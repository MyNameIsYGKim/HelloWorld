package co.yedam.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Apple");
		set.add("Banana");
		set.add("Cherry");
		set.add("Apple");
		
		// 반복문.
		Iterator<String> iter = set.iterator(); // 반복자 반환.
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}
		
		// 확장 for.
		for(String fruit : set) { // for(String str : arr) arr의 값을 모두 하나씩 str에 담는다.
			System.out.println(fruit);
		}
		
		set.remove("Apple");
		set.clear();
		
		if(set.isEmpty()) {
			System.out.println("set 비어있음");
		}
		
		// 크기.
		System.out.println("set 크기: " + set.size());
		
		Set<Integer> lotto = new HashSet<>();
		// 1 ~ 10 임의의 번호를 lotto 저장.
		
		while(lotto.size() < 6) {
			int temp = (int) (Math.random() * 45) + 1;
			System.out.println(temp);
			lotto.add(temp);
		}
		System.out.println(lotto);
	}
}
