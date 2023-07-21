package co.yedam.collect;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExe {

	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		que.offer("홍길동"); // .offer: 값 추가.
		que.offer("김길동");
		que.offer("박길동");
		
		while(!que.isEmpty()) {
			System.out.println(que.poll()); // .poll(): 먼저 들어간애 보여주고 제거.
		}
	}

}
