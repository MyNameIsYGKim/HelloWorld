package sec01.exam13;

public class StringEqualsExample {
	public static void main(String[] args) {
		
		String var1 = new String("신민철");
		String var2 = "신민철";
		System.out.println(var1 == var2); // == 는 타입을 비교.
		System.out.println(var1.equals(var2)); // .equalse 는 내용을 비교.
	}
}
