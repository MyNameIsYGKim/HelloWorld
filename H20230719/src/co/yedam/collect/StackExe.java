package co.yedam.collect;

import java.util.Stack;

public class StackExe {

	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		stack.push("홍길동"); // push(value): value 값을 집어넣음.
		stack.push("김길동");
		stack.push("박길동");
		
		System.out.println("peek() : " + stack.peek()); // peak(): 젤 위에거만 "보여줌"
		
		
//		System.out.println("pop() : " + stack.pop()); // pop(): 젤 위에거 "제거"
//		System.out.println("pop() : " + stack.pop());
//		System.out.println("pop() : " + stack.pop());
		
		while(!stack.isEmpty()) { // .isEmpty : 빈값이면
			System.out.println("pop() : " + stack.pop());
		}
	}

}
