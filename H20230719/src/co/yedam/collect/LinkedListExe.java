package co.yedam.collect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		List<String> lnk = new LinkedList<>();
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			list.add(0, String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList 걸린시간: " + (end - start));
		
		start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			lnk.add(0, String.valueOf(i));
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList 걸린시간: " + (end - start));
	}
}
